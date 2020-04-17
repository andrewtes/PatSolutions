package pat35_70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// date: 3/10  score 18/25
// date:3/13  modify 22/25 一个测试用例超时

// 5 00001
//11111 100 -1
//00001 0 22222
//33333 100000 11111
//12345 -1 33333
//22222 1000 12345
public class P1052 {
	static class Node {
		int start;
		int val;
		int next;
		int flag;

		public Node(int start, int val, int next, int flag) {
			this.start = start;
			this.val = val;
			this.next = next;
			this.flag = flag;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		Node[] list = new Node[100000];
		String[] numInfo = scanner.readLine().split(" ");
		int nums = Integer.parseInt(numInfo[0]);
		int start = Integer.parseInt(numInfo[1]);

		for (int i = 0; i < nums; i++) {

			String[] NodeInfo = scanner.readLine().split(" ");

			int nodeId = Integer.parseInt(NodeInfo[0]);
			int val = Integer.parseInt(NodeInfo[1]);
			int next = Integer.parseInt(NodeInfo[2]);
			list[nodeId] = new Node(nodeId, val, next, 0);
		}
		List<Node> res = new ArrayList<>();
		while (start != -1) {  // 这样写很巧妙
			list[start].flag = 1;
			res.add(list[start]);  // 不能直接拿原来的数组进行排序，因为有些位置是null 先把数据导到list中
			start = list[start].next;

		}


		Collections.sort(res, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.flag != o2.flag)
					return -(o1.flag - o2.flag);
				else
					return o1.val - o2.val;
			}
		});

		if (res.size() == 0) {
			System.out.print("0 -1");
			return;
		}

		System.out.printf("%d %05d\n", res.size(), res.get(0).start);
		for (int i = 0; i < res.size(); i++) {

			if (i != res.size() - 1) {
				System.out.printf("%05d %d %05d\n", res.get(i).start, res.get(i).val, res.get(i + 1).start);
			} else
				System.out.printf("%05d %d -1", res.get(i).start, res.get(i).val);
		}
	}

}
