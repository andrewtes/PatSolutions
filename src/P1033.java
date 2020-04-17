package pat01_35;
//50 1300 12 8
//6.00 1250
//7.00 600
//7.00 150
//7.10 0
//7.20 200
//7.50 400
//7.30 1000
//6.85 300
// 我们是从杭州开车去外地， 加油站的距离是距离起点杭州的距离

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1033 {
	static class Station {
		double dist;
		double price;

		public Station(double dist, double price) {
			this.dist = dist;
			this.price = price;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] info = bf.readLine().trim().split(" ");
		double tankCap = Double.parseDouble(info[0]);
		double Distance = Double.parseDouble(info[1]);
		double average = Double.parseDouble(info[2]);
		int satNum = Integer.parseInt(info[3]);
		Station[] stations = new Station[satNum + 1];
		for (int i = 0; i < satNum; i++) {
			String[] staInfo = bf.readLine().split(" ");
			double price = Double.parseDouble(staInfo[0]);
			double dis = Double.parseDouble(staInfo[1]);
			stations[i] = new Station(dis, price);
		}
		stations[satNum] = new Station(Distance , 0) ;

		Arrays.sort(stations, (s1, s2) -> (s1.dist > s2.dist ? 1 : -1));


		if (stations[0].dist != 0) {

			System.out.print("The maximum travel distance = 0.00");
			return;
		} else {
			int now = 0; // 当前所处的加油站编号
			double nowTank = 0; // 当前油箱的油量
			double totalMoney = 0; //最终的金额 如果可以到达，需要输出
			double maxDist = 0; // 最大行驶距离 如果到达不了需要输出
			double cmax = tankCap * average; // 加满油可以跑多远

			while (now < satNum) { // 选出下一个要到达的加油站
				double minPrice = Double.MAX_VALUE; // 最低油价
				int k = -1; // 最低油价的编号

				for (int i = now + 1; i <= satNum && stations[i].dist - stations[now].dist <= cmax; i++) {

					if (stations[i].price < minPrice) {
						k = i;
						minPrice = stations[i].price;
						if (minPrice < stations[now].price) {

							break;
						}
					}


				}
				if (k == -1) // 加满油也过不去
					break;

				double need = (stations[k].dist - stations[now].dist) / average; //如果k 的油价比当前的油价更便宜
				if (stations[now].price > stations[k].price) { // 加够去往k 的油即可
					if (need <= nowTank) { // 如果油箱的剩余油量大于所需的油量 不用加油， 直接开走
						nowTank = nowTank - need; // 更新到达K之后油箱的剩余油量
					} else {
						totalMoney += (need - nowTank) * stations[now].price;
						nowTank = 0; // 到达k时，油量清空
					}
					maxDist += stations[k].dist - stations[now].dist; // 更新最大距离
				} else { // 加满油过去
					totalMoney += (tankCap - nowTank) * stations[now].price;
					nowTank = tankCap- need; // 更新到达k之后的油量 此时是满油-需要的油 最后还可能富于一些
					maxDist += stations[k].dist - stations[now].dist; // 更新最大距离
				}
				now = k; // 更新当前点
			}
			if (now == satNum) {

				System.out.printf("%.2f", totalMoney);
			} else {

				System.out.printf("The maximum travel distance = %.2f", stations[now].dist + maxDist);
			}
		}
	}


}
