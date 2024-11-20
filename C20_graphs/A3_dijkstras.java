package C20_graphs;


import java.util.*;

public class A3_dijkstras {

   static class Pair {
      int distance;
      int node;
      public Pair(int distance, int node){
         this.distance = distance;
         this.node = node;
      }
   }
   public static void dijkstra(int src, List<List<Integer>> adjList){
      HashMap<Integer, Integer> distances = new HashMap<>();
//      tree set will be sorted as per the distances
      TreeSet<Pair> pendingSet = new TreeSet<>((a,b) -> a.distance - b.distance); // distance, Node

//      init all distances except src as infinity
      for (int i = 0; i < adjList.size(); i++){
         distances.put(i, Integer.MAX_VALUE);
      }

//       initialise
      distances.put(src, 0);
      pendingSet.add(new Pair(0, src));

//       process till all node's distance is finalised
      while (!pendingSet.isEmpty()){
         Pair currSrc = pendingSet.pollFirst();

         for (int nbr : adjList.get(currSrc.node)){
            int edge = adjList.get(currSrc.node).get(nbr);
            int oldDist = distances.get(nbr);
            int newDist = distances.get(currSrc.node) + edge;
            if (newDist < oldDist){
//               delete the elem if it exists in the set
               pendingSet.remove(new Pair(oldDist, nbr));

               pendingSet.add(new Pair(newDist, nbr));
//             update the distances in distance map
               distances.put(nbr, newDist);
            }
         }
      }
//      print the distances
      for (int vertex : distances.keySet()){
         System.out.println(vertex + " " + "min distance is : " + distances.get(vertex));
      }
   }

   public static void main(String[] args) {

   }
}
