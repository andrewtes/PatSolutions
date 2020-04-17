package pat1101_1155;

import java.util.Arrays;
import java.util.Scanner;

// date : 3/17
// 12
//37 76 20 98 76 42 53 95 60 81 58 93
public class P1105 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.nextLine();
		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = scanner.nextInt();
		Arrays.sort(array);
		reverse(array);

		int resN = -1;
		for (int n = 1; n <= Math.sqrt(N); n++) {
			if (N % n == 0) {
				resN = n;
			}
		}

		int resM = N / resN;


		int[][] res = new int[resM][resN];
		int up = 0;
		int bottom = resM - 1;
		int left = 0;
		int right = resN - 1;
		int current = 0;

		while (current < N) {
			for (int i = left; i <= right; i++)
				res[up][i] = array[current++];
			up++;

			for (int j = up; j <= bottom; j++)
				res[j][right] = array[current++];
			right--;

			for (int k = right; k >= left; k--)
				res[bottom][k] = array[current++];
			bottom--;

			for (int p = bottom; p >= up; p--)
				res[p][left] = array[current++];
			left++;
		}

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j]);
				if (j != res[0].length - 1)
					System.out.print(" ");
			}
			if (i != res.length - 1)
				System.out.println();
		}
	}

	public static void reverse(int[] array) {

		int i = 0;
		int j = array.length - 1;
		while (i < j) {

			int temp;
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;

		}


	}
}
