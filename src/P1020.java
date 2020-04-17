

import java.util.*;

public class P1020 {
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
		int num = scanner.nextInt();
		int[] post = new int[num];
		int[] inord = new int[num];
		for (int i = 0; i < num; i++)
			post[i] = scanner.nextInt();
		for (int j = 0; j < num; j++)
			inord[j] = scanner.nextInt();

		Node root = CreatTree(post, inord, 0, num - 1, 0, num - 1);

		Queue<Node> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		queue.offer(root);

		while (queue.size() != 0) {
			Node node = queue.poll();
			list.add(node.val);
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if (i != list.size() - 1)
				System.out.print(' ');

		}


	}

	static Node CreatTree(int[] post, int[] inord, int Pstart, int Pend, int Istart, int Iend) {
		if (Pstart  > Pend) {
			return null ;
		}

		int rootData = post[Pend];
		int index = -1;
		for (int i = Istart; i <= Iend; i++) {
			if (inord[i] == rootData) {
				index = i;
				break;
			}
		}
		Node root = new Node(rootData, null, null);
		int leftInStart = Istart;
		int leftInend = index - 1;
		int rightStart = index + 1;
		int rightend = Iend;

		int leftPstart = Pstart;
		int leftPend = leftPstart - 1 + (leftInend - leftInStart + 1);
		int rightPsart = leftPend + 1;
		int rightPend = Pend - 1;

		root.left = CreatTree(post, inord, leftPstart, leftPend, leftInStart, leftInend);
		root.right = CreatTree(post, inord, rightPsart, rightPend, rightStart, rightend);
		return root;
	}
}
