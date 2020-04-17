
// date:3/06  score 30/30

import java.util.*;

public class P1004 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int SumNodes = input.nextInt();    // 节点个数
        int Noleftnode = input.nextInt(); // 非叶子节点的个数
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= SumNodes; i++) {
            List<Integer> chList = new ArrayList<>();
            map.put(i, chList);
        }

        for (int j = 0; j < Noleftnode; j++) {
            int ID = input.nextInt();  // 非叶子节点的编号
            int chnum = input.nextInt(); // 它有多少孩子
            for (int k = 0; k < chnum; k++) {
                int chilID = input.nextInt();
                map.get(ID).add(chilID); // 把孩子加入map中    读到这里我发现这个和邻接表的存储思想是一致的
            }
        }


        //目标是求解每一层有多少叶子节点
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(01);
        while (queue.size() != 0) {
            int nodeNum = queue.size();  // 当前层有这么多父节点
            int count = 0;

            // 处理一层
            for (int i = 0; i < nodeNum; i++) {  // 处理每一个父节点
                int parId = queue.poll();     // 得到一个父节点
                List<Integer> chilist = map.get(parId); //得到该父节点的孩子列表
                // 判断这个孩子列表是否为空 即这个父节点是不是叶子结点
                if (chilist.size() == 0) {  // 如果孩子类表是空 则 这个父节点是一个叶子结点
                    count++;
                } else { // 如果不是空， 把它所有的孩子 都加入队列
                    for (int p = 0; p < chilist.size(); p++)
                        queue.offer(chilist.get(p));
                }
            }
            res.add(count);  // 不管是否为0 都要进行添加 因为每一层都要输出有多少叶子节点
        }

        // 输出最后的答案
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i != res.size() - 1)
                System.out.print(" ");
        }
    }
}
