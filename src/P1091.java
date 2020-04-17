package pat71_100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1091 {
	static class Node {
		int x, y, z;

		public Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int n, m, slice, T; // 矩阵为n*m 共有slice层，T为猝中核心区的个数下限
	static int[][][] pixel;  // 观察图可知为上下切片
	static boolean[][][] inq; // 布尔数组的维度和 pixel 一致
	static int[] X = {0, 0, 0, 0, 1, -1};  // 六个方向，上下左右前后
	static int[] Y = {0, 0, 1, -1, 0, 0};
	static int[] Z = {1, -1, 0, 0, 0, 0};
	static int counts = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] dataInfo = bf.readLine().split(" ");
		n = Integer.parseInt(dataInfo[0]);
		m = Integer.parseInt(dataInfo[1]);
		slice = Integer.parseInt(dataInfo[2]);
		T = Integer.parseInt(dataInfo[3]);
		pixel = new int[n][m][slice];
		inq = new boolean[n][m][slice];
		for (int z = 0; z < slice; z++) {   // slice
			for (int x = 0; x < n; x++) {  // row
				String[] data = bf.readLine().split(" ");
				for (int y = 0; y < m; y++) { // col
					pixel[x][y][z] = Integer.parseInt(data[y]);
				}
			}
		}


		int ans = 0;
		for (int z = 0; z < slice; z++) {
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < m; y++) {
					if (pixel[x][y][z] == 1 && !inq[x][y][z])
						ans += BFS(x, y, z);
				}
			}

		}

		System.out.print(ans);
	}

	static boolean judge(int x, int y, int z) {
		if (x >= n || x < 0 || y >= m || y < 0 || z >= slice || z < 0)
			return false;
		if (pixel[x][y][z] == 0 || inq[x][y][z])
			return false;

		return true;
	}

	static int BFS(int x, int y, int z) {

		int tot = 0;
		Queue<Node> Q = new LinkedList<>();
		Node node = new Node(x, y, z);
		Q.offer(node);
		inq[x][y][z] = true;
		while (Q.size() != 0) {    // node 和top 是同一个对象， 在if(judge())这个语句块中改变了node 改变top我们不希望这样

			Node top = new Node(Q.peek().x, Q.peek().y, Q.peek().z);
			Q.poll();
			tot++;
			for (int i = 0; i < 6; i++) {

				int newX = top.x + X[i];
				int newY = top.y + Y[i];
				int newZ = top.z + Z[i];

				if (judge(newX, newY, newZ)) {
					Node newNode = new Node(newX, newY, newZ);
					Q.offer(newNode);
					inq[newX][newY][newZ] = true;
				}
			}
		}

//		System.out.printf("第%d次bfs 结果是： %d\n", counts++, tot);

		if (tot >= T)
			return tot;
		else
			return 0;
	}
}
