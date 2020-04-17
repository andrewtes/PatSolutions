

import java.util.Scanner;
// 电梯
public class P1008 {

	public static void main(String[] args) {
		// 定义上一层和当前层
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		int pre = 0;
		int res = 0;

		for (int j = 0; j < N; j++) {
			int current = input.nextInt(); //
			if (current - pre > 0) {
				res += (current - pre) * 6 + 5;
				pre = current;
			} else if (current - pre < 0) {
				res += (pre - current) * 4 + 5;
				pre = current ;
			} else {
				res += 5;
			}
		}
		System.out.print(res);
	}
}
