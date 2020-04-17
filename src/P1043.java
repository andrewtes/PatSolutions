package pat35_70;
// date : 2020/03/09
// 搞不定
import java.util.Arrays;
import java.util.Scanner;

//7
//8 6 5 7 10 8 11
public class P1043 {
	static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nodeNum = Integer.valueOf(scanner.nextLine());
		int[] preorder = new int[nodeNum];
		for (int i = 0; i < nodeNum; i++)
			preorder[i] = scanner.nextInt();
		int[] inorder = Arrays.copyOfRange(preorder, 0, preorder.length);
		Arrays.sort(inorder);
		Node root = CreatTree(preorder, inorder, 0, nodeNum, 0, nodeNum);


	}


	static Node CreatTree(int[] preOrder, int[] inorder, int Pstart, int Pend, int Istart, int Iend) {
		if (Pstart > Pend) {
			return null;
		}

		int rootval = preOrder[Pstart];
		int index = -1;
		for (int i = Istart; i <= Iend; i++)
			if (inorder[i] == rootval)
				index = i;
		Node root = new Node(rootval, null, null);
		int Left_in_start = Istart;
		int Left_in_end = Iend;
		int right_in_start = index + 1;
		int right_in_end = Iend;

		int Left_p_start = Pstart + 1;
		int Left_p_end = Pstart + (Left_in_end - Left_in_start + 1);
		int right_p_start = Left_p_end + 1;
		int right_p_end = Pend;

		root.left = CreatTree(preOrder, inorder, Left_p_start, Left_p_end, Left_in_start, Left_in_end);
		root.right = CreatTree(preOrder, inorder, right_p_start, right_p_end, right_in_start, right_in_end);

		return root;
	}




}
