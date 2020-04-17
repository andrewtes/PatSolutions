package pat35_70;
// date: 3/9
// modify 3/13


import java.util.Scanner;

public class P1044 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int target = scanner.nextInt();
		scanner.nextLine();
		int[] data = new int[num + 1];
		int[] sum = new int[num + 1];

		for (int i = 1; i <= num; i++) {
			data[i] = scanner.nextInt();
			sum[i] = sum[i - 1] + data[i];
		}


	}


}
