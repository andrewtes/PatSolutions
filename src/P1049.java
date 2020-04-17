
// date: 3/10
//score : 22/30
import java.util.Scanner;

public class P1049 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		int res = 0;
		for (int i = 1; i <= N; i++) {

			res += getone(String.valueOf(i));

		}

		System.out.print(res);
	}

	public static int getone(String num) {
		int res = 0;
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) == '1')
				res++;
		}
		return res;
	}
}
