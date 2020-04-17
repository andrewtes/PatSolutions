package pat35_70;

import java.util.Scanner;

// date :3/11
// 只得了两分
public class P1061 {
	static String[] date = {"MON", "TUE", "WED", "THU",
			"FRI", "SAT", "SUN"};

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		String s2 = scanner.nextLine();
		String s3 = scanner.nextLine();
		String s4 = scanner.nextLine();
		String day = "";
		int hour = 0;
		int minute = 0;
		int i;
		for (i = 0; i < Math.min(s1.length(), s2.length()); i++) {
			if (s1.charAt(i) == s2.charAt(i) && s1.charAt(i) <= 'G' && s1.charAt(i) >= 'A') {
				day = date[s1.charAt(i) - 'A'];
				break;
			}
		}
		for (i = i + 1; i < Math.min(s1.length(), s2.length()); i++) {

			if (s1.charAt(i) == s2.charAt(i)  && (s1.charAt(i) >='0' && s1.charAt(i) <='9'  || s1.charAt(i)<='N' &&
			s1.charAt(i)>='A')) {
				if (s1.charAt(i) >= '0' && s1.charAt(i) <= '9')
					hour = s1.charAt(i)-'0';
				else
					hour = s1.charAt(i) - 'A' + 10;
				break;
			}


		}

		for (int j = 0; j < Math.min(s3.length(), s4.length()); j++) {

			if (s3.charAt(j) == s4.charAt(j) && s3.charAt(j) =='s') {
				minute = j;
				break;

			}
		}
		System.out.printf("%s %02d:%02d", day, hour, minute);
	}


}
