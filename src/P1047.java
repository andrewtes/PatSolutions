package pat35_70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//date : 3/10
// 21/25 一个测试用例内存超限
//10 5
//ZOE1 2 4 5
//ANN0 3 5 2 1
//BOB5 5 3 4 2 1 5
//JOE4 1 2
//JAY9 4 1 2 5 4
//FRA8 3 4 2 5
//DON2 2 4 5
//AMY7 1 5
//KAT3 3 5 4 2
//LOR6 4 2 4 1 5
public class P1047 {
	static class Pair {

		List<String> list;

		public Pair(List<String> list) {
			this.list = list;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader  scanner = new BufferedReader( new InputStreamReader(System.in));
		String [] nums = scanner.readLine().split(" ") ;
		int studentNum = Integer.parseInt(nums[0]);
		int courseNum = Integer.parseInt(nums[1]) ;

		Pair[] Info = new Pair[courseNum + 1];
		for (int k = 1; k <= courseNum; k++) {
			Info[k] = new Pair(new ArrayList<String>());


		}


		for (int i = 0; i < studentNum; i++) {

			String[] line = scanner.readLine().split(" ");
			String name = line[0];
			int total = Integer.parseInt(line[1]);
			for (int j = 2; j < line.length; j++) {

				Info[Integer.parseInt(line[j])].list.add(name);
			}
		}


		for (int j = 1; j <= courseNum; j++) {

			Collections.sort(Info[j].list);

		}

		for (int p = 1; p <= courseNum; p++) {
			System.out.println(p + " " + Info[p].list.size());
			for (int k = 0; k < Info[p].list.size(); k++) {

				System.out.print(Info[p].list.get(k));
				// 这个条件用于处理最后的换行问题，如果不是（最后一门课的最后一个学生， 就进行一次换行）
				if (!(p == courseNum && k == Info[p].list.size() - 1)) {
					System.out.println();
				}
			}
		}
	}
}
