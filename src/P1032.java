package pat01_35;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 时间 ： 2020年3月8日
// 一个测试用例错误 一个测试用例超时 21/25
//00001 00002 4
//00001 a 10001
//10001 s -1
//00002 a 10002
//10002 t -1
public class P1032 {
	static class Node {
		int next;
		boolean flag;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = bf.readLine().split(" ");
		int start1 = Integer.parseInt(nums[0]);
		int start2 = Integer.parseInt(nums[1]);
		int N = Integer.parseInt(nums[2]);
		Node[] nodes = new Node[100002];
		for (int i = 0; i < N; i++) {
			String[] info = bf.readLine().split(" ");
			int address = Integer.parseInt(info[0]);
			int next = Integer.parseInt(info[2]);
			nodes[address] = new Node();
			nodes[address].next = next;
		}

		while (start1 != -1) {
			nodes[start1].flag = true;
			start1 = nodes[start1].next;
		}

		while (start2 != -1) {
			if (nodes[start2].flag) {
				System.out.printf("%05d",start2);
				return;
			}
			nodes[start2].flag = true;
			start2 = nodes[start2].next;
		}

		System.out.println(-1);
	}

}
