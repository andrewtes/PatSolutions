
// 得分22 一个实例 超时
import java.io.BufferedInputStream;
import java.util.*;

//2
//5
//1234567890001 95
//1234567890005 100
//1234567890003 95
//1234567890002 77
//1234567890004 85
//4
//1234567890013 65
//1234567890011 25
//1234567890014 100
//1234567890012 85
public class P1025 {
	static class Student implements Comparable<Student> {
		String testnum;
		int score;
		int localnum;
		int localrank;
		int finalrank;

		public Student(String testnum, int score, int localnum, int localrank, int finalrank) {
			this.testnum = testnum;
			this.score = score;
			this.localnum = localnum;
			this.localrank = localrank;
			this.finalrank = finalrank;
		}


		@Override
		public int compareTo(Student o) {
			if (this.score > o.score)
				return -1;
			if (this.score < o.score)
				return 1;
			else {

				return this.testnum.compareTo(o.testnum);
			}
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(new BufferedInputStream( System.in));
		int num = Integer.valueOf(scanner.nextLine());

		List<Student> list = new ArrayList<>();
		int cnts = 0;
		for (int i = 1; i <= num; i++) {
			int localnums = Integer.valueOf(scanner.nextLine());
			// 单场考生信息
			for (int j = 0; j < localnums; j++) {
				String[] info = scanner.nextLine().split(" ");
				String testnum = info[0];
				int score = Integer.valueOf(info[1]);
				list.add(new Student(testnum, score, i, -1, -1));
			}
			// 对单场考僧信息进行排名   这个排序的区间是左闭右开的
			Collections.sort(list.subList(cnts, cnts + localnums ));
			// 遍历这个区间 进行单场排名
			list.get(cnts).localrank = 1;
			for (int j = cnts + 1; j <= cnts + localnums - 1; j++) {

				if (list.get(j).score == list.get(j - 1).score) {

					list.get(j).localrank = list.get(j - 1).localrank;
				} else {

					list.get(j).localrank = j - cnts + 1;
				}
			}

			cnts = cnts + localnums;
		}

		Collections.sort(list);
		list.get(0).finalrank = 1;
		for (int k = 1; k < list.size(); k++) {
			if (list.get(k).score == list.get(k - 1).score)
				list.get(k).finalrank = list.get(k - 1).finalrank;
			else
				list.get(k).finalrank = k + 1;
		}

		System.out.println(cnts);
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%s %d %d %d", list.get(i).testnum, list.get(i).finalrank,
					list.get(i).localnum, list.get(i).localrank);
			if (i != list.size() - 1)
				System.out.println();

		}
	}
}
