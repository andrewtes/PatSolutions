
//一个数N(为十进制)，判断他是否为质数
//将N转换为D进制   翻转看其十进制的值是否为质数


import java.util.Scanner;

public class P1015 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		while (true) {

			int num = input.nextInt();
			if (num < 0)
				break;
			int radx = input.nextInt();

			String s = swit(num, radx);
			int revalue = Integer.valueOf(s, radx);
			if (isPrime(num) && isPrime(revalue))
				System.out.println("Yes");
			else
				System.out.println("No");

		}


	}

	static String swit(int num, int radx) {

		StringBuilder stringBuilder = new StringBuilder();
		while (num != 0) {
			stringBuilder.append(String.valueOf(num % radx));
			num /= radx;
		}
		return stringBuilder.toString();
	}


	static boolean isPrime(int num) {
		if (num == 1)
			return false;
		else if (num == 2)
			return true;

		int temp = num / 2;

		for (int i = 2; i <= temp; i++) {
			if (num % i == 0)
				return false;

		}
		return true;
	}
}
