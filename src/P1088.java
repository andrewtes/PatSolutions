package pat71_100;
// date:3/11  score 5

import java.util.Scanner;

//5/3 0/6
public class P1088 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String[] line = scanner.nextLine().split(" "); // 用字符串 因为会有符号
		String num1 = line[0].split("/")[0];
		String dem1 = line[0].split("/")[1];
		String num2 = line[1].split("/")[0];
		String dem2 = line[1].split("/")[1];
		String number1 = getdummy(Long.valueOf(num1), Long.valueOf(dem1));
		String number2 = getdummy(Long .valueOf(num2), Long.valueOf(dem2));
		String addString = add(num1, dem1,num2, dem2);
		String diffString = diff(num1, dem1, num2, dem2);
		String proString = production(num1, dem1, num2, dem2);
		String divString = div(num1, dem1, num2, dem2);
		if (Long.valueOf(number2) < 0)
			number2 = "(" + number2 + ")";
		if (addString.charAt(0) == '-')
			addString = "(" + addString + ")";
		if (diffString.charAt(0) == '-')
			diffString = "(" + diffString + ")";
		if (proString.charAt(0) == '-')
			proString = "(" + proString + ")";
		if (divString.charAt(0) == '-')
			divString = "(" + diffString + ")";

		System.out.printf("%s + %s = %s\n", number1, number2, addString);
		System.out.printf("%s - %s = %s\n", number1, number2, diffString);
		System.out.printf("%s * %s = %s\n", number1, number2, proString);
		System.out.printf("%s / %s = %s", number1, number2, divString);


	}

	public static String add(String num1, String dem1, String num2, String dem2) {

		long dem = Long.valueOf(dem1) * Long.valueOf(dem2);
		Long num = Long.valueOf(num1) * Long.valueOf(dem2) + Long.valueOf(num2) * Long.valueOf(dem1);
		return getdummy(num, dem);


	}

	public static String diff(String num1, String dem1, String num2, String dem2) {

		Long dem = Long.valueOf(dem1) * Long.valueOf(dem2);
		Long num = Long.valueOf(num1) * Long.valueOf(dem2) - Long.valueOf(num2) * Long.valueOf(dem1);
		return getdummy(num, dem);
	}

	public static String production(String num1, String dem1, String num2, String dem2) {

		Long dem = Long.valueOf(dem1) * Long.valueOf(dem2);
		Long num = Long.valueOf(num1) * Long.valueOf(num2);
		return getdummy(num, dem);
	}

	public static String div(String num1, String dem1, String num2, String dem2) {

		if(Long.valueOf(num2) <0){
			num2 = num2.substring(1) ;
			dem2 = "-"+dem2 ;

		}

		Long num = Long.valueOf(num1) * Long.valueOf(dem2);
		Long dem = Long.valueOf(dem1) * Long.valueOf(num2);

		if (dem == 0)
			return "Inf";
		else
			return getdummy(num, dem);
	}

	public static String getdummy(Long num, Long dem) {
		String[] flag = {"", "-"};
		if (num == 0)
			return "0";
		int isneg = 0;
		if (num < 0) {
			isneg = 1;
			num = -num;
		}

		if (num >= dem) {
			Long k = num / dem;
			Long mod = num % dem;
			Long g = gcd(mod , dem) ;
			if (mod == 0)
				return flag[isneg] + k;
			else
				return flag[isneg] + k + " " + (mod/g) + "/" + dem/g;
		} else
			return flag[isneg] + num + "/" + dem;
	}

	public static  Long gcd (Long num1 , Long num2 ){

		for(Long i = Math.min(num1 ,num2)  ; i>=1 ;i--){
			if(num1%i == 0 && num2%i == 0 )
				return  i;
		}
		return Long.valueOf(1) ;

	}

}
