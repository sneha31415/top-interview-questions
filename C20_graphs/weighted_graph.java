package C20_graphs;


import java.util.*;

//this is going to be a generic graph, Like nodes can be named as 'A', 'B',etc
//so we will use hashmap, where keys are the src, and (dest, its path weight) are the values
public class weighted_graph  {
    private class Pair{
        String dest;
        int weight;
        public Pair(String dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }
    private HashMap<String, List<Pair>> adjList;
    public weighted_graph(){
        adjList = new HashMap<>();
    }
    public void addEdge(String src, String dest, boolean isBidirectional, int weight){
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.get(src).add(new Pair(dest, weight));

        if(isBidirectional){
            adjList.putIfAbsent(dest, new ArrayList<>());
            adjList.get(dest).add(new Pair(src, weight));
        }
    }

    public void printGraph(){
//        iterate over all the keys(src) of map
        for (String node : adjList.keySet()){
            System.out.print(node + ": ");
//            dest with their wts for a src
            for (Pair dest : adjList.get(node)){
                System.out.print("(" + dest.dest + " " + dest.weight+ ")" + " , ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        weighted_graph g = new weighted_graph();
        g.addEdge("a", "b", true, 10);
        g.addEdge("a", "c", false, 20);
        g.addEdge("b", "d", true, 30);
        g.addEdge("e", "b", false, 40);
        g.printGraph();
    }
}
