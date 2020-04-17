
import java.util.*;
// 通过这一题 发现输入信息时，输入字符串的处理问题



public class P1006 {
	static class Mytime implements Comparable<Mytime> {
		int hour;
		int min;
		int sec;

		public Mytime(int hour, int min, int sec) {
			this.hour = hour;
			this.min = min;
			this.sec = sec;
		}

		@Override
		public int compareTo(Mytime o) {
			if (this.hour > o.hour) {
				return 1;
			} else if (this.hour < o.hour) {
				return -1;
			} else {
				if (this.min > o.min)
					return 1;
				else if (this.min < o.min)
					return -1;
				else {
					if (this.sec > o.sec)
						return 1;
					else if (this.sec < o.sec)
						return -1;
					else
						return 0;
				}
			}
		}
	}

	private static class Person {
		String name;
		Mytime sigIn;
		Mytime sigout;

		public Person(String name, Mytime sigIn, Mytime sigout) {
			this.name = name;
			this.sigIn = sigIn;
			this.sigout = sigout;
		}

	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.nextLine();
		List<Person> res = new ArrayList<>();

		for (int i = 0; i < num; i++) {

			String string = input.nextLine() ;


			String[] line = string.split(" ") ;


			String name = line[0];
			String sigin = line[1];
			String sigout = line[2];
			String[] sigintime = sigin.split(":");
			String[] sigouttime = sigout.split(":");
			Mytime time1 = new Mytime(Integer.valueOf(sigintime[0]),
					Integer.valueOf(sigintime[1]),
					Integer.valueOf(sigintime[2]));
			Mytime time2 = new Mytime(Integer.valueOf(sigouttime[0]),
					Integer.valueOf(sigouttime[1]), Integer.valueOf(sigouttime[2]));
			res.add(new Person(name, time1, time2));
		}

		Collections.sort(res, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.sigIn.compareTo(o2.sigIn) > 0)
					return 1;
				else if (o1.sigIn.compareTo(o2.sigIn) < 0)
					return -1;
				else
					return 0;

			}
		});

		System.out.print(res.get(0).name);
		System.out.print(" ");

		Collections.sort(res, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.sigout.compareTo(o2.sigout) > 0)
					return 1;
				else if (o1.sigout.compareTo(o2.sigout) < 0)
					return -1;
				else
					return 0;

			}
		});

		System.out.print(res.get(res.size() - 1).name);


	}


}
