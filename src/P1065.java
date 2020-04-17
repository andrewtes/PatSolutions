package pat35_70;

import java.math.BigInteger;
import java.util.Scanner;

// date :3/11  20/20 通过 大数相加问题
//3
//1 2 3
//2 3 4
//9223372036854775807 -9223372036854775808 0

//Case #1: false
//Case #2: true
//Case #3: false
public class P1065 {

	public  static  void main(String [] args){

		Scanner scanner = new Scanner( System.in) ;
		int nums = Integer.valueOf(scanner.nextLine()) ;

		for(int i =1 ;i<= nums ;i++){

			String[] line = scanner.nextLine().split(" ") ;
			BigInteger number1 = new BigInteger(line[0]) ;  // 参数是字符串
			BigInteger number2 = new BigInteger(line[1]) ;
			BigInteger number3 = new BigInteger(line[2]) ;
			if(number1.add(number2) .compareTo(number3) >0)
				System.out.printf("Case #%d: true",i);
			else
				System.out.printf("Case #%d: false",i);

			if(i!= nums)
				System.out.println();
		}
	}
}
