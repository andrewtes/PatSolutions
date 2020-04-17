package pat71_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//23 13
//21 1 23
//01 4 03 02 04 05
//03 3 06 07 08
//06 2 12 13
//13 1 21
//08 2 15 16
//02 2 09 10
//11 2 19 20
//17 1 22
//05 1 11
//07 1 14
//09 1 17
//10 1 18
public class P1094 {
    static class Node {
        List<Integer> children = new ArrayList<>();
    }

    static Node[] nodes;
    static int maxSize = 0;
    static int maxSizeLevel = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bf.readLine().split(" ");
        int peopleNum = Integer.parseInt(info[0]);
        int hasChild = Integer.parseInt(info[1]);
        nodes = new Node[peopleNum + 1]; // 里面的对象默认初始化都是null
        for (int i = 1; i <= peopleNum; i++)
            nodes[i] = new Node();


        for (int i = 0; i < hasChild; i++) {
            String[] dataInfo = bf.readLine().split(" ");
            int parent = Integer.parseInt(dataInfo[0]);
            int nums = Integer.parseInt(dataInfo[1]);

            for (int j = 1; j <= nums; j++) {
                nodes[parent].children.add(Integer.parseInt(dataInfo[j + 1])); // 孩子信息都是从一行数据的下标2开始的
            }
        }
        BFS(1);
        System.out.printf("%d %d" ,maxSize , maxSizeLevel);

    }

    static void BFS(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > maxSize) {
                maxSize = size;
                maxSizeLevel = depth;
            }
            while (size != 0) {

                int node = queue.poll();
                int childrenNum = nodes[node].children.size();
                for (int i = 0; i < childrenNum; i++) {
                    queue.offer(nodes[node].children.get(i));// 孩子节点入队
                }
                size--;
            }

            depth++;
        }
    }
}
