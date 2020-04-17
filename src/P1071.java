package pat71_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// Can1: "Can a can can a can?  It can!"
public class P1071 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine().trim().toLowerCase();
		int len = s.length();
		Map<String, Integer> map = new HashMap<>();

		int i = 0;
		while (i < len) {

			StringBuilder stringBuilder = new StringBuilder();
			while (i < len && vaild(s.charAt(i))) {
				stringBuilder.append(s.charAt(i));
				i++;
			}

			if (stringBuilder.length() != 0) {  // 如果单词非空
				String temp = stringBuilder.toString();
				if (map.containsKey(temp)) {
					int cnts = map.get(temp);
					map.put(temp, cnts + 1);
				} else
					map.put(temp, 1);
			}

			while (i < len && !vaild(s.charAt(i)))
				i++;
		}

		int max = 0;
		String res = "";
		for (String key : map.keySet()) {
			if (map.get(key) > max) {
				max = map.get(key);
				res = key;
			}
		}

		System.out.printf("%s %d", res, max);


	}

	public static boolean vaild(char a) {

		if (a >= '0' && a <= '9')
			return true;
		else if (a >= 'a' && a <= 'z')
			return true;
		else if (a >= 'A' && a <= 'Z')
			return true;

		return false;
	}


}
