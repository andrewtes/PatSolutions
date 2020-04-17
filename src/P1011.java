

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class P1011 {
	static char[] map = {'W', 'T', 'L'};
	static List<Character> res = new ArrayList<>();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double[][] data = new double[3][3];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				data[i][j] = scanner.nextDouble();
			}
		}
		double resu = 1.0;
		for (int i = 0; i < 3; i++) {

			resu *= getMax(data[i]);
		}
		for (int i = 0; i < res.size(); i++)
			System.out.printf("%c " , res.get(i));

		System.out.printf("%.2f", (resu * 0.65 - 1) * 2);

	}

	static double getMax(double[] arr) {
		double max = arr[0];
		int index = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}
		res.add(map[index]);
		return max;
	}


}
