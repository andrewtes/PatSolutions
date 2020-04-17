package pat35_70;

// date : 3/11   score 20 /20
//3.2.1 10.16.27
// 29进制 17进制 几乎无限进制


import java.util.Scanner;

public class P1058 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String[] line = scanner.nextLine().trim().split(" ");
		String[] num1 = line[0].split("\\.");
		String[] num2 = line[1].split("\\.");
		int res1, res2, res3;
		int carry = 0;

		res1 = (Integer.parseInt(num1[2]) + Integer.parseInt(num2[2]) + carry) % 29;
		carry = (Integer.parseInt(num1[2]) + Integer.parseInt(num2[2]) + carry) / 29;


		res2 = (Integer.parseInt(num1[1]) + Integer.parseInt(num2[1]) + carry) % 17;
		carry = (Integer.parseInt(num1[1]) + Integer.parseInt(num2[1]) + carry) / 17;

		res3 = (Integer.parseInt(num1[0]) + Integer.parseInt(num2[0]) + carry);

		System.out.printf("%d.%d.%d", res3, res2, res1);

	}


}
