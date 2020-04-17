package pat35_70;

// date ： 2020年3月9日13:12:49
//一个测试用例不通过

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1035 {
	static class Info {
		String name;
		String passwrod;

		public Info(String name, String passwrod) {
			this.name = name;
			this.passwrod = passwrod;
		}


	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num = Integer.valueOf(scanner.nextLine());

		List<Info> res = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			String[] s = scanner.nextLine().split(" ");
			boolean flag = false;
			String name = s[0] ;
			String password =s[1] ;
			StringBuilder stringBuilder= new StringBuilder() ;
			for(int j =0 ;j < password.length() ;j++){
				if(password.charAt(j) == '1' || password.charAt(j)=='0' || password.charAt(j) == 'l' || password.charAt(j) =='O'){
					flag = true ;
					if(password .charAt(j) == '1')
						stringBuilder.append("@") ;
					else if(password.charAt(j) == '0')
						stringBuilder.append("%") ;
					else if(password.charAt(j) == 'l')
						stringBuilder.append("L") ;
					else
						stringBuilder.append("o") ;
				}
				else  stringBuilder.append(String.valueOf(password.charAt(j))) ;



			}
			if(flag)
				res.add(new Info(name , stringBuilder.toString())) ;
		}

		if (res.size() == 0)
			System.out.print("There are " + num + " accounts and no account is modified");
		else {
			System.out.println(res.size());
			for (int k = 0; k < res.size(); k++) {
				System.out.print(res.get(k).name + " " + res.get(k).passwrod);
				if (k != res.size() - 1)
					System.out.println();

			}
		}

	}


}
