package pat71_100;
//7 4 20
//20 25 25 30
//00002 2 12
//00007 4 17
//00005 1 19
//00007 2 25
//00005 1 20
//00002 2 2

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class P1075 {
	static class Stu implements Comparable<Stu> {
		int id;
		int preSolve = 0;  // 完美解题数目
		boolean flag = false; // 是否有通过编译的提交 将决定是否可以被输出
		int[] scores = new int[]{-1, -1, -1, -1, -1, -1}; // 初始化各个问题的分数
		int totalScore = 0; // 总分


		@Override
		public int compareTo(Stu o) {
			if (o == null)
				return -1;
			if (this.flag && !o.flag)
				return -1;
			else {
				if (this.totalScore != o.totalScore)
					return -(this.totalScore - o.totalScore);

				else if (this.preSolve != o.preSolve)
					return -(this.preSolve - o.preSolve);

				else
					return this.id - o.id;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));

		int stuNum = scanner.nextInt();
		int proNum = scanner.nextInt();
		int subNum = scanner.nextInt();
		scanner.nextLine();
		int[] scoreList = new int[proNum + 1];
		for (int i = 1; i <= proNum; i++)
			scoreList[i] = scanner.nextInt();
		scanner.nextLine();
		Stu[] data = new Stu[stuNum + 1];
		for (int i = 1; i <= stuNum; i++) // 初始化
			data[i] = new Stu();

		for (int i = 1; i <= subNum; i++) {
			String[] info = scanner.nextLine().split(" ");
			int id = Integer.parseInt(info[0]);
			int pid = Integer.parseInt(info[1]);
			int score = Integer.parseInt(info[2]);
			if (score == -1) {
				data[id].scores[pid] = 0;
			}
			if (score > data[id].scores[pid]) { // 如果比之前分数高， 更新分数
				data[id].id = id;
				data[id].scores[pid] = score;
				data[id].flag = true;         // 此时已经有了正常分数的提交，可以进入排名
				if (score == scoreList[pid])  // 如果分数是满分， 更新完美提交数目。
					data[id].preSolve++;
			}
		}
		for (int j = 0; j < data.length; j++) { // 计算总分  分数表是1---proNum
			if (data[j] != null) {
				int res = 0;
				for (int k = 1; k <= proNum; k++) {
					if (data[j].scores[k] != -1)
						res += data[j].scores[k];
				}
				data[j].totalScore = res;
			}
		}

		Arrays.sort(data);

//1 00002 63 20 25 - 18
//2 00005 42 20 0 22 -
//2 00007 42 - 25 - 17
//2 00001 42 18 18 4 2
//5 00004 40 15 0 25 -
		int preRank = 1;
		if(data[0].flag ){
			System.out.printf("%d %05d %d", 1, data[0].id, data[0].totalScore);
			for (int p = 1; p <= proNum; p++) {
				if (data[0].scores[p] != -1)
					System.out.print(" " + data[0].scores[p]);
				else
					System.out.print(" -");
			}

		}
		for (int k = 1; k <= data.length; k++) {
			System.out.println();
			if (!data[k].flag)
				return;
			else {
				if (data[k].totalScore == data[k - 1].totalScore) {
					System.out.printf("%d %05d %d", preRank, data[k].id, data[k].totalScore);

				} else {

					System.out.printf("%d %05d %d", k + 1, data[k].id, data[k].totalScore);
					preRank = k + 1;
				}
				for (int p = 1; p <= proNum; p++) {
					if (data[k].scores[p] != -1)
						System.out.print(" " + data[k].scores[p]);
					else
						System.out.print(" -");
				}
			}
		}
	}
}
