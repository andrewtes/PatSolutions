

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1010 {

	static String[] map = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a",
			"b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
			"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z"};


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] data = line.split(" ");
		String num1 = data[0];
		String num2 = data[1];
		int tag = Integer.valueOf(data[2]); // 告诉是哪个数字
		int radx = Integer.valueOf(data[3]);// 已经给了多少进制

		if (tag == 1) {
			int swit = getDec(num1, radx);
			for (int i = 2; i <= 36; i++) {
				String s = getAnyrax(swit, i);
				if (s.equals(num2)) {

					System.out.print(i);
					return;
				}
			}
			System.out.print("Impossible");
		}


		if (tag == 2) {
			int swit = getDec(num2, radx);
			for (int i = 2; i <= 36; i++) {
				String s = getAnyrax(swit, i);
				if (s.equals(num1)) {

					System.out.print(i);
					return;
				}
			}
			System.out.print("Impossible");
		}

	}

	// 把已知进制的数字转成10进制
	public static int getDec(String num, int radx) {
		int res = 0;
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) >= '0' && num.charAt(i) <= '9')
				res += (num.charAt(i) - '0') * Math.pow(radx, num.length() - i - 1);
			else
				res += (num.charAt(i) - 'a' + 10) * Math.pow(radx, num.length() - i - 1);
		}
		return res;
	}

	public static String getAnyrax(int num, int radx) {
		List<String> res = new ArrayList<>();
		while (num != 0) {
			res.add(map[num % radx]);
			num = num / radx;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = res.size() - 1; i >= 0; i--)
			stringBuilder.append(res.get(i));

		return stringBuilder.toString();
	}


}
