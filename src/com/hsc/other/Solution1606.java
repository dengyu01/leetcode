package com.hsc.other;

import java.util.*;

public class Solution1606 {
    private int max = 0;

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        Server[] servers = new Server[k];
        for (int i = 0; i < k; i++) {
            servers[i] = new Server();
        }
        for (int i = 0; i < arrival.length; i++) {
            getServer(servers, arrival, load[i], i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < servers.length; i++) {
            Server server = servers[i];
            if (server.requests == max) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean getServer(Server[] servers, int[] arrivals, int load, int i) {
        for (int j = 0; j < servers.length; j++) {
            int arrival = arrivals[i];
            int index = (i + j) % servers.length;
            Server server = servers[index];
            if (arrival >= server.end) {
                server.requests ++;
                server.start = arrival;
                server.end = arrival + load;
                if (server.requests > max) {
                    max = server.requests;
                }
                return true;
            }
        }
        return false;
    }

    static class Server {
        int requests;
        int start = 1;
        int end = 1;
    }

    public List<Integer> busiestServers1(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<Integer>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                available.add(busy.poll()[1]);
            }
            if (available.isEmpty()) {
                continue;
            }
            Integer p = available.ceiling(i % k);
            if (p == null) {
                p = available.first();
            }
            requests[p]++;
            busy.offer(new int[]{arrival[i] + load[i], p});
            available.remove(p);
        }
        int maxRequest = Arrays.stream(requests).max().getAsInt();
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequest) {
                ret.add(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution1606 solution1606 = new Solution1606();
        int[] ints = {1, 2, 3, 4, 5};
        int[] load = {5, 2, 3, 3, 3};
        List<Integer> integers = solution1606.busiestServers(3, ints, load);
        System.out.println(integers);
    }
}
