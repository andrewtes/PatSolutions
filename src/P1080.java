package pat71_100;
//11 6 3
//2 1 2 2 2 3
//100 100 0 1 2
//60 60 2 3 5
//100 90 0 3 4

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class P1080 {
	static class Stu implements Comparable<Stu> {
		int id;
		int ge;
		int gi;
		int totscore;
		int rank;
		int[] pschool = new int[6];


		@Override
		public int compareTo(Stu o) {
			if (this.totscore != o.totscore)
				return -(this.totscore - o.totscore);
			else
				return -(this.ge - o.ge);
		}
	}

	static class School {
		int quto;
		int realnum = 0;
		int[] alist = new int[40000];
		Stu  lastadd;

		public School(int quto) {
			Arrays.fill(alist, -1);
			this.quto = quto;

		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		int appNum = scanner.nextInt();
		int schNum = scanner.nextInt();
		int k = scanner.nextInt();
		scanner.nextLine();

		School[] schools = new School[schNum];
		Stu[] stus = new Stu[appNum];
		for (int i = 0; i < schNum; i++) {
			schools[i] = new School(scanner.nextInt());
		}
		scanner.nextLine();
		for (int j = 0; j < appNum; j++) {
			int ge = scanner.nextInt();
			int gi = scanner.nextInt();
			stus[j] = new Stu();
			stus[j].id = j;
			stus[j].ge = ge;
			stus[j].gi = gi;
			stus[j].totscore = ge + gi;

			for (int p = 0; p < k; p++) {
				stus[j].pschool[p] = scanner.nextInt();
			}
			scanner.nextLine();
		}
		// 算法部分
		// 排序

		Arrays.sort(stus);
		stus[0].rank = 1;
		for(int i = 1 ;i<appNum ;i++){
			if(stus[i] .totscore == stus[i-1].totscore && stus[i].ge==stus[i-1].ge)
				stus[i] .rank = stus[i-1].rank ;
			else
				stus[i] .rank = i+1;
		}

		for(int i = 0 ;i<appNum ;i++){
			Stu cur = stus[i] ;
			for(int j = 0 ;j<k ;j++){
				int s = cur.pschool[j] ; // 对于每一个需求
				if(schools[s].quto > 0 ){ // accept 还有剩余席位

					schools[s].alist[schools[s].realnum ++]  = cur.id ; // 正常录取
					schools[s].quto -- ;
					schools[s].lastadd = cur;
					break;                                 // 录取之后，马上退出
				} else if(schools[s] .quto == 0 ) {
					if(cur.rank == schools[s].lastadd .rank) { // 破格录取

						schools[s].alist[schools[s].realnum ++]  = cur.id ;
						schools[s].lastadd = cur;
						break;
					}
				}
			}
		}

		for(int i = 0 ;i<schNum ;i++){

			if(schools[i].realnum !=  0){
				Arrays.sort(schools[i].alist,0 , schools[i].realnum); // 排序区间是左闭右开
				for(int j = 0 ;j< schools[i] .realnum ;j++){
					System.out.print(schools[i].alist[j]);
					if(j != schools[i] .realnum-1)
						System.out.print(" ");
				}
			}
			System.out.println();

		}
	}
}
