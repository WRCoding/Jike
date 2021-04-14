package top.lpepsi;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 林北
 * @description 图
 * @date 2021-04-14 08:48
 */
public class JikeGraph {
    private int[] prev;
    private boolean[] visited;
    private Queue<Integer> queue = new LinkedList<>();
    private Graph graph;

    /**
     * @Author 林北
     * @Description //TODO 广度优先搜索
     * @Param [begin, end] begin起始位置，end结束位置即要搜索的顶点
     * @return void
     **/
    public void BFS(int begin,int end){
        if (begin == end){
            return;
        }
        visited[begin] = true;
        queue.add(begin);
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < graph.getAdj()[w].size(); i++) {
                int q = graph.getAdj()[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == end) {
                        System.out.print(begin+"->");
                        print(prev, begin, end, end);
                        return;
                    }
                }
                visited[q] = true;
                queue.add(q);
            }
        }
    }
    private Graph initGraph(int v){
        Graph graph = new Graph(v);
        graph.insertData(0,1);
        graph.insertData(0,3);
        graph.insertData(1,2);
        graph.insertData(1,4);
        graph.insertData(2,5);
        graph.insertData(3,4);
        graph.insertData(4,5);
        graph.insertData(4,6);
        graph.insertData(5,7);
        graph.insertData(6,7);
        return graph;
    }

    public JikeGraph(int v){
        visited = new boolean[v];
        prev = new int[v];
        Arrays.fill(prev, -1);
        graph = initGraph(v);
    }

    private void print(int[] prev, int begin, int end, int flag) {
        if (prev[end] != 0 && end != begin){
            print(prev,begin,prev[end],flag);
        }
        if (flag != end){
            System.out.print(end+"->");
        }else{
            System.out.print(end+"");
        }
    }

    public static void main(String[] args) {
        JikeGraph jikeGraph = new JikeGraph(8);
        jikeGraph.BFS(0,6);
    }

}

class Graph{
    /**
     * 顶点数
     **/
    private int v;

    /**
     * 邻接表
     **/
    private LinkedList<Integer>[] adj;

    /**
     * @Author 林北
     * @Description //TODO 根据顶点数创建邻接表
     * @Param [v]
     * @return
     **/
    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * @Author 林北
     * @Description//TODO 添加顶点，无向图每条边存两次
     * @Param [s, t]
     * @return void
     **/
    public void insertData(int s, int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }
}
