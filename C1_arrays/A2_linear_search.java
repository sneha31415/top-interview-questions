package C1_arrays;

public class A2_linear_search {
    public static int linearSearch(int[] search_array, int target) {
        for (int i = 0; i < search_array.length; i++) {
            if (search_array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void linearSearch2(int[] search_array, int target) {
        int i = 0;
        for (; i < search_array.length; i++) {
            if (search_array[i] == target) {
                System.out.println("target found at " + i);
                break; //break the for loop but not the function
            }
        }
//        we need a if statement cuz bcuz this line will be reached even if the element is found cuz we re using "break" and not "return"
        if (i == search_array.length) {
            System.out.println("target not found");
        }
    }



    public static void main(String[] args) {
        int[] search_array = {1, 2, 4, 4, 10, 5, 8};
        System.out.println(linearSearch(search_array, 5));
        linearSearch2(search_array, 10);


    }
}
