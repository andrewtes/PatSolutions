package pat1101_1155;

import java.math.BigInteger;
import java.util.Scanner;

//date  : 3/13   score 14/20
// 97152
public class P1136 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine().trim() ;
		for(int i =0 ;i< 10 ;i++){

			if( ! IsPal(s)) {
				String rev = Srev(s) ;
				String calu = Calu(s , rev) ;

				System.out.printf("%s + %s = %s\n", s, rev , calu);
				s = calu ;
			}else {
				System.out.printf("%s is a palindromic number." ,s);
				return;
			}
		}


		System.out.print("Not found in 10 iterations.");
	}

	static boolean IsPal(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {

			if (s.charAt(i++) != s.charAt(j--))
				return false;

		}
		return true;
	}

	static String Calu(String s, String srev) {

		BigInteger bigInteger = new BigInteger(s);
		BigInteger bigInteger1 = new BigInteger(srev);

		return bigInteger.add(bigInteger1).toString();
	}

	static String Srev(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.append(s).reverse().toString();

	}

}
