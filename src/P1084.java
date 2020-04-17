package pat71_100;
// date: 3/11  score 20/20
import java.util.*;

// 7_This_is_a_test
//_hs_s_a_es
public class P1084 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine().toUpperCase(); // 这一步全部转化成大写 方便后面进行判断
		String s2 = scanner.nextLine().toUpperCase();

		Set<Character> set = new HashSet<>();
		List<Character> res = new ArrayList<>();

		int i = 0;
		int j = 0;

		while (j < s2.length()) {
			if (s1.charAt(i) != s2.charAt(j)) {
				if (!set.contains(s1.charAt(i))) {
					set.add(s1.charAt(i));
					res.add(s1.charAt(i));
				}
				i++;
			} else {

				i++;
				j++;
			}
		}
		for (; i < s1.length(); i++) {
			if (!set.contains(s1.charAt(i))) {
				set.add(s1.charAt(i));
				res.add(s1.charAt(i));
			}
		}
		for (Character ch : res)
			System.out.print(ch);
	}
}
