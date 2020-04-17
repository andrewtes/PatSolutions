package pat35_70;

import java.util.*;

// date : 3/10
//score : 30 /30

// 20 9 24
//10 2 4 3 5 10 2 18 9 7 2 2 1 3 12 1 8 6 2 2
//00 4 01 02 03 04
//02 1 05
//04 2 06 07
//03 3 11 12 13
//06 1 09
//07 2 08 10
//16 1 15
//13 3 14 16 17
//17 2 18 19
public class P1053 {

	static List<List<Integer>> res = new ArrayList<>(); // 里面存放的是路径的权重
	static boolean[] used;
	static boolean[] Isparent;
	static int[] wight;
	static int target;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nodeNum = scanner.nextInt();
		int noleftnum = scanner.nextInt();
		target = scanner.nextInt();
		scanner.nextLine();

		wight = new int[nodeNum];
		used = new boolean[nodeNum];
		Isparent = new boolean[nodeNum];

		for (int i = 0; i < nodeNum; i++) {
			wight[i] = scanner.nextInt();   // 所有结点的权重
		}
		scanner.nextLine();
		int[][] tree = new int[nodeNum][nodeNum];
		for (int j = 0; j < noleftnum; j++) {
			int ID = scanner.nextInt();
			Isparent[ID] = true;       // 这是一个父节点
			int childnum = scanner.nextInt();
			for (int k = 0; k < childnum; k++) {
				int childID = scanner.nextInt();
				tree[ID][childID] = 1; // 树可以认为是有向无环图
			}
			scanner.nextLine();
		}

		List<Integer> wightlist = new ArrayList<>();
		DFS(tree, 0, wight[0], wightlist);
		// 对结果进行排序
		Collections.sort(res, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {// 如果o1比 o2  大 o1 会排在后面
				int length = Math.min(o1.size(), o2.size());
				for (int i = 0; i < length; i++) {
					if (o1.get(i) != o2.get(i))
						return o2.get(i) - o1.get(i);
				}
				return 0;
			}
		});


		for (int k = 0; k < res.size(); k++) {
			for (int m = 0; m < res.get(k).size(); m++) {

				System.out.print(res.get(k).get(m));
				if (m != res.get(k).size() - 1)
					System.out.print(" ");
			}
			if (k != res.size() - 1)
				System.out.println();
		}
	}

	static void DFS(int[][] tree, int start, int totalwight, List<Integer> wightlist) { // 访问标记数组不需要使用 因为树没有环
		if (!Isparent[start]) {
			wightlist.add(wight[start]);
			if (totalwight == target)
				res.add(new ArrayList<>(wightlist));
			return;
		}

		wightlist.add(wight[start]);
		used[start] = true;

		for (int i = 0; i < tree.length; i++) {

			if (tree[start][i] == 1 && !used[i]) {

				DFS(tree, i, totalwight + wight[i], wightlist);
				used[i] = false;
				wightlist.remove(wightlist.size() - 1);
			}
		}
	}

}
