package pat35_70;

import java.util.Map;
import java.util.Scanner;

// score 17/20 一个测试点超时
// date : 3/10    modify 3/13  使用sum 减少计算
//5 1 2 4 14 9
//3
//1 3
//2 5
//4 1
public class P1046 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int nums = scanner.nextInt();
		int[] array = new int[nums + 1];  // 从数组从1开始进行使用
		int[] sum = new int[nums + 1];  // sum 数组计算
		int distsum = 0;
		for (int i = 1; i < array.length; i++) {
			array[i] = scanner.nextInt();
			distsum += array[i];
			sum[i] = sum[i - 1] + array[i];
		}

		scanner.nextLine();
		int qury = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < qury; i++) {
			int num1 = scanner.nextInt();
			int num2 = scanner.nextInt();
			scanner.nextLine();
			int start = Math.min(num1, num2);
			int end = Math.max(num1, num2);

			int distance1 = sum[end] - sum[start];
			int distance2 = distsum - distance1;
			System.out.print(Math.min(distance1, distance2));

			if (i != qury - 1)
				System.out.println();
		}
	}
}
