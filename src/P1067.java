package pat35_70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//10
//3 5 7 2 6 4 9 0 8 1
public class P1067 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String[] data = bf.readLine().split(" ");
		int[] pos = new int[N];
		int cnts = 0; // 统计有多少不在本位上的数字
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(data[i]);
			pos[temp] = i;
			if (temp != i)
				cnts++;
		}
		int k = 1;
		int ans = 0;
		while (cnts > 0) {
			while (pos[0] != 0) { // 0不在本位
				swap(pos, pos[0], pos[pos[0]]);
				ans++;
				cnts--;
			}

			if (pos[0] == 0) { // 0 在本位上

				while (k < N) {

					if (pos[k] != k) {
						swap(pos, 0, pos[k]);
						ans++;
						cnts--;
						break;
					}
				}
				k++;
			}
		}

		System.out.print(ans);
	}

	public static void swap(int[] arr, int i, int j) {

		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


}