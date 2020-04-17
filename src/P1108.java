package pat1101_1155;
// date: 3/14  score :15/20
// 7
//5 -3.2 aaa 9999 2.3.4 7.123 2.35

import java.util.Scanner;

public class P1108 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int nums = Integer.parseInt(scanner.nextLine());
		double res = 0.0;
		String[] lines = scanner.nextLine().trim().split(" ");
		int cnts = 0;
		for (int i = 0; i < lines.length; i++) {
			try {
				double d = Double.parseDouble(lines[i]);
				if(d * 100 %1 !=0 || d >1000 || d<-1000){
					System.out.printf("ERROR: %s is not a legal number\n", lines[i]);
				}
				else {
					res += d ;
					cnts ++ ;
				}
			} catch (Exception e) {
				System.out.printf("ERROR: %s is not a legal number\n", lines[i]);
			}
		}
		if (cnts == 0)
			System.out.print("The average of 0 numbers is Undefined");
		else
			System.out.printf("The average of %d numbers is %.2f", cnts, res / cnts);
	}
}
