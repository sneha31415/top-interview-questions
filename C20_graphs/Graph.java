package C20_graphs;

import java.util.ArrayList;

public class Graph {
    int V;       // num vertices
    ArrayList<ArrayList<Integer>> adjList;
    public Graph(int V){
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void printGraph(){
        for(int src = 0; src < V; src++){
            System.out.print(src + ": ");
            for(int dest : adjList.get(src)){
                System.out.print(dest + " ");
            }
            System.out.println();
        }
    }

    public void addEdge(int src, int dest){
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); //undirected graph
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 2);
        g.printGraph();
    }

}
