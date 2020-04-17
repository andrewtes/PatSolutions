package pat35_70;
// date: 3/10
// 0/20 全部超时

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1050 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s1 = bf.readLine().trim();
		String s2 = bf.readLine().trim();
		boolean[] sh = new boolean[200];
		StringBuilder stringBuilder = new StringBuilder();
		int len1 = s1.length();
		int len2 = s2.length();

		for (int i = 0; i < len2; i++) {
			sh[s2.charAt(i)] = true;
		}
		for (int j = 0; j < len1; j++) {
			if (!sh[s1.charAt(j)])
				stringBuilder.append(s1.charAt(j));
		}
		System.out.print(stringBuilder.toString());

	}

}


