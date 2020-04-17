package pat71_100;

//10
//3 1 2 8 7 5 9 4 6 0
//1 2 3 7 8 5 9 4 6 0

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class P1089 {
	static int[] arr1;
	static int[] arr2;
	static int[] change;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		arr1 = new int[N]; // 用于插入排序
		arr2 = new int[N]; // 用于归并排序
		change = new int[N];
		String[] data1 = bf.readLine().split(" ");
		String[] data2 = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(data1[i]);
			arr2[i] = arr1[i];
			change[i] = Integer.parseInt(data2[i]);
		}

		if (InsertSort(arr1)) {
			System.out.println("Insertion Sort");
			showArr(arr1);

		}else {
			System.out.println("Merge Sort");
			Mergesort(arr2 ,N );
			showArr(arr2);
		}

	}

	public static boolean Issame(int[] arr1, int[] arr2) {
		int len = arr1.length;
		for (int i = 0; i < len; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}

	public static boolean InsertSort(int[] array) {
		boolean flag = false;
		int len = array.length;
		int i;
		for (i = 1; i < len - 1; i++) {
			int temp = array[i];
			int j;
			for (j = i ; j > 0 && temp< array[j-1]; j--) // 进行一轮插入排序
				array[j ] = array[j-1];
			array[j] = temp;
			if (Issame(array, change)) {
				flag = true;
				break;
			}
		}

		if (flag) {
			int temp = array[i + 1];
			int j;
			for (j = i+1; j > 0 && array[j-1] > temp; j--) // 获取最后的结果
				array[j ] = array[j-1];
			array[j] = temp;

			 // 赋值给res
			return true;
		}
		return false;

	}

	public static void Mergesort(int[] array, int N) {
		boolean flag = false ;
		for(int step = 2 ;step /2 <N ;step *= 2 ){
			if(step !=2 && Issame(array , change)) { // 发现匹配之后，再归并一次
				flag = true ;
			}
			for(int i= 0 ;i<N ;i+= step) {

				Arrays.sort(array , i , Math.min(i+step , N));
			}
			if(flag )
				return;
		}
	}

	public static void showArr(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i]);
			if (i != len - 1)
				System.out.print(" ");
		}
	}


}
