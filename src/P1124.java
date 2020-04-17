package pat1101_1155;
// date: 3/14  score 15/20  modify : 题意理解出错 只需要考虑得过奖 不能再得奖即可
// 9 3 2
//Imgonnawin!
//PickMe
//PickMeMeMeee
//LookHere
//Imgonnawin!
//TryAgainAgain
//TryAgainAgain
//Imgonnawin!
//TryAgainAgain

import java.util.Scanner;
import  java.util.Set;
import  java.util.HashSet;
public class P1124 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nums = scanner.nextInt();
		int skip = scanner.nextInt();
		int start = scanner.nextInt();
		scanner.nextLine();
		Set<String> set = new HashSet<>();
		if (start > nums) {
			System.out.print("Keep going...");
			return;
		}
		for (int i = 1; i < start; i++)
			scanner.nextLine();
		String firstname = scanner.nextLine().trim();
		System.out.print(firstname);
		set.add(firstname);
		int temp = 0;
		for (int k = start + 1; k <= nums; k++) {
			String name = scanner.nextLine().trim();
			if (!set.contains(name)) {
				temp++;
				if (temp != 0 && temp % skip == 0) {
					System.out.println();
					System.out.print(name);
					set.add(name);
				}
			}
		}
	}
}
