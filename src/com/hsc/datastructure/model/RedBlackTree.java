package com.hsc.datastructure.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RedBlackTree extends AbstractSelfBalancingBinarySearchTree {
    protected static final RedBlackNode nilNode =
            new RedBlackNode(null, null, null, null, ColorEnum.BLACK);

    protected enum ColorEnum {
        RED, BLACK
    }

    protected static class RedBlackNode extends TreeNode {
        public RedBlackNode(Integer value, TreeNode parent, TreeNode left, TreeNode right, ColorEnum color) {
            super(value, parent, left, right);
            this.color = color;
        }

        private int bh;
        private ColorEnum color;
    }

    @Override
    public void insert(TreeNode node) {
        super.insert(node);
        node.left = nilNode;
        node.right = nilNode;
        root.parent = nilNode;
        insertRBFixup((RedBlackNode) node);
    }

    private void insertRBFixup(RedBlackNode currentNode) {
        // 如果currentNode父节点也是红色的话，需要做修复操作
        while (currentNode.parent != root && ((RedBlackNode) currentNode.parent).color == ColorEnum.RED) {
            RedBlackNode parent = (RedBlackNode) currentNode.parent;
            RedBlackNode grandParent = (RedBlackNode) parent.parent;
            // currentNode是左孩子和右孩子的情况为镜像操作
            if (parent == grandParent.left) {
                // 找currentNode的叔父节点
                RedBlackNode uncle = (RedBlackNode) grandParent.right;
                // 情况1：currentNode的父节点和叔节点都为红
                // currentNode的父节点和叔节点都变黑，currentNode的祖父节点变红，currentNode指向祖父节点
                if (((RedBlackNode) uncle).color == ColorEnum.RED) {
                    parent.color = ColorEnum.BLACK;
                    uncle.color = ColorEnum.BLACK;
                    grandParent.color = ColorEnum.RED;
                    currentNode = grandParent;
                }
                else {
                    // 情况2：currentNode的叔节点为黑，currentNode为父节点的右孩子
                    // currentNode指向其父节点，做左旋操作;
                    if (currentNode == parent.right) {
                        currentNode = parent;
                        leftRotate(currentNode);
                        parent = (RedBlackNode) currentNode.parent;
                    }
                    // 情况3：currentNode的叔节点为黑，currentNode为父节点的左孩子
                    // currentNode的父节点变黑，currentNode的祖父节点变红，对currentNode的祖父节点做右旋操作
                    parent.color = ColorEnum.BLACK;
                    grandParent.color = ColorEnum.RED;
                    rightRotate(grandParent);
                }
            } else if (parent == grandParent.right) {
                RedBlackNode uncle = (RedBlackNode) grandParent.left;
                if (((RedBlackNode) uncle).color == ColorEnum.RED) {
                    parent.color = ColorEnum.BLACK;
                    uncle.color = ColorEnum.BLACK;
                    grandParent.color = ColorEnum.RED;
                    currentNode = grandParent;
                }
                else {
                    if (currentNode == parent.left) {
                        currentNode = parent;
                        rightRotate(currentNode);
                        parent = (RedBlackNode) currentNode.parent;
                    }
                    parent.color = ColorEnum.BLACK;
                    grandParent.color = ColorEnum.RED;
                    leftRotate(grandParent);
                }
            }

        }
        // 根节点可能为红，变黑
        ((RedBlackNode) root).color = ColorEnum.BLACK;
    }

    /**
     * 主要分两种情况，deleteNode有两个子节点、deleteNode子节点个数少于2
     */
    @Override
    public TreeNode delete(TreeNode deleteNode) {
        TreeNode replaceNode = null;
        if (deleteNode != null && deleteNode != nilNode) {
            TreeNode removedOrMovedNode = deleteNode;
            ColorEnum removedOrMovedNodeColor = ((RedBlackNode)removedOrMovedNode).color;

            if (deleteNode.left == nilNode) {
                replaceNode = deleteNode.right;
                rbTreeTransplant(deleteNode, deleteNode.right);
            } else if (deleteNode.right == nilNode) {
                replaceNode = deleteNode.left;
                rbTreeTransplant(deleteNode, deleteNode.left);
            } else {
                // deleteNode有两个子节点， 找到deleteNode的后继替代deleteNode节点
                removedOrMovedNode = getMinimum(deleteNode.right);
                removedOrMovedNodeColor = ((RedBlackNode)removedOrMovedNode).color;
                replaceNode = removedOrMovedNode.right;
                if (removedOrMovedNode.parent == deleteNode) {
                    replaceNode.parent = removedOrMovedNode;
                } else {
                    // y的右孩子移动到y的位置
                    rbTreeTransplant(removedOrMovedNode, removedOrMovedNode.right);
                    // y的右孩子指向z的右孩子（y移动到位置z）
                    removedOrMovedNode.right = deleteNode.right;
                    // y的右孩子（即原来z的右孩子）的父指针指向y
                    removedOrMovedNode.right.parent = removedOrMovedNode;
                }
                rbTreeTransplant(deleteNode, removedOrMovedNode);
                removedOrMovedNode.left = deleteNode.left;
                removedOrMovedNode.left.parent = removedOrMovedNode;
                ((RedBlackNode)removedOrMovedNode).color = ((RedBlackNode)deleteNode).color;
            }

            size--;
            if (removedOrMovedNodeColor == ColorEnum.BLACK) {
                deleteRBFixup((RedBlackNode)replaceNode);
            }
        }

        return replaceNode;
    }

    private void deleteRBFixup(RedBlackNode x) {
        while (x != root && isBlack(x)) {

            if (x == x.parent.left) {
                // 找到兄弟节点
                RedBlackNode w = (RedBlackNode)x.parent.right;
                if (isRed(w)) {
                    // 情况1： w为红色
                    // w和x的父节点颜色对调，对x的父节点左旋，w指向x的新兄弟节点
                    w.color = ColorEnum.BLACK;
                    ((RedBlackNode)x.parent).color = ColorEnum.RED;
                    leftRotate(x.parent);
                    // 转换成情况2、3或4
                    w = (RedBlackNode)x.parent.right;
                }
                if (isBlack(w.left) && isBlack(w.right)) {
                    // 情况2: w黑色，w子节点都是黑
                    // w节点变为红色，x指向其父节点
                    w.color = ColorEnum.RED;
                    x = (RedBlackNode)x.parent;
                } else if (w != nilNode) {
                    if (isBlack(w.right)) {
                        // 情况3： w节点黑色，其右孩子是黑色（case3）
                        // w左孩子变黑，w变红，对w右旋，w指向x的新兄弟节点
                        ((RedBlackNode)w.left).color = ColorEnum.BLACK;
                        w.color = ColorEnum.RED;
                        rightRotate(w);
                        w = (RedBlackNode)x.parent.right;
                    }
                    // 情况4：w节点黑色，其右孩子是红色（case4）
                    // w变为x父节点颜色，x父节点和w右孩子变黑，对x的父节点左旋操作
                    w.color = ((RedBlackNode)x.parent).color;
                    ((RedBlackNode)x.parent).color = ColorEnum.BLACK;
                    ((RedBlackNode)w.right).color = ColorEnum.BLACK;
                    leftRotate(x.parent);
                    x = (RedBlackNode)root;
                } else {
                    x.color = ColorEnum.BLACK;
                    x = (RedBlackNode)x.parent;
                }
            } else {
                // 镜像操作
                RedBlackNode w = (RedBlackNode)x.parent.left;
                if (isRed(w)) {
                    w.color = ColorEnum.BLACK;
                    ((RedBlackNode)x.parent).color = ColorEnum.RED;
                    rightRotate(x.parent);
                    w = (RedBlackNode)x.parent.left;
                }
                if (isBlack(w.left) && isBlack(w.right)) {
                    w.color = ColorEnum.RED;
                    x = (RedBlackNode)x.parent;
                } else if (w != nilNode) {
                    if (isBlack(w.left)) {
                        ((RedBlackNode)w.right).color = ColorEnum.BLACK;
                        w.color = ColorEnum.RED;
                        leftRotate(w);
                        w = (RedBlackNode)x.parent.left;
                    }
                    w.color = ((RedBlackNode)x.parent).color;
                    ((RedBlackNode)x.parent).color = ColorEnum.BLACK;
                    ((RedBlackNode)w.left).color = ColorEnum.BLACK;
                    rightRotate(x.parent);
                    x = (RedBlackNode)root;
                } else {
                    x.color = ColorEnum.BLACK;
                    x = (RedBlackNode)x.parent;
                }
            }

        }
        x.color = ColorEnum.BLACK;
    }

    private boolean isBlack(TreeNode node) {
        return node != null && ((RedBlackNode) node).color == ColorEnum.BLACK;
    }

    private boolean isRed(TreeNode node) {
        return node != null && ((RedBlackNode) node).color == ColorEnum.RED;
    }

    @Override
    protected TreeNode leftRotate(TreeNode node) {
        TreeNode temp = node.right;
        temp.parent = node.parent;

        node.right = temp.left;
        if (node.right != nilNode) {
            node.right.parent = node;
        }

        temp.left = node;
        node.parent = temp;

        if (temp.parent != nilNode) {
            if (node == temp.parent.left) {
                temp.parent.left = temp;
            } else {
                temp.parent.right = temp;
            }
        } else {
            root = temp;
        }

        return temp;
    }

    @Override
    protected TreeNode rightRotate(TreeNode node) {
        TreeNode temp = node.left;
        temp.parent = node.parent;

        node.left = temp.right;
        if (node.left != nilNode) {
            node.left.parent = node;
        }

        temp.right = node;
        node.parent = temp;

        if (temp.parent != nilNode) {
            if (node == temp.parent.left) {
                temp.parent.left = temp;
            } else {
                temp.parent.right = temp;
            }
        } else {
            root = temp;
        }

        return temp;
    }

    protected TreeNode getMinimum(TreeNode node) {
        while (node.left != nilNode) {
            node = node.left;
        }
        return node;
    }

    private void rbTreeTransplant(TreeNode nodeToReplace, TreeNode newNode) {
        if (nodeToReplace.parent == nilNode) {
            this.root = newNode;
        } else if (nodeToReplace == nodeToReplace.parent.left) {
            nodeToReplace.parent.left = newNode;
        } else {
            nodeToReplace.parent.right = newNode;
        }
        newNode.parent = nodeToReplace.parent;
    }

    public boolean isRedBlackTree(RedBlackNode root) {
        if (root == nilNode) {
            return true;
        }
        if (root.color != ColorEnum.BLACK || !isValidBST(root)) {
            return false;
        }


        LinkedList<RedBlackNode> queue = new LinkedList<>();
        queue.offer(root);
        Stack<RedBlackNode> stack = new Stack<>();
        while (!queue.isEmpty()) {
            RedBlackNode poll = queue.poll();
            poll.bh = 0;
            stack.push(poll);
            if (poll.left != null && poll.left != nilNode) {
                queue.offer((RedBlackNode) poll.left);
            }
            if (poll.right != null && poll.right != nilNode) {
                queue.offer((RedBlackNode) poll.right);
            }
        }
        while (!stack.isEmpty()) {
            RedBlackNode pop = stack.pop();
            int bh = 1;
            RedBlackNode left = (RedBlackNode) pop.left;
            RedBlackNode right = (RedBlackNode) pop.right;
            if (pop.color == ColorEnum.RED) {
                if (left.color != ColorEnum.BLACK || right.color != ColorEnum.BLACK) {
                    return false;
                }
                bh = 0;
            }
            if (left.bh != right.bh) {
                return false;
            }
            pop.bh = left.bh + bh;
        }
        return true;
    }

    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        RedBlackNode deleteNode = new RedBlackNode(12, null, null, null, ColorEnum.RED);
        redBlackTree.insert(new RedBlackNode(41, null, null, null, ColorEnum.RED));
        redBlackTree.insert(new RedBlackNode(38, null, null, null, ColorEnum.RED));
        redBlackTree.insert(new RedBlackNode(31, null, null, null, ColorEnum.RED));
        redBlackTree.insert(deleteNode);
        redBlackTree.insert(new RedBlackNode(19, null, null, null, ColorEnum.RED));
        redBlackTree.insert(new RedBlackNode(8, null, null, null, ColorEnum.RED));
        System.out.println(redBlackTree.isValidBST(redBlackTree.root));
        System.out.println(redBlackTree.isRedBlackTree((RedBlackNode) redBlackTree.root));

        deleteNode.color = ColorEnum.RED;
        System.out.println(redBlackTree.isRedBlackTree((RedBlackNode) redBlackTree.root));

        deleteNode.color = ColorEnum.BLACK;
        System.out.println(redBlackTree.isRedBlackTree((RedBlackNode) redBlackTree.root));
        redBlackTree.delete(deleteNode);
//        redBlackTree.delete(redBlackTree.root.left);
        System.out.println(redBlackTree.isRedBlackTree((RedBlackNode) redBlackTree.root));
    }
}
