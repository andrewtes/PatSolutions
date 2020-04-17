package pat71_100;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// 4
//Tom CS000001 59
//Joe Math990112 89
//Mike CS991301 100
//Mary EE990830 95
//60 100
public class P1083 {
	static class Stu {
		String name;
		String course;
		int score;

		public Stu(String name, String course, int score) {
			this.name = name;
			this.course = course;
			this.score = score;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		int nums = Integer.parseInt(scanner.readLine());
		Stu[] data = new Stu[nums];
		for (int i = 0; i < nums; i++) {
			String[] info = scanner.readLine().split(" ");
			data[i] = new Stu(info[0], info[1], Integer.parseInt(info[2]));
		}
		String [] bound = scanner.readLine().split(" ") ;
		int low = Integer.parseInt(bound[0]) ;
		int high =Integer.parseInt(bound[1]) ;
		Arrays.sort(data, (s1, s2) -> (-(s1.score - s2.score)));
		boolean flag = false;
		for (int i = 0; i < data.length; i++) {
			if (data[i].score >= low && data[i].score <= high) {
				System.out.printf("%s %s\n", data[i].name, data[i].course);
				flag = true;

			}
		}

		if (!flag)
			System.out.print("NONE");
	}
}
