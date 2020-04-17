package pat35_70;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P1054 {
	public static void main(String[] args)throws IOException {
		BufferedReader scanner= new BufferedReader(new InputStreamReader(System.in)) ;
		String [] info = scanner.readLine().split(" ") ;
		int col = Integer.parseInt(info[0]) ;
		int row = Integer.parseInt(info[1]) ;
		int half = row * col / 2;
		Map<Integer, Integer> map = new HashMap<>();
		int res ;
		for (int i = 0; i < row; i++) {
			String[] data = scanner.readLine().split(" ") ;
			for (int j = 0; j < col; j++) {

				res = Integer.parseInt(data[j]) ;
				if (!map.containsKey(res)) {
					map.put(res, 1);
				} else {
					int cnt = map.get(res);
					if (cnt + 1 > half) {
						System.out.print(res);
						return;

					}
					map.put(res, cnt + 1);
				}
			}
		}
	}
}
