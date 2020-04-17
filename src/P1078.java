package pat71_100;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//4 4
//10 6 4 15
public class P1078 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] info = bf.readLine().split(" ");
		int size = Integer.parseInt(info[0]);
		int num = Integer.parseInt(info[1]);
		String[] data = bf.readLine().split(" ");
		while (!IsPrime(size)) {
			size += 1;

		}

		boolean[] table = new boolean[size];
		for (int i = 0; i < num; i++) {
			int n = Integer.parseInt(data[i]);
			int m = n % size;
			if (!table[m]) { // 如果没有被占用
				table[m] = true; // 将这个位置标记
				if (i == 0)
					System.out.printf("%d", m);
				else
					System.out.printf(" %d", m);

			} else {  // 否则处理冲突
				int step ;
				for (step = 1; step < size; step++) {
					m = (n + step * step) % size;
					if ( !table[m]) {
						table[m] = true ;
						if (i == 0)
							System.out.printf("%d", m);
						else
							System.out.printf(" %d", m);
						break;
					}
				}
				if(step >= size){ //这一步判断需要做
					if (i == 0)
						System.out.print("-");
					else
						System.out.print(" -");
				}
			}
		}
	}

	public static boolean IsPrime(int num) {
		if (num == 1) // 1不是素数 2是素数
			return false;
		int t = (int) Math.sqrt(num);
		for (int i = 2; i <= t; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
