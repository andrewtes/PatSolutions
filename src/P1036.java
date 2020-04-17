package pat35_70;

import java.util.Scanner;

// date: 2020年3月9日13:59:53
//3
//Joe M Math990112 89
//Mike M CS991301 100
//Mary F EE990830 95
public class P1036 {
	static class Student {
		String name;
		String gender;
		String course;
		int score;

		public Student(String name, String gender, String course, int score) {
			this.name = name;
			this.gender = gender;
			this.course = course;
			this.score = score;
		}

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num = Integer.valueOf(scanner.nextLine());

		Student fem = new Student(null, null, null, -1);
		Student man = new Student(null, null, null, 101);


		for (int i = 0; i < num; i++) {

			String[] info = scanner.nextLine().split(" ");
			if (info[1].equals("M") ) {
				if (Integer.valueOf(info[3]) < man.score) {
					man.name = info[0];
					man.course = info[2];
					man.score = Integer.valueOf(info[3]);
				}
			}
			if (info[1].equals("F") ) {
				if (Integer.valueOf(info[3]) > fem.score) {
					fem.name = info[0];
					fem.course = info[2];
					fem.score = Integer.valueOf(info[3]);
				}
			}
		}


		if (fem.name != null && man.name != null) {
			System.out.println(fem.name + " " + fem.course);
			System.out.println(man.name + " " + man.course);
			System.out.print(fem.score - man.score);
		}

		else if (fem.name == null){
			System.out.println("Absent");
			System.out.println(man.name + " " + man.course);
			System.out.print("NA");
		}


		else if (man.name == null){
			System.out.println("Absent");
			System.out.println(fem.name + " " + fem.course);
			System.out.print("NA");
		}
		else {
			System.out.println("Absent");
			System.out.println("Absent");

			System.out.print("NA");
		}

	}
}
