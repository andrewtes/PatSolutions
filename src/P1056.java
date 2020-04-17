package pat35_70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

//11 3
//25 18 0 46 37 3 19 22 57 56 10
//6 0 8 7 10 5 9 1 4 2 3
public class P1056 {
	static class Mouse {
		int weight;
		int rank;

		public Mouse(int weight, int rank) {
			this.weight = weight;
			this.rank = rank;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] info = bf.readLine().split(" ");
		int mouseNum = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);
		String[] weight = bf.readLine().split(" ");
		String[] order = bf.readLine().split(" ");
		Mouse[] data = new Mouse[mouseNum];
		Deque<Integer> queue = new LinkedList<>();
		for (int i = 0; i < mouseNum; i++) {
			data[i] = new Mouse(Integer.parseInt(weight[i]), -1);
		}
		for (int j = 0; j < mouseNum; j++) {
			queue.offer(Integer.parseInt(order[j]));
		}

		int temp = mouseNum;
		int gourp;
		while (queue.size() != 1) {

			if (temp % M == 0)
				gourp = temp / M;
			else
				gourp = temp / M + 1;

			for (int i = 0; i < gourp; i++) { // 对每一轮进行选拔
				int k = queue.peek(); // 该组老鼠质量最大2的编号
				for (int j = 0; j < M; j++) { // 对每一组进行选拔
					if (i * M + j >= temp)
						break;
					int front = queue.peek(); // front 只是一个编号
					if (data[front].weight > data[k].weight) {
						k = front;
					}
					data[front].rank = gourp + 1;
					queue.poll();
				}
				queue.offer(k); // 胜利的老鼠晋级

			}

			temp = gourp; // 晋级 gourp 只老鼠
		}

		data[queue.peek()] .rank =1 ;

		for(int i = 0 ;i<mouseNum ;i++){
			System.out.print(data[i].rank);
			if(i != mouseNum-1)
				System.out.print(" ");
		}
	}
}
