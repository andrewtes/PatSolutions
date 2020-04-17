package pat71_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//9 1.80 1.00
//1 5 4 4 -1 4 5 3 6
public class P1090 {
    static class Node {
        List<Integer> children = new ArrayList<>();
    }

    static int nodeNum;
    static double price;
    static double r;
    static int maxDepth = -1;
    static int num = 0;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bf.readLine().trim().split(" ");
        nodeNum = Integer.parseInt(info[0]);
        price = Double.parseDouble(info[1]);
        r = Double.parseDouble(info[2]) / 100;
        int root = -1;
        nodes = new Node[nodeNum];
        for (int i = 0; i < nodeNum; i++)
            nodes[i] = new Node();

        String[] data = bf.readLine().split(" ");
        for (int i = 0; i < nodeNum; i++) {
            int supply = Integer.parseInt(data[i]);
            if (supply == -1)
                root = i;
            else
                nodes[supply].children.add(i); // 把孩子节点添加进去

        }
      //  DFS(root, 0);
        BFS(root);
        System.out.printf("%.2f %d", Math.pow((1 + r), maxDepth) * price, num);

    }

    // 最大深度的叶子节点有多少个，方案是：到达叶子节点时，判断当前深度是否大于最大深度，如果大于
    // num=1(最大深度节点个数)更新最大深度，如果小于，直接返回，如果等于，num++
    static void DFS(int root, int depth) {
        if (nodes[root].children.size() == 0) {
            if (depth > maxDepth) {
                maxDepth = depth;
                num = 1;
            } else if (depth == maxDepth) {
                num++;
            }
            return;
        }
        int childrenNum = nodes[root].children.size();
        for (int i = 0; i < childrenNum; i++) {
            DFS(nodes[root].children.get(i), depth + 1);
        }
    }

    static void BFS(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        int depth =  0 ;
        while (!queue.isEmpty()) {

            int size = queue.size() ;
            num = size ; // 最后一次队列中的元素个数就是最后一层的元素个数
            while (size !=0){
                int node = queue.poll() ;
                int childrenNum = nodes[node].children.size(); // 为了避免在循环中每次都进行个数计算
                for(int i =0;i<childrenNum ;i++){
                    queue.offer(nodes[node].children.get(i)) ;
                }
                size -- ;
            }
            maxDepth ++ ;
        }

    }


}
