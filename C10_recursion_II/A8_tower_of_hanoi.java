package C10_recursion_III;

public class A8_tower_of_hanoi {
    public static void print_hanoi_path(int n, char source, char helper, char destination){
        if(n == 0){
            return;
        }
//        move (n - 1) disk from source to helper
        print_hanoi_path(n - 1, source, destination, helper);
//        move the largest disk ie nth disk to destination(base of the tower)
        System.out.println("moving disk " + n + " from " + source + " to " + destination);
//        move the (n - 1) from helper to destination
        print_hanoi_path(n - 1, helper, source, destination);
    }

    public static int countMoves(int n) {
        if (n == 0){
            return 0;
        }
        return 2 * countMoves(n - 1) + 1;
    }
    public static void main(String[] args) {
        print_hanoi_path(3, 'A', 'B', 'C');
        System.out.println(countMoves(3));
    }
}
