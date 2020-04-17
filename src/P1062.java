package pat35_70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// date: 3/14  score : 15/25 两处超时  语言的问题， 算法思路是正确的
// 14 60 80
//10000001 64 90
//10000002 90 60
//10000011 85 80
//10000003 85 80
//10000004 80 85
//10000005 82 77
//10000006 83 76
//10000007 90 78
//10000008 75 79
//10000009 59 90
//10000010 88 45
//10000012 80 100
//10000013 90 99
//10000014 66 60
public class P1062 {
	static class Person implements Comparable<Person> {
		String id;
		int virtual;
		int talent;
		int total;
		int flag;

		public Person(String id, int virtual, int talent, int flag) {
			this.id = id;
			this.virtual = virtual;
			this.talent = talent;
			this.total = virtual + talent;
			this.flag = flag;
		}

		@Override
		public int compareTo(Person o) {
			if (this.flag != o.flag)
				return this.flag - o.flag;

			else if (this.total != o.total)
				return -(this.total - o.total);

			else if (this.virtual != o.virtual)
				return -(this.virtual - o.virtual);

			else
				return this.id.compareTo(o.id);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		String[] lins = scanner.readLine().trim().split(" ");
		int nums = Integer.parseInt(lins[0]);
		int low = Integer.parseInt(lins[1]);
		int high = Integer.parseInt(lins[2]);
		List<Person> data = new ArrayList<>();
		for (int i = 0; i < nums; i++) {
			String[] info = scanner.readLine().trim().split(" ");
			String id = info[0];
			int vir = Integer.parseInt(info[1]);
			int talent = Integer.parseInt(info[2]);
			if (vir < low || talent < low) {
				continue;

			} else if (vir >= high && talent >= high) {

				data.add(new Person(id, vir, talent, 1));

			} else if (vir >= high && talent < high)

				data.add(new Person(id, vir, talent, 2));

			else if ( vir >= talent)

				data.add(new Person(id, vir, talent, 3));

			else
				data.add(new Person(id, vir, talent, 4));

		}

		Collections.sort(data);

		System.out.print(data.size());
		for(int i= 0 ;i<data.size()  ;i++){
			System.out.println();
			System.out.printf( "%s %d %d" , data.get(i) .id , data.get(i).virtual , data .get(i).talent);
		}
	}
}