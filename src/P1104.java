package pat1101_1155;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// date: 3/11  算法复杂度O(n^3) 15/20
//4
//0.1 0.2 0.3 0.4
public class P1104 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String[] info = bf.readLine().split(" ");
		double res = 0;
		for (int i = 1; i <= N; i++) {
			res += (i) * (N + 1 - i) * Double.parseDouble(info[i - 1]);
		}
		System.out.println(res);
	}
}
