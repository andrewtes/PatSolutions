package pat71_100;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 10 8
//2 3 20 4 5 1 6 7 8 9
public class P1085 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = bf.readLine().split(" ");
		int N = Integer.parseInt(nums[0]);
		int p = Integer.parseInt(nums[1]);
		long [] data = new long [N];
		String[] dig = bf.readLine().split(" ");
		for (int i = 0; i < N; i++)
			data[i] = Long.parseLong(dig[i]);

		Arrays.sort(data);
		int res = 1;

		int i = 0 ;
		int j = 0 ;
		while (i< N && j < N){
			if(data[j] <= p*data[i])
				j++ ;
			else {
				i++ ;
			}
			res = Math.max(res , j-i) ;
		}
		System.out.print(res);

	}
}
