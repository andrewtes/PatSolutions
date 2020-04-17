package pat35_70;
// date: 3/11  score 13/20

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 7766 - 6677 = 1089
//9810 - 0189 = 9621
//9621 - 1269 = 8352
//8532 - 2358 = 6174
//7641 - 1467 = 6174
//... ...
public class P1069 {


	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		int max;
		int min;
		Integer[] temp;
		while (true) {
			temp = getarray(num);
			Arrays.sort(temp);
			min = getNum(temp) ;
			Arrays.sort(temp , Collections.reverseOrder());
			max = getNum(temp) ;
			num = max - min ;
			System.out.printf("%04d - %04d = %04d\n", max , min , num);
			if(num == 0 || num == 6174)
				break;
		}

	}

	public static Integer[] getarray(int num) { // 将num的每一位倒序存储在数组中

		Integer[] res = new Integer[]{0,0,0,0}; // 初始化一下，这里时对象，如果外面传来0 不进行初始化，会有空指针异常
		int cnts = 0;
		do {
			res[cnts++] = num % 10;
			num = num / 10;
		} while (num != 0);

		return res;
	}

	public static int getNum(Integer[] arr) {
		int res = 0;
		int len = arr.length;
		for (int i = 0; i < len; i++) {

			res = res * 10 + arr[i];
		}
		return res;
	}

}
