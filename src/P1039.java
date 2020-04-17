package pat35_70;
//date : 2020年3月9日15:19:38
// score 21 /25
//11 5
//4 7
//BOB5 DON2 FRA8 JAY9 KAT3 LOR6 ZOE1
//1 4
//ANN0 BOB5 JAY9 LOR6
//2 7
//ANN0 BOB5 FRA8 JAY9 JOE4 KAT3 LOR6
//3 1
//BOB5
//5 9
//AMY7 ANN0 BOB5 DON2 FRA8 JAY9 KAT3 LOR6 ZOE1
//ZOE1 ANN0 BOB5 JOE4 JAY9 FRA8 DON2 AMY7 KAT3 LOR6 NON9


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1039 {

	public static void main(String[] args) throws IOException {
		BufferedReader  scanner = new BufferedReader( new InputStreamReader(System.in));
		String[] nums = scanner.readLine().split(" ");
		int sutnum = Integer.valueOf(nums[0]);
		int cournum = Integer.valueOf(nums[1]);
		Map<String, List<Integer>> info = new HashMap<>();

		for (int i = 0; i < cournum; i++) {
			String[] cnts = scanner.readLine().split(" ");
			int courseId = Integer.valueOf(cnts[0]);
			int studentlistnum = Integer.valueOf(cnts[1]);
			String[] studentlist = scanner.readLine().split(" ");
			for (int j = 0; j < studentlistnum; j++) {
				if (!info.containsKey(studentlist[j])) {
					List<Integer> list = new ArrayList<>();
					list.add(courseId);
					info.put(studentlist[j], list);

				} else {

					info.get(studentlist[j]).add(courseId);
				}
			}
		}
		String [] queryName = scanner.readLine().split(" ") ;
		for (int k = 0; k < sutnum; k++) {

			String studentname = queryName[k] ;
			System.out.print(studentname + " ");
			if( !info.containsKey(studentname)){
				System.out.print(0);
				if (k != sutnum - 1)
					System.out.println();
				continue;
			}

			System.out.print(info.get(studentname).size());

			Collections.sort(info.get(studentname));
			for (int p = 0; p < info.get(studentname).size(); p++) {

				System.out.print(" " + info.get(studentname).get(p));
			}
			if (k != sutnum - 1)
				System.out.println();
		}
	}
}
