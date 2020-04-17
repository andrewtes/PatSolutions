
// date:3/06  score 20/20

import java.util.Scanner;
// 题意 输入一个正整数，把该数字的每一位记性相加，然后用英文单词输出每一位
public class P1005 {
	private static String[] map = {"zero", "one", "two", "three", "four", "five",
			"six", "seven", "eight", "nine"};

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String str = String.valueOf(input.nextLine());
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Integer.valueOf(String.valueOf(str.charAt(i)));
		}
		String res = String.valueOf(sum);

		for (int i = 0; i < res.length(); i++) {

			int digit = Integer.valueOf(String.valueOf(res.charAt(i)));
			System.out.print(map[digit]);
			if (i != res.length() - 1)
				System.out.print(" ");
		}

	}
}
