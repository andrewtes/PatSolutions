


// 5 6
//310101 98 85 88
//310102 70 95 88
//310103 82 87 94
//310104 91 91 91
//310105 85 90 90
//310101
//310102
//310103
//310104
//310105
//999999
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class P1012 {
	static  char [] mp = {'A' , 'C' , 'M' , 'E'} ;
	static  int now ;
	static  class  Stu{
		int  id ;
		int []score = new int[ 4] ;
		public   Stu(int id , int c , int m , int e ){
			this.id = id ;
			score [0] = (c+ m + e ) /3 ;
			score[1] = c ;
			score[2] = m ;
			score[3] = e;
		}
	}
	public  static  void  main(String [] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)) ;
		String [] lines = bf.readLine().trim().split(" ") ;
		int nums = Integer.parseInt(lines[0]) ;
		int qury = Integer.parseInt(lines[1]) ;
		Stu[] data = new Stu[nums] ; // 这是设置数据范围，不然，后面排序会出现空指针异常
		int [] [] rank = new int[1000000][4] ; // id - rank
		for(int i =  0 ;i< nums ;i++){
			String [] info = bf.readLine().trim().split(" ") ;
			int id = Integer.parseInt(info[0]) ;
			int c = Integer.parseInt(info[1]) ;
			int m = Integer.parseInt( info[2]) ;
			int e = Integer.parseInt(info[3]) ;
			data[i] = new Stu(id , c , m  , e ) ;
		}
		for(int i = 0 ;i< 4 ;i++){
			now = i ;
			Arrays.sort(data , (s1,s2)-> -(s1.score[now] - s2.score[now]));  // 这样就把问题解决了 没解决
			rank[data[0].id] [i] = 1 ;
			for(int j = 1 ;j<nums ;j++){
				if(data[j] .score[i] == data[j-1].score[i])
					rank[data[j].id] [i] = rank[data[j-1].id] [i] ;
				else
					rank[data[j].id] [i] = j+1;
			}
		}

		for(int k = 0 ;k<qury ;k++){
			int id = Integer.parseInt(bf.readLine()) ;
			if(rank[id] [0] == 0)
				System.out.println("N/A");

			else{
				int minindex = 0 ;
				int min  = rank[id] [0] ;
				for(int i = 1 ;i<4 ;i++){
					if(rank[id ] [i] < min) {
						min = rank[id][i];
						minindex = i;
					}
				}

				System.out.printf( "%d %c\n" , min , mp[minindex] );
			}
		}
	}

}
