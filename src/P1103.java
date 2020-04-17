package pat1101_1155;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//169 5 2
public class P1103 {
	static List<Integer> fac = new ArrayList<>();
	static List<Integer> res = new ArrayList<>();
	static List<Integer> temp = new ArrayList<>();
	static int N, k, p;
	static int max = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] data = bf.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		k = Integer.parseInt(data[1]);
		p = Integer.parseInt(data[2]);
		Init();
		DFS(fac.size() - 1, 0, 0, 0);
		if (max == -1) {
			System.out.println("Impossible");
		} else {
			System.out.printf("%d = %d^%d", N,res.get(0), p);
			for (int i = 1; i < res.size(); i++) {
				System.out.print(" + ");
				System.out.printf("%d^%d", res.get(i), p);

			}
		}
	}

	public static void DFS(int index, int nowk, int sum, int facSum) {
		if (nowk == k && sum == N) { // 表示找到了一组解
			if (facSum > max) {
				max = facSum;
				for (int i = 0; i < temp.size(); i++)
					res.set(i, temp.get(i));// set 方法修改变量
			}
			return;
		}
		if (sum > N || nowk > k)
			return;

		if (index >= 1) {
			temp.add(index);
			DFS(index, nowk + 1, sum + fac.get(index), facSum + index);
			temp.remove(temp.size() - 1);
			DFS(index - 1, nowk, sum, facSum);

		}
	}
	public static void Init() {
		fac.add(0);
		for (int i = 1; Math.pow(i, p) <= N; i++) {
			fac.add((int) Math.pow(i, p));
		}

		for (int i = 0; i < k; i++) // 初始化一下， 避免set的时候，出现空值
			res.add(0);
	}
}
