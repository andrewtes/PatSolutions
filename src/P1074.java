package pat71_100;
// date: 3/15
// 00100 6 4
//00000 4 99999
//00100 1 12309
//68237 6 -1
//33218 3 00000
//99999 5 68237
//12309 2 33218

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P1074 {

	public static void main(String[] args) throws IOException {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = scanner.readLine().split(" ");
		int start = Integer.parseInt(nums[0]);
		int N = Integer.parseInt(nums[1]);
		int K = Integer.parseInt(nums[2]);

		int[][] data = new int[100000][2];
		int[] list = new int[10000];
		for (int i = 0; i < N; i++) {
			String[] Nodeinfo = scanner.readLine().split(" ");
			int address = Integer.parseInt(Nodeinfo[0]);
			int val = Integer.parseInt(Nodeinfo[1]);
			int next = Integer.parseInt(Nodeinfo[2]);

			data[address][0] = val;
			data[address][1] = next;
		}

		int sum = 0;            // sum 有效结点的个数
		while (start != -1) {  // 存储有效的结点的起始地址， 连续存储
			list[sum++] = start;
			start = data[start][1];
		}

		Revers(list, sum - 1, K);
		for (int j = 0; j < sum - 1; j++) {
			// list[j] 当前结点的地址 data[list[j]][0] 当前结点的val list[j+1] 下一个结点的地址
			System.out.printf("%05d %d %05d\n", list[j], data[list[j]][0], list[j + 1]);

		}
		// 对于最后一个结点， 他没有下一个结点在list中， 因此它的next结点输出-1
		System.out.printf("%05d %d -1", list[sum - 1], data[list[sum - 1]][0]);

	}

	// K 个结点一反转，[0 , k-1] [k , 2k-1] [2k , 3k-1]\
	// 我们让i 从0 开始，每次递增k ，如果i+k-1 (右端点) 大于>end 说明超了整个区间的最右端，此时停止反转、
	// 因此循环的条件就是 i+k-1<=end 在这个区间中 ， 进行反转操作
	// 这个多看看，有一点难度
	public static void Revers(int[] list, int end, int k) { // end 是数组最后一个有效元素的位置
		int i = 0;
		while (i + k - 1 <= end) {

			RevserSqu(list, i, i + k - 1);
			i = i + k;
		}
	}

	// 反转 [start , end ]之间的结点地址 这个比较简单
	public static void RevserSqu(int[] list, int start, int end) {
		while (start < end) {
			int temp;
			temp = list[start];
			list[start] = list[end];
			list[end] = temp;
			start++;
			end--;

		}
	}
}
