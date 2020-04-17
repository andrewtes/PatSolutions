package pat1101_1155;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//8
//1 -
//- -
//0 -
//2 7
//- -
//- -
//5 -
//4 6
public class P1102 {
    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static int nums;
    static int cnts = 0;
    static boolean[] notRoot;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        nums = Integer.parseInt(bf.readLine().trim());
        nodes = new Node[nums];

        notRoot = new boolean[nums];
        // 建立静态二叉树 数组中一个位置一个节点
        for (int i = 0; i < nums; i++) {
            String[] info = bf.readLine().trim().split(" ");
            nodes[i] = new Node(-1, -1);
            if (!info[0].equals("-")) {
                nodes[i].left = Integer.parseInt(info[0]);
                notRoot[nodes[i].left] = true;
            }
            if (!info[1].equals("-")) {
                nodes[i].right = Integer.parseInt(info[1]);
                notRoot[nodes[i].right] = true;
            }
        }
        int root = -1;  // 寻找根节点
        for (int i = 0; i < nums; i++) {
            if (!notRoot[i]) {
                root = i;
                break;
            }
        }

        invert(root); // 翻转二叉树
        LevelOrder(root); // 层序遍历
        cnts = 0; // 让cnts 归0
        System.out.println(); // 输出换行
        InorderTraver(root); // 中序遍历
    }

    // 翻转二叉树
    static void invert(int root) {
        if (root == -1) // 这是一个空节点，因为我们的节点编号是从 0 .....nums-1
            return;
        invert(nodes[root].left); // 递归翻转左子树
        invert(nodes[root].right); // 递归翻转右子树
        int left = nodes[root].left;    // 下面四行是左右孩子互换，交换都是发生在递归的回溯过程中
        int right = nodes[root].right;
        nodes[root].left = right;
        nodes[root].right = left;
    }

    // 二叉树的中序遍历
    static void InorderTraver(int root) {
        if (root == -1)
            return;
        InorderTraver(nodes[root].left);
        System.out.print(root);
        cnts++;
        if (cnts != nums)
            System.out.print(" ");
        InorderTraver(nodes[root].right);

    }

    // 二叉树的层序遍历
    static void LevelOrder(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int val = queue.poll();
            System.out.print(val);
            cnts++;
            if (cnts != nums)
                System.out.print(" ");

            if (nodes[val].left != -1)
                queue.offer(nodes[val].left);
            if (nodes[val].right != -1)
                queue.offer(nodes[val].right);
        }
    }


}
