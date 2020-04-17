package pat35_70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//97532468=2^2*11*17*101*1291
public class P1059 {
	static int[] prime;
	static int maxn = 50000;
	static int cnts;

	public static class Factor {

		int f;
		int n;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int temp = N;
		if (N == 1) {
			System.out.print("1=1");
			return;
		}


		List<Factor> factors = new ArrayList<>();
		getPrime();
		int tim = 0;
		for (int i = 0; i < cnts; i++) {
			if (N % prime[i] == 0) { // 如果N可以被这个素数整除
				tim++;
				Factor f = new Factor();
				f.f = prime[i];
				int count = 0;
				while (N % prime[i] == 0) {
					count++;
					N = N / prime[i];
				}
				f.n = count;
				factors.add(f);

			}
			if (N == 1)
				break;
		}
		System.out.printf("%d=", temp);
		for (int k = 0; k < tim; k++) {
			System.out.print(factors.get(k).f);
			if (factors.get(k).n != 1) {
				System.out.printf("^%d", factors.get(k).n);
			}
			if (k != tim - 1)
				System.out.print("*");
		}
	}

	static void getPrime() {
		prime = new int[maxn];
		cnts = 0;
		for (int i = 1; i <= maxn; i++) {
			if (Isprime(i))
				prime[cnts++] = i;
		}
	}

	static boolean Isprime(int i) {
		if (i == 1)
			return false;
		int j = (int) Math.sqrt(i);
		for (int k = 2; k <= j; k++) {
			if (i % k == 0)
				return false;
		}
		return true;
	}


}
