package C1_arrays;

public class A3_largest_smallest_in_array {
    public static void smallest_largest(int[] arr){
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int elem : arr){
            if (elem > largest){
                largest = elem;
            }
            if ( elem < smallest){
                smallest = elem;
            }
        }
        System.out.println("The largest elem is " + largest);
        System.out.println("The smallest elem is " + smallest);
    }

    public static void smallest_largest2(int[] arr){
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int elem : arr){
                largest = Math.max(largest, elem);
                smallest = Math.min(smallest, elem);
            }
        System.out.println("The largest elem is " + largest);
        System.out.println("The smallest elem is " + smallest);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3};
        smallest_largest(array);
        smallest_largest2(array);

    }
}
