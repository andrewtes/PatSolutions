package pat71_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//00100 5
//99999 -7 87654
//23854 -15 00000
//87654 15 -1
//00000 -15 99999
//00100 21 23854
public class P1097 {
	static class Node {
		int address;
		int value;
		int next;
		int order;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int maxn = 100005;
		int table = 1000010;
		String[] info = bf.readLine().split(" ");
		int start = Integer.parseInt(info[0]); // 起始地址
		int nums = Integer.parseInt(info[1]); // 结点的个数
		boolean[] IsExist = new boolean[table];
		Node[] nodes = new Node[maxn];
		for (int i = 0; i < maxn; i++) {
			nodes[i] = new Node();
			nodes[i].order = 2 * maxn; // 初始时都表示为无效结点
		}
		for (int i = 0; i < nums; i++) {
			String[] nodeInfo = bf.readLine().split(" ");
			int address = Integer.parseInt(nodeInfo[0]);
			int value = Integer.parseInt(nodeInfo[1]);
			int next = Integer.parseInt(nodeInfo[2]);
			nodes[address].address = address;
			nodes[address].value = value;
			nodes[address].next = next;

		}

		int coutvaild = 0; // 有效结点的个数
		int countRemove = 0;  // 删除的结点的个数
		int p = start;
		while (p != -1) {
			int v = Math.abs(nodes[p].value);
			if (!IsExist[v]) {
				IsExist[v] = true;
				nodes[p].order = coutvaild++;
			} else {
				nodes[p].order = maxn + countRemove++;
			}
			p = nodes[p].next;
		}

		Arrays.sort(nodes, (n1, n2) -> (n1.order-n2.order));
		int count = coutvaild + countRemove;
		for (int j = 0; j < count; j++) {

			if (j != coutvaild - 1 && j != count - 1) {

				System.out.printf("%05d %d %05d\n", nodes[j].address
						, nodes[j].value, nodes[j + 1].address); // 排序后next 都该改变了
			} else {

				System.out.printf("%05d %d -1\n", nodes[j].address,
						nodes[j].value);
			}
		}
	}
}
