package pat01_35;
// 满分通过
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//4 5 0 3
//0 1 1 20
//1 3 2 30
//0 3 4 10
//0 2 2 20
//2 3 1 20
public class P1030 {
	private static class Pair {  // 由于既要存储时间 又要存储距离， 因此把二者进行打包处理
		int distance;
		int costtime;

		public Pair(int distance, int costtime) {
			this.distance = distance;
			this.costtime = costtime;
		}


	}

	private static class D implements Comparable<D> {
		List<Integer> roads;
		int totaldist;
		int totaltime;

		public D(List<Integer> roads, int totaldist, int totaltime) {
			// D作为结果的一个接，既要有路径信息 又要有距离信息，还要有时间信息 因此把三者进行打包处理，放到结果集list中 进行排序
			this.roads = roads;
			this.totaldist = totaldist;
			this.totaltime = totaltime;
		}

		@Override
		public int compareTo(D o) {
			if (this.totaldist < o.totaldist)
				return -1;
			if (this.totaldist > o.totaldist)
				return 1;
			else {
				if (this.totaltime > o.totaltime)
					return 1;
				else if (this.totaltime < o.totaltime)
					return -1;
				else
					return 0;
			}
		}
	}


	static boolean[] used;
	static List<D> paths = new ArrayList<>();


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String[] info = scanner.nextLine().split(" ");
		int cityNum = Integer.valueOf(info[0]);
		int roadNum = Integer.valueOf(info[1]);
		int start = Integer.valueOf(info[2]);
		int end = Integer.valueOf(info[3]);
		Pair[][] dist = new Pair[cityNum][cityNum];


		for (int i = 0; i < roadNum; i++) {
			String[] line = scanner.nextLine().split(" ");
			int city1 = Integer.valueOf(line[0]);
			int city2 = Integer.valueOf(line[1]);
			int pathdist = Integer.valueOf(line[2]);
			int timecost = Integer.valueOf(line[3]);
			dist[city1][city2] = new Pair(pathdist, timecost);
			dist[city2][city1] = new Pair(pathdist, timecost);

		}

		used = new boolean[cityNum];

		List<Integer> path = new ArrayList<>();
		DFS(dist, start, end, path, 0, 0);
		Collections.sort(paths);
		D solution = paths.get(0);
		List<Integer> list = solution.roads;
		int totaldist = solution.totaldist;
		int totaltime = solution.totaltime;
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");

		}
		System.out.print(totaldist + " ");
		System.out.print(totaltime);

	}
// 回顾深度优先遍历 + 回溯算法
	static void DFS(Pair[][] graph, int start, int end, List<Integer> path, int totaldist, int totaltime) {
		if (start == end) {
			used[end] = true ;
			path.add(end) ;
			paths.add(new D(new ArrayList<>(path), totaldist, totaltime));
			return;
		}
		used[start] = true;
		path.add(start);
		for (int i = 0; i < graph.length; i++) {

			if (graph[start][i] != null && used[i] == false) {

				DFS(graph, i, end, path, totaldist + graph[start][i].distance,
						totaltime + graph[start][i].costtime);
				used[i] = false ;
				path.remove(path.size()-1) ;
			}

		}

		return;
	}
}
