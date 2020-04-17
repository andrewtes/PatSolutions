package pat1101_1155;
// date :3/13  score 20/20
//20 5
//23654987725541023819

import java.util.Scanner;

public class P1152 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int stringlength = scanner.nextInt();
		int length = scanner.nextInt();
		scanner.nextLine();
		String nums = scanner.nextLine().trim();
		for (int i = 0; i <= stringlength - length; i++) {

			if (ISprime(nums.substring(i, i + length ))) {
				System.out.print(nums.substring(i, i + length ));
				return;
			}
		}

		System.out.print("404");
	}

	static boolean ISprime(String num) {
		int number = Integer.parseInt(num);
		int temp = (int) Math.sqrt(Integer.valueOf(num));
		for (int i = 2; i <= temp; i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

}
