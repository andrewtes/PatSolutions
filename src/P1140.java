package pat1101_1155;

import java.util.Scanner;

//date:3/13   score 20/20
//1 8
public class P1140 {
	public static  void  main(String [] args){
		Scanner scanner = new Scanner(System.in) ;
		String [] line = scanner.nextLine().split(" ") ;
		String start = line[0] ;
		int times = Integer.parseInt(line[1]) ;
		for(int i = 0 ;i< times-1 ;i++){

			start = getChange(start) ;

		}
		System.out.print(start);
	}

	static  String getChange(String s ){
		if(s.length() ==1)
			return s+1;
		StringBuilder stringBuilder = new StringBuilder() ;
		int i = 0 ;
		int j = 1;
		while (j < s.length()){
			if(s.charAt(j ) !=s.charAt(i)){
				stringBuilder.append(s.charAt(i)) ;
				stringBuilder.append(j-i) ;
				i = j ;
				j++;
			}else
				j ++;
		}
		stringBuilder.append(s.charAt(i) ) ;
		stringBuilder.append(j-i);
		return  stringBuilder.toString() ;
	}

}
