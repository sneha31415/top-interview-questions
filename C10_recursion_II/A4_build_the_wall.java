package C10_recursion_III;

// given a wall of size 4 x N, and tiles of size (1, 4) and (4, 1)
// deduce the number of of ways to build the wall

// approach = if we place the first brick in vertical direction , then there are f(n -1) task left
// we can also place the first brick horizontally, in that case we have to place the rest 3 bricks horizonally too. thus f(n - 4) task is left
public class A4_build_the_wall {
    public static int ways_to_build_wall(int wall_size){
//        base case
        if(wall_size < 4){
            return 1;
        }
        return ways_to_build_wall(wall_size - 1) + ways_to_build_wall(wall_size - 4);
    }

    public static void main(String[] args) {
        System.out.println(ways_to_build_wall(5));
    }
}
