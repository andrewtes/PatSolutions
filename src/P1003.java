
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P1003{
	static class Pair implements Comparable<Pair> {
		List<Integer> path;
		int length;

		public Pair(List<Integer> path, int length) {
			this.path = path;
			this.length = length;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.length < o.length)
				return -1;
			else if (this.length == o.length)
				return 0;
			else
				return 1;
		}
	}

	private static int[][] roads;
	private static boolean[] used;
	private static List<Pair> paths;
	private static int[] people;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int cityNum = input.nextInt();
		int roadNum = input.nextInt();
		int myCity = input.nextInt();
		int saveCity = input.nextInt();
		people = new int[cityNum];
		for (int i = 0; i < cityNum; i++) {
			int peoples = input.nextInt();
			people[i] = peoples;
		}

		roads = new int[cityNum][cityNum];

		for (int i = 0; i < roadNum; i++) {

			int city1 = input.nextInt();
			int city2 = input.nextInt();
			int length = input.nextInt();
			roads[city1][city2] = length;
			roads[city2][city1] = length;
		}


		used = new boolean[cityNum];
		paths = new ArrayList<Pair>();
		List<Integer> path = new ArrayList<>();

		DFS(roads, myCity, saveCity, path, 0);

		// 找出最短路径 条数 和可以召集最多消防员的人数

		Collections.sort(paths);

		int minLen = paths.get(0).length;
		int maxNUM = 0;
		for (int i = 0; i < paths.get(0).path.size(); i++) {
			maxNUM += people[paths.get(0).path.get(i)];

		}

		int distnum = 1;

		for (int i = 1; i < paths.size() && paths.get(i).length == minLen; i++) {
			distnum++;
			int num = getpeopleNUM(paths.get(i).path);
			if (num > maxNUM)
				maxNUM = num;
		}

		System.out.printf("%d %d", distnum, maxNUM);

	}

	// DFS进行寻路
	private static void DFS(int[][] roads, int currentCity, int saveCity, List<Integer> path, int length) {
		if (currentCity == saveCity) {
			used[currentCity] = true;
			path.add(saveCity);
			paths.add(new Pair(new ArrayList<>(path), length));
			return;
		}
		path.add(currentCity);
		used[currentCity] = true;
		for (int i = 0; i < roads.length; i++) {
			if (roads[currentCity][i] != 0 && !used[i]) {

				DFS(roads, i, saveCity, path, length + roads[currentCity][i]);
				used[i] = false;
				path.remove(path.size() - 1);
			}
		}
	}

	public static int getpeopleNUM(List<Integer> path) {
		int res = 0;
		for (int i = 0; i < path.size(); i++)
			res += people[path.get(i)];
		return res;
	}

}
