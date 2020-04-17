package pat1101_1155;

import java.util.Scanner;

// date: 3/14  score 16/20
// N queens
// 4
//8 4 6 8 2 7 1 3 5
//9 4 6 7 2 8 1 9 5 3
//6 1 5 2 6 4 3
//5 1 3 5 2 4
public class P1128 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lines = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < lines; i++) {
			int N = scanner.nextInt();
			int[] arr = new int[N];
			for (int j = 0; j < N; j++)
				arr[j] = scanner.nextInt();
			if (Isleg(arr))
				System.out.print("Yes");
			else
				System.out.print("No");
			if (i != lines - 1)
				System.out.println();
			scanner.nextLine();
		}
	}

	static boolean Isleg(int[] array) {
		boolean[] col = new boolean[array.length];
		boolean[] dig1 = new boolean[array.length * 2 - 1];
		boolean[] dig2 = new boolean[array.length * 2 - 1];

		for (int k = 0; k < array.length; k++) {

			if (col[array[k] - 1])
				return false;
			col[array[k] - 1] = true;
			if (dig1[array[k] - 1 + k])
				return false;
			dig1[array[k] - 1 + k] = true;

			if (dig2[k - (array[k] - 1) + array.length - 1])
				return false;
			dig2[k - (array[k] - 1) + array.length - 1] = true;

		}
		return true;
	}

}
