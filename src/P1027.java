package pat01_35;

// 各种进制是之间的转换，特别是 十进制转换成任意进制
// 还有字符串的大写小写 函数


import java.util.Scanner;

public class P1027 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int red = scanner.nextInt();
		int green = scanner.nextInt();
		int bule = scanner.nextInt();

		String marred = Integer.toString(red, 13);
		String greedmar = Integer.toString(green, 13);
		String bulemar = Integer.toString(bule, 13);
		System.out.print("#");
		if(marred.length() ==1)
			System.out.print("0"+marred.toUpperCase());
		else
			System.out.print(marred.toUpperCase());


		if(greedmar.length() ==1)
			System.out.print("0"+greedmar.toUpperCase());
		else
			System.out.print(greedmar.toUpperCase());

		if(bulemar.length() ==1)
			System.out.print("0" +bulemar.toUpperCase());
		else
			System.out.print(bulemar.toUpperCase());
	}
}
