package pat35_70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Arrays ;

// date: 3/14 score : 13/25
// 3 200
//180 150 100
//7.5 7.2 4.5
public class P1070 {
	static class Mooncake {
		double price; // 单价
		int mount;    // 库存数量
		double total;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))  ;
		String [] nums = bf.readLine().trim().split(" ") ;
		int N = Integer.parseInt(nums[0]) ;
		double D = Double.parseDouble(nums[1]) ;
		Mooncake[] mooncakes = new Mooncake[N] ;
		String[] wig = bf.readLine().trim().split(" ") ;
		String[] prices = bf.readLine().trim().split(" ") ;
		for(int i = 0 ;i< N ;i++){
			mooncakes[i]= new Mooncake();
			mooncakes[i].mount = Integer.parseInt(wig[i]) ;
			mooncakes[i] .total = Double.parseDouble(prices[i]) ;
			mooncakes[i].price = mooncakes[i].total/mooncakes[i].mount;
		}


		Arrays.sort(mooncakes, new Comparator<Mooncake>() {
			@Override
			public int compare(Mooncake o1, Mooncake o2) {
				if (o1.price > o2.price)
					return -1;
				else
					return 1;
			}
		});
		double res = 0;
		for (int j = 0; j < N; j++) {

			if (mooncakes[j].mount >= D) { // 当前月饼足够
				res += D * mooncakes[j].price;
				break;
			} else {  // 当前月饼不够
				res += mooncakes[j].total;
				D -= mooncakes[j].mount;
			}
		}

		System.out.printf("%.2f", res);
	}
}
