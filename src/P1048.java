package pat35_70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// date: 3/10
// score 20/25
// 8 15
//1 2 8 7 2 4 11 15   两数之和
public class P1048 {


	public static void main(String[] args) throws IOException {

		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

		String[] nums = scanner.readLine().split(" ");
		int len = Integer.parseInt(nums[0]);
		int target = Integer.parseInt(nums[1]);
		String[] info = scanner.readLine().split(" ");
		int[] data = new int[len];

		for (int i = 0; i < len; i++)
			data[i] = Integer.parseInt(info[i]);
		Arrays.sort(data);

		int i = 0 ;
		int j = len-1;
		int temp ;
		while (i<j){
			temp = data[i] + data[j];
			if(temp == target){
				System.out.printf("%d %d" , data[i] , data[j]);
				return;
			}else  if(temp < target)
				i++  ;
			else
				j-- ; // 如果时大于 我们让j-- 而不是i++因为我们要找的i最小的解
		}

		System.out.print("No Solution");
	}
}
