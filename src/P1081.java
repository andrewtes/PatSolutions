package pat71_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5
//2/5 4/15 1/30 -2/60 8/3
public class P1081 {
	static class Fr {
		long up;
		long down;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Fr sum = new Fr();
		sum.up = 0;
		sum.down = 1;
		Fr temp = new Fr();
		int N = Integer.parseInt(bf.readLine());
		String[] data = bf.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			String[] info = data[i].split("/");
			long up = Long.parseLong(info[0]);
			long down = Long.parseLong(info[1]);
			temp.up = up;
			temp.down = down;
			sum = add(sum, temp);
		}
		show(sum);

	}

	public static Fr add(Fr f1, Fr f2) {

		Fr res = new Fr();
		res.down = f1.down * f2.down;
		res.up = f1.up * f2.down + f2.up * f1.down;
		return reduce(res);
	}

	public static long gcd(long a, long b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static Fr reduce(Fr num) {
		if (num.down < 0) {
			num.up = -num.up;
			num.down = -num.down;

		}
		if (num.up == 0) {
			num.down = 1;
		} else {
			long g = gcd(Math.abs(num.up), num.down);
			num.down /= g;
			num.up /= g;

		}

		return num;
	}

	public static void show(Fr num) {
		reduce(num);
		if (num.down == 1)  // 整数
			System.out.printf("%d", num.up);
		else if (num.up > num.down) // 假分数
			System.out.printf("%d %d/%d", num.up / num.down, num.up % num.down, num.down);

		else  // 真分数
			System.out.printf("%d/%d", num.up, num.down);
	}


}
