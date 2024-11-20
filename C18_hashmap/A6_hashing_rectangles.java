package C18_problem_solving_using_hashmap;

import com.sun.source.tree.Tree;

import java.util.*;

public class A6_hashing_rectangles {
    static class Pair{
        int x;
        int y;
        public Pair(){}
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

//        hash ones need to override this
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Pair pair = (Pair) o;
//            return x == pair.x && y == pair.y;
//        }
//
//        // Override hashCode() to generate hash based on x and y values
//        @Override
//        public int hashCode() {
//            return Objects.hash(x, y);
//        }
    }

//    Brute force way optimised using a set
    public static int hashing_rectangles(int[][] points){
        Set<Pair> allPoints = new TreeSet<>((a, b) -> a.x - b.x);
//      insert all the points in a set for an efficient finding of other two points than diagonal
        for(int[] point : points){
            allPoints.add(new Pair(point[0], point[1]));
        }

        int hashingRectangles = 0;
//      choose the two diagonal points
        for (int i = 0;  i < points.length; i++){
            for (int j = i + 1; j < points.length; j++){
                int[] dia1 = points[i]; // diagonal 1 (x, y) cords
                int[] dia2 = points[j];     // diagonal 2 (x, y) cords

//              skip dia1 and dia2 if the lie in the same horizontal / vertical line.
//              cuz diagonal points cannot be on the same horizontal / vertical line.
                if(dia1[0] == dia2[0] || dia1[1] == dia2[1]){
                    continue;
                }

//              check if dia1 and dia2 form a valid rectangle
//              If p1 = (x1, y1), p2 = (x2, y2) then p3 = (x1, y2) and p4 = (x2, y1)
                if (allPoints.contains(new Pair(dia1[0], dia2[1])) &&
                    allPoints.contains(new Pair(dia2[0], dia1[1]))){
                    hashingRectangles++;
                }
            }
        }

        return hashingRectangles / 2; //to avoid repetions due to rectangle being symmetric
    }
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {0, 1}, {1, 1}, {1, 0}, {2, 1}, {2, 0}, {3, 1}, {3, 0}}; //ans = 6
        System.out.println(hashing_rectangles(points));
    }
}
