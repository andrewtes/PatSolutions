
import java.math.BigInteger;
import java.util.Scanner;

public class P1023 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String num = scanner.nextLine();
		// 这里的大数转化 函数要学习，碰到数字处理会节省很多时间
		String dounum = new BigInteger(num) .multiply(new BigInteger("2")).toString();

		int[] digits = new int[10];  // 0-9

		for (int i = 0; i < num.length(); i++) {

			digits[num.charAt(i) - '0']++;
		}

		for (int j = 0; j < dounum.length(); j++) {
			digits[dounum.charAt(j) - '0']--;

		}
		boolean flag = true;

		for (int k = 0; k < digits.length; k++) {
			if (digits[k] != 0) {

				flag = false;
				break;
			}
		}

		if (flag) {
			System.out.println("Yes");
		} else
			System.out.println("No");

		System.out.print(dounum);
	}
}
