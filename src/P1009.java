

import java.util.*;
// 多项式成乘法
public class P1009 {
	static class Ploy {
		int exp;
		double cof;

		public Ploy(int exp, double cof) {
			this.exp = exp;
			this.cof = cof;
		}
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N1 = scanner.nextInt();
		List<Ploy> P1 = new ArrayList<>();

		for (int i = 0; i < N1; i++) {
			int exp = scanner.nextInt();
			double cof = scanner.nextDouble();
			P1.add(new Ploy(exp, cof));
		}

		int N2 = scanner.nextInt();
		List<Ploy> P2 = new ArrayList<>();
		for (int j = 0; j < N2; j++) {

			int exp = scanner.nextInt();
			double cof = scanner.nextDouble();
			P2.add(new Ploy(exp, cof));

		}

		Map<Integer, Double> res = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1.intValue() > o2.intValue())
					return -1;
				else if (o1.intValue() < o2.intValue())
					return 1;
				else
					return 0;
			}
		});

		for (int i = 0; i < P1.size(); i++) {
			for (int j = 0; j < P2.size(); j++) {
				double cof = P1.get(i).cof * P2.get(j).cof;
				int exp = P1.get(i).exp + P2.get(j).exp;

				if (!res.containsKey(exp))
					res.put(exp, cof);
				else
					res.put(exp, cof + res.get(exp));
			}
		}
		System.out.print(res.size() );
		for (Integer key : res.keySet()) {
			System.out.printf(" %d %.1f"  , key , res.get(key));
		}
	}
}
