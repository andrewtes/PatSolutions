package pat35_70;
// date : 2020年3月9日16:09:01
// 满分通过 最长对称子串
import java.util.Scanner;

public class P1040 {
	static int maxlength = 0;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		char[] t = s.toCharArray();

		for (int i = 0; i < t.length ; i++) {

			for (int j = t.length - 1; j >= i; j--) {
				if (t[i] == t[j]) {

					Isrever(t, i, j);

				}
			}

		}
		System.out.print(maxlength);

	}


	static boolean Isrever(char[] string, int start, int end) {
		int i = start ;
		int j = end ;
		while (i <= j) {

			if (string[i] != string[j])
				return false;
			i++;
			j --;
		}
		if((end-start +1)> maxlength)
			maxlength = end -start +1;
		return true;
	}


}
