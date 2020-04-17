package pat35_70;
// 得分19/25 一个测试错误，一个超时

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//DATE:2020年3月9日14:26:12
//4
//1 2 4 -1
//4
//7 6 -2 -3
public class p1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(bf.readLine().trim());
		String[] data1 = bf.readLine().split(" ");
		int num2 = Integer.parseInt(bf.readLine().trim());
		String[] data2 = bf.readLine().split(" ");
		long[] arr1 = new long[num1];
		long[] arr2 = new long[num2];
		for (int i = 0; i < num1; i++)
			arr1[i] = Long.parseLong(data1[i]);

		for (int j = 0; j < num2; j++)
			arr2[j] = Long.parseLong(data2[j]);

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		long res = 0;
		for (int i = 0; i < num1 && i < num2; i++) {
			if (arr1[i] >= 0 || arr2[i] >= 0)
				break;

			res += arr1[i] * arr2[i];
		}
		int k, j;
		for (k = num1 - 1, j = num2 - 1; k >= 0 && j >= 0; k--, j--) {

			if (arr1[k] <= 0 || arr2[j] <= 0)
				break;
			res += arr1[k] * arr2[j];
		}
		System.out.print(res);
	}
}