package pat71_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1093 {
	static int mod = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine().trim();
		int len = s.length();
		int[] leftP = new int[len];
		leftP[0] = 0;
		for (int i = 1; i < len; i++) {
			if (s.charAt(i - 1) == 'P')
				leftP[i] = leftP[i - 1] + 1;
			else
				leftP[i] = leftP[i - 1];
		}
		int rightT = 0;
		int res = 0;
		for (int j = len - 2; j >= 1; j--) {
			if (s.charAt(j + 1) == 'T') {
				rightT++;
			}
			if (s.charAt(j) == 'A') {

				res = (res +rightT * leftP[j]) % mod;
			}
		}

		System.out.println(res);

	}

}
