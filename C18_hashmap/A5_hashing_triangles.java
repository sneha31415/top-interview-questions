package C18_problem_solving_using_hashmap;
import java.util.HashMap;

//given N points(x, y) in a 2d cartesian plane, how many right angled triangles can be formed from the points such that
// their perpendicular and base is parallel to X and Y axes
public class A5_hashing_triangles {
    public static int hashing_triangles(int[][] points){
//        x, y hashmaps maintain the count of elem a cord. like how many times x = 2 has occured in points[][]
        HashMap<Integer, Integer> x = new HashMap<>();
        HashMap<Integer, Integer> y = new HashMap<>();

        for(int[] cord : points){
            int x_cord = cord[0];
            int y_cord = cord[1];
            x.put(x_cord, x.getOrDefault(x_cord, 0) + 1);
            y.put(y_cord, x.getOrDefault(y_cord, 0) + 1);
        }

        int hashing_triangles = 0;

        for (int[] cord : points){
//            choosing the pivot
            int x_cord = cord[0];
            int y_cord = cord[1];
//            options to form a triangle from the choosen pivot such that it is parallel to both axes
            int x_options = x.get(x_cord) - 1;
            int y_options = y.get(y_cord) - 1;

            hashing_triangles += x_options * y_options;
        }
        return hashing_triangles;
    }
    public static void main(String[] args) {

    }
}
