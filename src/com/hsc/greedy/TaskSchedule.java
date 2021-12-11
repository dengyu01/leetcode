package com.hsc.greedy;

import java.util.*;

public class TaskSchedule {
    static class Task implements Comparable<Task> {
        int index;
        int d;
        int w;

        public Task(int index, int d, int w) {
            this.index = index;
            this.d = d;
            this.w = w;
        }

        @Override
        public String toString() {
            return "a" + index;
        }

        @Override
        public int compareTo(Task task) {
            return this.w < task.w ? 1 : -1;
        }
    }

    public ArrayList<Task> taskSchedule(Task[] tasks) {
        Arrays.sort(tasks);
        // 存不会过期的任务
        ArrayList<Task> A = new ArrayList<>();
        // 存过期的任务
        ArrayList<Task> B = new ArrayList<>();
        for (Task curTask : tasks) {
            if (isA(A, curTask)) {
                A.add(curTask);
            } else {
                B.add(curTask);
            }
        }
        A.sort((task, compare) -> task.d < compare.d ? -1 : 1);
        A.addAll(B);
        return A;
    }

    private boolean isA(ArrayList<Task> A, Task task) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        A.forEach(task1 -> count.put(task1.d, count.getOrDefault(task1.d, 0) + 1));
        count.put(task.d, count.getOrDefault(task.d, 0) + 1);
        int curSum = 0;
        Set<Integer> integers = count.keySet();
        for (Integer t: integers) {
            Integer num = count.get(t);
            curSum += num;
            if (curSum > t) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Task task1 = new Task(1, 4, 70);
        Task task2 = new Task(2, 2, 60);
        Task task3 = new Task(3, 4, 50);
        Task task4 = new Task(4, 3, 40);
        Task task5 = new Task(5, 1, 30);
        Task task6 = new Task(6, 4, 20);
        Task task7 = new Task(7, 6, 10);
        Task[] tasks = new Task[] {task1, task2, task3, task4, task5, task6, task7};

        TaskSchedule task = new TaskSchedule();
        ArrayList<Task> res = task.taskSchedule(tasks);
        System.out.println("最优调度为：" + res);

        for (Task cur: tasks) {
            cur.w = 70 - cur.w;
        }
        ArrayList<Task> res2 = task.taskSchedule(tasks);
        System.out.println("替换w值后，最优调度为："+ res2);
    }
}
