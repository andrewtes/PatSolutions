package pat71_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//10 1.80 1.00
//3 2 3 5
//1 9
//1 4
//1 7
//0 7
//2 6 1
//1 8
//0 9
//0 4
//0 3
public class P1079 {
    static class Node {
        double weight; // 权重
        List<Integer> children = new ArrayList<>();// 孩子节点 这是多叉树

    }

    static Node[] nodes;
    static double res = 0;
    static double price;
    static double increase;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] TreeInfo = bf.readLine().trim().split(" ");
        int nums = Integer.parseInt(TreeInfo[0]);
        price = Double.parseDouble(TreeInfo[1]);
        increase = (Double.parseDouble(TreeInfo[2])) / 100;
        nodes = new Node[nums]; // 创建节点数组  0 号节点就是根节点
        for (int i = 0; i < nums; i++) {

            String[] info = bf.readLine().trim().split(" ");
            nodes[i] = new Node();
            int cnts = Integer.parseInt(info[0]);
            if (cnts == 0) {
                nodes[i].weight = Integer.parseInt(info[1]);
            } else {
                for (int j = 1; j <= cnts; j++) {
                    nodes[i].children.add(Integer.parseInt(info[j]));// 添加孩子节点
                }
            }
        }
        DFS(0 , 0);
        System.out.printf("%.1f",res);


    }

    static void DFS(int root, int depth) {
        if (nodes[root].children.size() == 0) { // 如果到达叶子节点 我们就计算当前值 并返回
            res += Math.pow( (1+increase) , depth)* price * nodes[root].weight;
            return;
        }

        int childrenNum = nodes[root].children.size();
        for(int i = 0 ;i< childrenNum ;i++){

            DFS(nodes[root].children.get(i) , depth+1);
        }
    }

}
