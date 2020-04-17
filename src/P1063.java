package pat35_70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//3
//3 99 87 101
//4 87 101 5 87
//7 99 101 18 5 135 18 99
//2
//1 2
//1 3
public class P1063 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Set<Integer>[] sets = new Set[N];
		for (int i = 0; i < N; i++) // 初始化
			sets[i] = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			String[] data = bf.readLine().split(" ");
			int m = Integer.parseInt(data[0]);
			for (int j = 1; j <= m; j++) {
				sets[i].add(Integer.parseInt(data[j]));
			}

		}

		int qury = Integer.parseInt(bf.readLine());
		for (int j = 0; j < qury; j++) {
			String[] s = bf.readLine().split(" ");
			int t1 = Integer.parseInt(s[0]) - 1;
			int t2 = Integer.parseInt(s[1]) - 1;
			int total = sets[t1].size() + sets[t2].size();
			int com = 0;
			for (Integer integer : sets[t1]) {
				if (sets[t2].contains(integer))
					com++;
			}
			System.out.printf("%.1f", (com*1.0) / (total - com) * 100);
			System.out.println("%");
		}
	}
}
