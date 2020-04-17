package pat01_35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1029 {
	public static void main(String[] args) throws IOException {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		String[] data1 = scanner.readLine().split(" ");
		String[] data2 = scanner.readLine().split(" ");
		int N1 = Integer.parseInt(data1[0]);
		int N2 = Integer.parseInt(data2[0]);
		int[] array1 = new int[N1 + 1];
		int[] array2 = new int[N2 + 1];
		for (int i = 0; i < N1; i++)
			array1[i] = Integer.parseInt(data1[i + 1]);
		for (int j = 0; j < N2; j++)
			array2[j] = Integer.parseInt(data2[j + 1]);
		array1[N1] = Integer.MAX_VALUE;
		array2[N2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		int count = 0;
		int mid = (N1 + N2 - 1) / 2;
		while (count < mid) {
			if (array1[i] < array2[j])
				i++;
			else
				j++;
			count++;
		}
		if (array1[i] < array2[j]) {
			System.out.println(array1[i]);
		} else
			System.out.println(array2[j]);
	}
}

