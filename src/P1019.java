
// 15分 一个测试没通过， 一个格式错误
import java.util.Scanner;




public class P1019 {
	static String res;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int radx = scanner.nextInt();



		if (isPali(num, radx)) {

			System.out.println("Yes");
		} else
			System.out.println("No");

		for (int i = 0; i < res.length(); i++) {

			System.out.print(res.charAt(i));
			if (i != res.length() - 1)
				System.out.print(" ");

		}


	}

	public static boolean isPali(int num, int radx) {
		if (num == 0){
			res = "0" ;
			return true;

		}

		StringBuilder stringBuilder = new StringBuilder();

		while (num != 0) {
			stringBuilder.append(String.valueOf(num % radx));
			num = num / radx;
		}

		String rever = stringBuilder.toString();
		res = stringBuilder.reverse().toString() ;
		return rever.equals(res);
	}

}
