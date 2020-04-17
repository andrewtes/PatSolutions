package pat1101_1155;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// date: 3/17
// 5
//1 3 2 4 5
public class P1101 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] array = new int[N];
		int[] max = new int[N];
		int[] min = new int[N];
		String[] data = bf.readLine().split(" ");
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(data[i]);
		max[0] = Integer.MIN_VALUE;

		for (int i = 1; i < N ; i++) {
			max[i] = Math.max(max [i - 1], array[i - 1]);
		}
		min[N - 1] = Integer.MAX_VALUE;
		for (int j = N - 2; j >= 0; j--) {
			min[j] = Math.min(min[j + 1], array[j + 1]);
		}
		int cnts = 0;
		int[] res = new int[N];
		for (int k = 0; k < N; k++) {
			if (array[k] > max[k] && array[k] < min[k])
				res[cnts++] = array[k];
		}
		if (cnts == 0)
			System.out.println();
		else {
			Arrays.sort(res , 0 , cnts);
			System.out.println(cnts);
			for (int i = 0; i < cnts; i++) {
				System.out.print(res[i]);
				if (i != cnts - 1)
					System.out.print(" ");
			}
		}
	}
}
