package pat71_100;
//16 7  16record 7 query
//JH007BD 18:00:01 in
//ZD00001 11:30:08 out
//DB8888A 06:30:50 in
//05:10:00
//06:30:50


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1095 {
	static class Car {
		String id;
		int time;
		boolean status;

		public Car(String id, int time, boolean status) {
			this.id = id;
			this.time = time;
			this.status = status;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		String []nums  = scanner.readLine().split(" ") ;
		int record = Integer.parseInt(nums[0]) ;
		int query = Integer.parseInt(nums[1]) ;

		Car[] allCar = new Car[record];
		Car[] vaild = new Car[record];
		int cnts = 0;
		for (int i = 0; i < record; i++) {
			String[] info = scanner.readLine().split(" ");
			String[] time = info[1].split(":");
			int costtime = Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60 + Integer.parseInt(time[2]);
			allCar[i] = new Car(info[0], costtime, info[2].equals("in")); // 这里的小技巧 equals返回的就是Boolean值
		}
		Arrays.sort(allCar, new Comparator<Car>() {
			@Override
			public int compare(Car o1, Car o2) {
				if (o1.id.compareTo(o2.id) == 0)
					return o1.time - o2.time;
				else
					return o1.id.compareTo(o2.id);
			}
		});

		Map<String, Integer> map = new TreeMap<>();
		int maxtime = 0;
		for (int i = 0; i < allCar.length-1; i++) {
			if (allCar[i].id.equals(allCar[i + 1].id) && allCar[i].status && !allCar[i + 1].status) {
				vaild[cnts++] = allCar[i];
				vaild[cnts++] = allCar[i + 1];
				int time = allCar[i + 1].time - allCar[i].time;
				if (map.getOrDefault(allCar[i].id, 0) == 0) {
					map.put(allCar[i].id, time);
				} else {
					int times = map.get(allCar[i].id);
					map.put(allCar[i].id, time + times);
				}
				maxtime = Math.max(maxtime, map.get(allCar[i].id));
			}
		}

		Arrays.sort(vaild, 0 , cnts, (s1, s2) -> (s1.time - s2.time));
		int totalcars = 0; // 由于查询的时间是有顺序的，因此， 用totalcars进行累加，不用每次从头遍历
		int cur = 0;
		for (int k = 0; k < query; k++) {
			String[] querytime = scanner.readLine().split(":");
			int qurtime = Integer.parseInt(querytime[0]) * 3600 + Integer.parseInt(querytime[1]) * 60 + Integer.parseInt(querytime[2]);
			int j = cur;
			for (; j < cnts && vaild[j].time <= qurtime; j++) { // 这里是cnts 因为vaild 后面部分没有对象
				if (vaild[j].status)
					totalcars++;
				else
					totalcars--;
			}
			System.out.println(totalcars);
			cur = j ;
		}


		for (String id : map.keySet()) {

			if (map.get(id) == maxtime) {

				System.out.print(id + " ");
			}
		}

		System.out.printf("%02d:%02d:%02d", maxtime / 3600, maxtime % 3600 / 60, maxtime % 60);

	}

}
