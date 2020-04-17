package pat35_70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 5 32 321 3214 0229 87
public class P1038 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)) ;
		String [] info = bf.readLine().split(" ") ;
		int nums = Integer.parseInt(info[0]) ;
		String [] data = new String[nums] ;
		for(int i = 0;i< nums ;i++)
			data[i] = info[i+1] ;

		Arrays.sort(data, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1 + o2).compareTo(o2 + o1);
			}
		});
		StringBuilder stringBuilder = new StringBuilder();
		for (int k = 0; k < data.length; k++) {

			stringBuilder.append(data[k]);
		}
		String res = stringBuilder.toString();
		// 处理最后的数字有前导 0 的情况
		int p = 0;

		while (p<res.length() && res.charAt(p) == '0')
			p++ ;

		if(p == res.length())
			System.out.print("0");
		else
			System.out.print(res.substring(p));
	}
}