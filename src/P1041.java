package pat35_70;
// date:3/13 modify

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P1041 {
	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		int nums = scanner.nextInt();
		int[] data = new int[nums];
		int[] times = new int[10005];
		for (int i = 0; i < nums; i++) {
			data[i] = scanner.nextInt();
			times[data[i]]++;
		}

		for (int j = 0; j < nums; j++) {
			if (times[data[j]] == 1) {
				System.out.print(data[j]);
				return;
			}
		}

		System.out.print("None");
	}
}
