package pat35_70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class P1055 {
	static class Person  implements  Comparable<Person>{
		String name;
		int age;
		int worth;

		public Person(String name, int age, int worth) {
			this.name = name;
			this.age = age;
			this.worth = worth;
		}

		@Override
		public int compareTo(Person o) {
			if(this.worth !=o.worth)
				return  -(this.worth -o.worth) ;
			if(this.age != o.age)
				return this.age - o.age ;
			else
				return  this.name.compareTo(o.name) ;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = scanner.readLine().split(" ");
		int perNum = Integer.parseInt(nums[0]);
		int quryNum = Integer.parseInt(nums[1]);
		List<Person> list = new ArrayList<>();
		List<Person> vilid = new ArrayList<>();
		for (int i = 0; i < perNum; i++) {
			String[] info = scanner.readLine().split(" ");

			String name = info[0];
			int age = Integer.parseInt(info[1]);
			int worth = Integer.parseInt(info[2]);
			list.add(new Person(name, age, worth));
		}
		Collections.sort(list);

		int[] age = new int[201];
		for (int i = 0; i < list.size(); i++) {
			if (age[list.get(i).age] < 100) {
				age[list.get(i).age]++;
				vilid.add(list.get(i));
			}
		}
		// 二次排序是多余的 因为直接扫描， 先找符合年龄区间的，肯定是资产最多的， 没有要求， 年龄从小到大进行输出
		for (int j = 1; j <= quryNum; j++) {
			String[] quryinfo = scanner.readLine().split(" ");

			int number = Integer.parseInt(quryinfo[0]);
			int agemin = Integer.parseInt(quryinfo[1]);
			int agemax = Integer.parseInt(quryinfo[2]);
			int cnts = 0;
			System.out.printf("Case #%d:\n", j);
			for (Person person : vilid) {
				if (person.age >= agemin && person.age <= agemax) {
					cnts++;
					System.out.printf("%s %d %d\n", person.name, person.age, person.worth);
					if (cnts == number)
						break;
				}
			}
			if (cnts == 0)
				System.out.println("None");
		}
	}
}
