

import java.util.*;
//一个测试用例内存超限
public class p1021 {
	static class Pair {
		int index;
		int depth;

		public Pair(int index, int depth) {
			this.index = index;
			this.depth = depth;
		}
	}

	static boolean[] used;


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();

		int[][] node = new int[num][num];
		for (int i = 0; i < num - 1; i++) {
			int num1 = scanner.nextInt();
			int num2 = scanner.nextInt();
			node[num1 - 1][num2 - 1] = 1;
			node[num2 - 1][num1 - 1] = 1;
		}
		int sum = GetComp(node);
		if (sum != 1) {
			System.out.printf("Error: %d components", sum);
			return;
		}
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < node.length; i++) {
			list.add(new Pair(i + 1, BFS(node, i)));

		}
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.depth > o2.depth)
					return -1;
				else if (o1.depth < o2.depth)
					return 1;
				else {
					if (o1.index > o2.index)
						return 1;
					else if (o1.index < o2.index)
						return -1;
					else
						return 0;
				}
			}
		});

		int dep = list.get(0).depth;
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).depth == dep)
				System.out.println(list.get(i).index);
			else
				break;

		}
	}

	static int GetComp(int[][] num) {

		used = new boolean[num.length];
		int comp = 0;
		for (int i = 0; i < num.length; i++) {
			if (used[i] == false) {
				comp++;
				DFS(num, i);
			}
		}
		return comp;
	}

	static void DFS(int[][] num, int i) {
		if (used[i] == true)
			return;

		used[i] = true;

		for (int j = 0; j < num.length; j++) {
			if (num[i][j] == 1 && used[j] == false)
				DFS(num, j);
		}

		return;
	}

	static int BFS(int[][] num, int start) {
		boolean[] visit = new boolean[num.length];
		Queue<Integer> queue = new LinkedList<>();
		int depth = 0;
		queue.offer(start);

		while (queue.size() != 0) {

			int size = queue.size();
			depth++;
			for (int i = 0; i < size; i++) {

				int node = queue.poll();
				visit[node] = true;
				for (int j = 0; j < num.length; j++) {

					if (num[node][j] == 1 && !visit[j])
						queue.offer(j);
				}
			}

		}
		return depth;
	}


}
