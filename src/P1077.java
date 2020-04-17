package pat71_100;
// date : 3/11  score 17/20   最长公共后缀
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class P1077 {
	static int minLength = 2000;

	public static void main(String[] args) throws IOException {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>();
		int nums = Integer.valueOf(scanner.readLine());
		for (int i = 0; i < nums; i++) {

			list.add(rever(scanner.readLine().trim()));

		}

		char[] res = new char[minLength];
		int cnts = 0;
		String s1 = list.get(0);
		for (int i = 0; i < minLength; i++) {
			char ch = s1.charAt(i);
			boolean flag = false;
			for (int j = 1; j < list.size(); j++) {
				if (list.get(j).charAt(i) != ch) {
					flag = true;
					break;
				}
			}

			if (flag)
				break;
			else
				res[cnts++] = ch;
		}
		if (cnts == 0)
			System.out.print("nai");
		else
			for (int k = cnts - 1; k >= 0; k--)
				System.out.print(res[k]);

	}

	public static String rever(String s) {
		if (s.length() < minLength)
			minLength = s.length();
		return new StringBuilder(s).reverse().toString();
	}

}
