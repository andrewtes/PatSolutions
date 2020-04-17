package pat35_70;
// date:3/13

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class P1051 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int maxCap = scanner.nextInt();  // 栈的最大容量
		int nums = scanner.nextInt();  // 1-N 中的N
		int lines = scanner.nextInt();  // 有多少行
		scanner.nextLine();

		for (int i = 0; i < lines; i++) {

			boolean flag = false;
			Deque<Integer> stack = new LinkedList<>();
			int[] array = new int[nums+1];
			for (int j = 1; j <= nums; j++)
				array[j] = scanner.nextInt();
			int current = 1;
			for (int k = 1; k <= nums; k++) {

				stack.push(k);
				if (stack.size() > maxCap)
					break;
				while (stack.size() != 0 && stack.peek() == array[current]) {
					stack.poll();
					current++;
				}

			}
			if (current == nums+1)
				flag = true;
			if (flag)
				System.out.print("YES");
			else
				System.out.print("NO");

			if(i !=nums-1)
				System.out.println();

			scanner.nextLine() ;
		}
	}
}

