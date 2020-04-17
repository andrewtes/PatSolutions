package pat01_35;

// 一个测试用例运行超时
import java.util.*;

public class P1028 {
	static class Srecord {
		String id;
		String name;
		int score;

		public Srecord(String id, String name, int score) {
			this.id = id;
			this.name = name;
			this.score = score;
		}


	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] line = scanner.nextLine().split(" ");
		int num = Integer.valueOf(line[0]);
		int col = Integer.valueOf(line[1]);
		List<Srecord> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			String[] info = scanner.nextLine().split(" ");
			list.add(new Srecord(info[0], info[1], Integer.valueOf(info[2])));

		}


		if (col == 1) {

			Collections.sort(list, new Comparator<Srecord>() {
				@Override
				public int compare(Srecord o1, Srecord o2) {
					return o1.id.compareTo(o2.id);
				}
			});
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j).id + " " + list.get(j).name + " " + list.get(j).score);
				if (j != list.size() - 1)
					System.out.println();

			}
			return;

		} else if (col == 2) {

			Collections.sort(list, new Comparator<Srecord>() {
				@Override
				public int compare(Srecord o1, Srecord o2) {
					if (o1.name.compareTo(o2.name) > 0)
						return 1;
					else if (o1.name.compareTo(o2.name) < 0)
						return -1;
					else
						return o1.id.compareTo(o2.id);
				}
			});
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j).id + " " + list.get(j).name + " " + list.get(j).score);
				if (j != list.size() - 1)
					System.out.println();

			}
			return;

		} else {
			Collections.sort(list, new Comparator<Srecord>() {
				@Override
				public int compare(Srecord o1, Srecord o2) {
					if (o1.score > o2.score)
						return 1;
					else if (o1.score < o2.score)
						return -1;

					else {

						return o1.id.compareTo(o2.id);
					}
				}
			});
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j).id + " " + list.get(j).name + " " + list.get(j).score);
				if (j != list.size() - 1)
					System.out.println();

			}
			return;


		}


	}


}
