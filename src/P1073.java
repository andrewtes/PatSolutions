package pat71_100;
// date : 3/11 score 12/20
//  [+-][1-9].[0-9]+E[+-][0-9]+  方括号后面的+ 代表可以有多个
// +1.23400E-03
// 0.00123400


import java.math.BigDecimal;
import java.util.Scanner;

public class P1073 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		char flag1 = line.charAt(0); // flag  正负数
		int Eloc = line.indexOf('E'); // E 的位置
		String num = line.substring(1, Eloc); //我们要保留的部分
		char flag2 = line.charAt(Eloc + 1); // flag2 指数的符号
		int exp = Integer.valueOf(line.substring(Eloc + 2)); // 指数的大小

		if (flag1 == '+') {

			if (flag2 == '+') {
				double number = Math.pow(10, exp) * Double.valueOf(num);
				String bigDecimal = new BigDecimal("" + number).toString();
				System.out.print(bigDecimal);
				return;
			} else {

				System.out.print("0.");
				for (int i = 0; i < exp - 1; i++)
					System.out.print("0");

				for (int j = 0; j < num.length(); j++) {
					if (num.charAt(j) == '.')
						continue;
					System.out.print(num.charAt(j));
				}

			}


		} else {

			System.out.print(flag1);
			if (flag2 == '+') {
				double number = Math.pow(10, exp) * Double.valueOf(num);
				String bigDecimal = new BigDecimal(number + "").toPlainString();
				System.out.print(bigDecimal);
				return;
			} else {

				System.out.print("0.");
				for (int i = 0; i < exp - 1; i++)
					System.out.print("0");

				for (int j = 0; j < num.length(); j++) {
					if (num.charAt(j) == '.')
						continue;
					System.out.print(num.charAt(j));
				}

			}


		}


	}
}
