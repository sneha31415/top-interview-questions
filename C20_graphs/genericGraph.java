package C20_graphs;

import jdk.jshell.JShell;

import java.util.*;

//generic bidirectional graph
public class genericGraph<T> {
    HashMap<T, List<T>> adjList;
    public genericGraph(){
        adjList = new HashMap<>();
    }
    public void addEdge(T src, T dest){
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());

        adjList.get(src).add(dest);

//      bidirectional
        adjList.get(dest).add(src);
    }

    public void bfs(T src){
        Queue<T> pending = new LinkedList<>();
        HashSet<T> visited = new HashSet<>();

        pending.add(src);
        visited.add(src);

        while(!pending.isEmpty()){
            T currNode = pending.poll();
            System.out.print(currNode + " ");
            for(T neighbour : adjList.get(currNode)){
                if(!visited.contains(neighbour)){
                    pending.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
    }

//    shortest dist is always gotten using BFS traversal
    public void single_source_shortest_path(T src){
        Queue<T> pending = new LinkedList<>();
        HashMap<T, Integer> distances = new HashMap<>();

//        initialise all shortest distances with infinity
        for(T node : adjList.keySet()){
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(src, 0);
        pending.add(src);

        while(!pending.isEmpty()){
            T currNode = pending.poll();
//          the shortest dist of a neighbour is when it is visited for the "FIRST TIME" in "BFS"
            for(T neighbour : adjList.get(currNode)){

  //            this means the neighbour is being visited for the first time
                if(distances.get(neighbour) == Integer.MAX_VALUE){
                    pending.add(neighbour);
                    distances.put(neighbour, distances.get(currNode) + 1);
                }
            }
        }
//        print the shortest distances
        for (T node : distances.keySet()){
            System.out.println("shortest distance from " + src + " to " + node + " is " + distances.get(node));
        }
    }

//    dfs traversal
    public void dfs(T src){
//        we need a visited array to ensure that we dont get stuck in a cycle
        HashSet<T> visited = new HashSet<>();

        dfsRecursive(src, visited);
        System.out.println();
    }
    private void dfsRecursive(T src, HashSet<T> visited){
        visited.add(src);
        System.out.print(src + " ");

        for(T child : adjList.get(src)){
            if(!visited.contains(child)) dfsRecursive(child, visited);
        }
        return;
    }

//    --------------count the number of connected components----------------------
    public int connectedComponents(){
        int cnt = 0; // count of connected components
        HashSet<T> visited = new HashSet<>();

        for (T node : adjList.keySet()) {
            if (!visited.contains(node)) {
                dfsRecursive(node, visited);
                cnt++;
            }
        }
        return cnt;
    }

//    ----------Topological sort for directed acyclic graphs using DFS-----------
    public void topologicalSort(){
        HashSet<T> visited = new HashSet<>();
        List<T> ordering = new ArrayList<>();

        for (T src : adjList.keySet()) {
            if(!visited.contains(src)) {
                topologicalSortRecursive(src, visited, ordering);
            }
        }
//        print the ordering
        for (T order : ordering){
            System.out.print(order + " ");
        }
    }

    public void topologicalSortRecursive(T src, HashSet<T> visited, List<T> ordering){
        visited.add(src);
        for(T child : adjList.get(src)){
            if(!visited.contains(child)) {
                topologicalSortRecursive(child, visited, ordering);

            }
        }
//       add in front of list after getting back from recursive call
        ordering.add(0, src);
    }

//    -------------topological sort using BFS (kahns algo)---------------
    public static void topologicalSortBFS(genericGraph<Integer> g){
        int V = g.adjList.size();
        int[] indegree = new int[V];

//        init the indegree array that stores the indegree of the all the nodes
        for (int node = 0; node < V; node++){
            for (int child : g.adjList.get(node)){
                indegree[child]++;
            }
        }

//        add zero indegree nodes in queue
        Queue<Integer> zeroIndegreeQueue = new LinkedList<>();
        for (int node = 0; node < V; node++){
            if (indegree[node] == 0){
                zeroIndegreeQueue.add(node);
            }
        }

        while(!zeroIndegreeQueue.isEmpty()){
            int currNode = zeroIndegreeQueue.poll();
            System.out.print(currNode + " ");
            for (int neighbour : g.adjList.get(currNode)){
//              decrease indegree of each neighbour by 1
                indegree[neighbour]--;
//                if the decremented indegree of neighbour becomes 0, add it to queue
                if(indegree[neighbour] == 0){
                    zeroIndegreeQueue.add(neighbour);
                }
            }
        }
    }

//    ---------------check if an undirected graph is a tree -----------------
//    an undirected graph is a tree when it does not contain a cycle

//    if you can reach a node from two different nodes, then we have a cycle
    public static boolean isTree(genericGraph<Integer> g){
        int v = g.adjList.size();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> pending = new LinkedList<>();
        int src = 0;
        pending.add(src);
        visited.add(src);
        parent.put(src, src);

//        bfs
        while (!pending.isEmpty()){
            int currnode = pending.poll();
//            explore child of pending
            for (int child : g.adjList.get(currnode)){
                if(visited.contains(child) && parent.get(currnode) != child){
                    return false;
                }
                else if(!visited.contains(child)) {
                    pending.add(child);
                    visited.add(child);
                    parent.put(child, currnode);
                }
            }
        }
        return true;
    }

//    ----------------cycle detection in directed graph--------------------
    public static boolean isCyclic(genericGraph<Integer> g){
        int v = g.adjList.size();
        boolean[] visited = new boolean[v];
        boolean[] stack = new boolean[v];


        return isCyclicHelper(0, g, visited, stack);

    }
    private static boolean isCyclicHelper(int node, genericGraph<Integer> g, boolean[] visited, boolean[] stack){
        visited[node] = true;
        stack[node] = true;

        for (int child : g.adjList.get(node)){
//            Child is present in the curr stack call, this implies a cycle
            if(stack[child]){
                return true;
            }else if (!visited[child]){
                boolean cycleMila = isCyclicHelper(child, g, visited, stack);
                if (cycleMila) return true;
            }
        }
//        remove the curr node from call stack path while backtracking
        stack[node]= false;
        return false;
    }

//   ----------------cycle detection in undirected graph using DFS--------------------
    public static boolean isCycleDirectedDFS(genericGraph<Integer> g){
        int v = g.adjList.size();
        boolean[] visited = new boolean[v];
        boolean isCycle = false;

        return dfsCycleHelper(0, g, visited, -1);

    }

//    IMP : since we are doing a dfs instead of a bfs, so instead of maintaining a parent array, we can maintain parent for each call
//    each call has its copy of src and parent
    private static boolean dfsCycleHelper(int src, genericGraph<Integer> g, boolean[] visited, int parent){
        visited[src] = true;

        for (int nbr : g.adjList.get(src)){
//            two cases
//            if the neighbour is unvisited, so recursively  visit it
            if (!visited[nbr]) {
//              ask nbr if there is a cycle, if nbr se cycle mila, then return true from all
                boolean cycleMila = dfsCycleHelper(nbr, g, visited, src);
                if (cycleMila) return true;
            }
//            if nbr is already visited, it must be the parent of src else a cycle is detected
            else if (nbr != parent){
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        genericGraph<Integer> g = new genericGraph<>();
        g.addEdge(2, 1);
        g.addEdge(1, 0);
        g.addEdge(3, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
//        g.bfs(0);
//        g.single_source_shortest_path(0);
//        g.dfs(0);
//        System.out.println("num connected components: " + g.connectedComponents());
//        g.topologicalSort();
//        System.out.println();
//        topologicalSortBFS(g);
        System.out.println(isTree(g));


    }
}
