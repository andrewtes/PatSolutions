
import java.util.Scanner;
//最长递增子序列
public class P1007 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt() ;
		int[] nums = new int[num];
		for (int i = 0; i < nums.length; i++) {
			int digit = scanner.nextInt();
			nums[i] = digit;
		}
		int res = Integer.MIN_VALUE;
		int fisrt = 0;
		int last = num - 1;
		for (int start = 0; start < num; start++) {

			for (int end = start; end < num; end++) {

				int sum = getSum(nums, start, end);
				if (sum > res) {

					res = sum;
					fisrt = start;
					last = end;
				}
			}
		}
		System.out.print(res + " " + fisrt + " " + last);

	}


	public static int getSum(int[] array, int start, int end) {

		int res = 0;
		for (int i = start; i <= end; i++)
			res += array[i];
		return res;
	}


}
