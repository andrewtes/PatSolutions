package pat1101_1155;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// date:3/17
// 10 1.80 1.00
//3 2 3 5
//1 9
//1 4
//1 7
//0
//2 6 1
//1 8
//0
//0
//0
public class P1106 {
    static class Node {
        List<Integer> children = new ArrayList<>();
    }
	static  Node[] nodes ;
    static  int num  =0;
    static  int minDepth = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)) ;
        String [] info = bf.readLine().split(" ") ;
        int Nodenums = Integer.parseInt(info[0]) ;
        double price = Double.parseDouble(info[1]) ;
        double r = Double.parseDouble(info[2])/100 ;
        nodes = new Node[Nodenums] ;
        for(int i = 0 ;i< Nodenums ;i++){ // 读取树的节点信息
        	nodes[i] = new Node() ;
        	String [] nodeInfo = bf.readLine().split(" ") ;
        	int childrenNum  =Integer.parseInt(nodeInfo[0]);
        	if( childrenNum==0)
        		continue;
        	else {
        		for(int j =0 ;j<childrenNum ;j++){

        			nodes[i] .children.add(Integer.parseInt(nodeInfo[j+1])) ;
				}
			}
		}
		DFS(0,0);
        System.out.printf("%.4f %d" , Math.pow((1+r),minDepth)*price , num);

    }

    static  void  DFS(int root , int depth ){
    	if(nodes[root] .children.size() == 0){
    		if(depth < minDepth ){
    			num = 1 ;
    			minDepth = depth ;
			}
    		else  if(depth == minDepth){
    			num ++ ;
			}
    		return;
		}
    	int childrenSize = nodes[root] .children.size() ;
    	for(int k = 0 ;k<childrenSize ;k++){

    		DFS(nodes[root].children.get(k) , depth+1);
		}
	}
}
