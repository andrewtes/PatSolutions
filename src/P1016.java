

// 账单的日期是怎么进行匹配的    解决 不了
//10 10 10 10 10 10 20 20 20 15 15 15 15 15 15 15 20 30 20 15 15 10 10 10
//10
//CYLL 01:01:06:01 on-line
//CYLL 01:28:16:05 off-line
//CYJJ 01:01:07:00 off-line
//CYLL 01:01:08:03 off-line
//CYJJ 01:01:05:59 on-line
//aaa 01:01:01:03 on-line
//aaa 01:02:00:01 on-line
//CYLL 01:28:15:41 on-line
//aaa 01:05:02:24 on-line
//aaa 01:04:23:59 off-line


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class P1016 {
	static int[] cost = new int[24];
	static int time = 0, money = 0;
	static Record[] data;

	static class Record implements Comparable<Record> {
		String name;
		int month, day, hour, minute;
		boolean flag;

		public Record(String name, int month, int day, int hour, int minute, boolean flag) {
			this.name = name;
			this.month = month;
			this.day = day ;
			this.hour = hour;
			this.minute = minute;
			this.flag = flag;
		}

		@Override
		public int compareTo(Record o) {
			if (!this.name.equals(o.name))
				return this.name.compareTo(o.name);
			else if (this.day != o.day)
				return this.day - o.day;
			else if (this.hour != o.hour)
				return this.hour - o.hour;
			else
				return this.minute - o.minute;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String [] costs = bf.readLine().trim().split(" ") ;
		for (int i = 0; i < cost.length; i++)
			cost[i] = Integer.parseInt(costs[i]) ;

		int nums = Integer.parseInt(bf.readLine());

		data = new Record[nums];

		for (int i = 0; i < nums; i++) {
			String[] info = bf.readLine().trim().split(" ");
			String name = info[0];
			String[] time = info[1].split(":");
			int month = Integer.parseInt(time[0]);
			int day = Integer.parseInt(time[1]);
			int hour = Integer.parseInt(time[2]);
			int minute = Integer.parseInt(time[3]);
			boolean flag = info[2].equals("on-line");
			data[i] = new Record(name, month, day, hour, minute, flag);
		}

		Arrays.sort(data);
		int on = 0, off, next;
		while (on < nums) {
			int nextprint = 0;
			next = on;
			while (next < nums && data[on].name.equals(data[next].name)) { // 这个循环保证该用户至少有一对合法的记录
				if (nextprint == 0 && data[next].flag)
					nextprint = 1;
				else if (nextprint == 1 && data[next].flag == false)
					nextprint = 2;
				next++; // 直到找到下一个用户
			}

			if (nextprint < 2) { //没找到配对的记录，跳到下一个用户
				on = next;
				continue;
			}
			int totalmoney = 0;
			System.out.printf("%s %02d\n", data[on].name, data[on].month);
			while (on < next) { // 寻找该用户的所有配对
				while (on < next - 1 && !(data[on].flag && !data[on+1].flag)) { // next-1 是因为该用户最后一个有效的online 只可能在倒数第二个位置上
					on++; // 试探法 一步一步向后进行试探 直到找到一个连续的on - off
				}
				off = on + 1;
				if (off == next) {
					on = next;
					break;
				}

				System.out.printf("%02d:%02d:%02d ", data[on].day, data[on].hour, data[on].minute);
				System.out.printf("%02d:%02d:%02d ", data[off].day, data[off].hour, data[off].minute);
				get_ans(on, off);
				totalmoney += money;
				System.out.printf("%d $%.2f\n", time, money / 100.0);
				on = off + 1; // 完成一个配对
			}
			System.out.printf("Total amount: $%.2f\n", totalmoney / 100.0);

		}
	}

	static void get_ans(int on, int off) {
		time = 0 ;  //  每次进入这个函数需要重置time 和money
		money = 0 ;
		Record temp = data[on];
		while (temp.day < data[off].day || temp.hour < data[off].hour || temp.minute < data[off].minute) {
			time ++ ;
			money += cost[temp.hour];
			temp.minute ++ ;
			if(temp.minute >= 60){
				temp.minute = 0;
				temp.hour ++ ;
			}
			if(temp.hour >=24) {
				temp.hour =0 ;
				temp .day ++ ;
			}
		}
	}

}
