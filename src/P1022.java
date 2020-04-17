
// 修改 将查询写成函数，使用map 作为参数 map<String , set > 后面用一个set
//在查询的时候，传入具体的map 进行查询这样可以避免写大量重复的代码

//1: a book title   数字
//2: name of an author  字符串
//3: a key word   字符串
//4: name of a publisher  字符串
//5: a 4-digit number representing the year 数字  value 全部设置为 图书ID

//1111111
//The Testing Book
//Yue Chen
//test code debug sort keywords
//ZUCS Print
//2011


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class P1022 {

	public static void main(String[] args) throws IOException {

		Map<String, Set<Integer>> title = new HashMap<>();
		Map<String, Set<Integer>> author = new HashMap<>();
		Map<String, Set<Integer>> keyword = new HashMap<>();
		Map<String, Set<Integer>> publisher = new HashMap<>();
		Map<String, Set<Integer>> year = new HashMap<>();

		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.valueOf(scanner.readLine());
		for (int i = 0; i < num; i++) {
			int id = Integer.parseInt(scanner.readLine());
			String bookname = scanner.readLine();
			String auth = scanner.readLine();
			String keys = scanner.readLine();
			String print = scanner.readLine();
			String date = scanner.readLine();

			if (!title.containsKey(bookname)) {
				Set<Integer> titlelist = new TreeSet<>();
				titlelist.add(id);
				title.put(bookname, titlelist);
			} else {

				title.get(bookname).add(id);
			}


			if (!author.containsKey(auth)) {
				Set<Integer> authorlist = new TreeSet<>();
				authorlist.add(id);
				author.put(auth, authorlist);
			} else {
				author.get(auth).add(id);
			}

			if (!publisher.containsKey(print)) {
				Set<Integer> publisherlist = new TreeSet<>();
				publisherlist.add(id);
				publisher.put(print, publisherlist);
			} else {
				publisher.get(print).add(id);
			}

			if (!year.containsKey(date)) {
				Set<Integer> yearList = new TreeSet<>();
				yearList.add(id);
				year.put(date, yearList);
			} else {
				year.get(date).add(id);
			}

			String[] words = keys.split(" ");
			for (String word : words) {

				if (!keyword.containsKey(word)) {
					Set<Integer> keywordlist = new TreeSet<>();
					keywordlist.add(id);
					keyword.put(word, keywordlist);
				} else {
					keyword.get(word).add(id);
				}
			}
		}

		int qur = Integer.valueOf(scanner.readLine());
		for (int k = 0; k < qur; k++) {
			String qureString = scanner.readLine();

			if (qureString.charAt(0) == '1') {
				Qury(title, qureString);
			} else if (qureString.charAt(0) == '2') {
				Qury(author, qureString);
			} else if (qureString.charAt(0) == '3') {
				Qury(keyword, qureString);
			} else if (qureString.charAt(0) == '4') {
				Qury(publisher, qureString);
			}
			if (qureString.charAt(0) == '5') {
				Qury(year, qureString);
			}
		}
	}

	public static void Qury(Map<String, Set<Integer>> map, String quryString) {
		System.out.println(quryString);
		String info = quryString.substring(3);

		if (!map.containsKey(info)) {
			System.out.println("Not Found");
		} else {
			for (Integer integer : map.get(info))
				System.out.println(integer);
		}
	}

}
