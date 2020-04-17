package pat71_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

//6
//Push 1
//Push 2
//Push 3
//Pop
//Pop
//Push 4
//Pop
//Pop
//Push 5
//Push 6
//Pop
//Pop
public class P1086 {
    static class Node {
        Node left, right;
        int val;

        public Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

    }

    static int cnts;
    static int num = 0;

    public static void main(String[] args) throws IOException {
        Deque<Integer> stack = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        cnts = Integer.parseInt(bf.readLine().trim());
        int[] pre = new int[cnts];
        int[] in = new int[cnts];
        int countPre = 0;
        int countIn = 0;
        for (int i = 0; i < cnts * 2; i++) {
            String[] info = bf.readLine().trim().split(" ");
            if (info.length == 2) {
                stack.push(Integer.parseInt(info[1]));
                pre[countPre++] = Integer.parseInt(info[1]);

            } else {
                in[countIn++] = stack.pop();
            }
        }

        Node root = CreatTree(pre, in, 0, cnts - 1, 0, cnts - 1);
        postTraver(root);

    }

    public static Node CreatTree(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight)
            return null;
        int rootData = preOrder[preLeft]; // 先序的第一个元素，当前的子树的根节点
        int rootIndex = -1;
        for (int i = inLeft; i <= inRight; i++) {
            if (inOrder[i] == rootData) {
                rootIndex = i;
                break;
            }
        }

        Node root = new Node(null, null, rootData); // 创建根节点  递归创建左右子树  这里注意左子树preRight 的起点是preLeft+1
        root.left = CreatTree(preOrder, inOrder, preLeft + 1, preLeft +(rootIndex - inLeft) , inLeft, rootIndex - 1);
        root.right = CreatTree(preOrder, inOrder, preLeft + rootIndex - inLeft+1, preRight, rootIndex + 1, inRight);
        return root;  // 返回根节点
    }

    public static void postTraver(Node root) {
        if (root == null)
            return;
        postTraver(root.left);
        postTraver(root.right);
        System.out.print(root.val);
        num++;
        if (num != cnts)
            System.out.print(" ");

    }


}
