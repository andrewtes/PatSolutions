package pat71_100;
// 思路是二维搜索， 以i为起点， 让j从i开始，进行连乘， 把连乘的结果放在temp中，如果N%temp!=0 说明以i为起点 j-1为终点
//[i ,,,j-1] 这一段，就是当前的最长连乘积因子。 当内循环退出时，我们判断当前的[i...j-1] 是否比之前的最长连续因子大
// 如果更大，我们就更新first 和last

import java.util.Scanner;

public class P1096 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int maxn = (int) Math.sqrt(N);

		int first = 0;
		int last = 0;
		int len = 0;

		for (int i = 2; i <= maxn; i++) {

			int j;
			int temp = 1;
			for (j = i; j <= maxn; j++) {
				temp *= j;
				if (N % temp != 0) {
					break;
				}
			}
			if (j - i > len) {
				len = j - i;
				first = i;
				last = j - 1;
			}
		}

		if (len == 0) {
			System.out.println(1);
			System.out.println(N);
		} else {
			System.out.println(len);
			for (int k = first; k <= last; k++) {

				if (k != first)
					System.out.print("*");
				System.out.print(k);
			}
		}
	}
}
