package C1_arrays;

import java.util.*;

public class A7_inbuild_sort {
    public static void main(String[] args) {

// it is possible to use custom sort via arrays.sort only when the array is of non primitive datatypes
// you have to reverse by swaping last and first element
        int[] array = {1, 2, 4, 1, 3, 8};
        Arrays.sort(array);
//        Arrays.sort(array, (a, b) -> a-b); isn't possible

//        array list with elements added all toghether
        List<Integer> arrlist = Arrays.asList(1, 2, 4, 1, 3, 8);
//        arrlist.add(3); //but we cannot add further elements
        Collections.sort(arrlist, (a, b) -> a-b);

        List<String> ar2 = new ArrayList<>();
        ar2.add("ball");
        ar2.add("cat");
        ar2.add("monkey");
        ar2.add("apple");

//        sorting using lambda function
        Collections.sort(ar2, (a, b) -> -(a.compareTo(b)));
        for (String x: ar2){
            System.out.print(x + " ");
        }
        System.out.println();

//       lambda function for comparator
        String[] words = {"chea","chiko", "apple", "mango", "banana"};
        Arrays.sort(words, (a, b) ->a.compareTo(b));
        System.out.println(Arrays.toString(words));
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        System.out.println(Arrays.toString(words));

//        custom comparator
        String[] words1 = {"chea","chiko", "apple", "mango", "banana"};
//        implementing the comparator interface via an anonymous class
        Comparator<String> byLength = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("comparing " + o1 + " " + o2 );
                return Integer.compare(o1.length(), o2.length());
            }
        };

        Arrays.sort(words1, byLength);
        System.out.println(Arrays.toString(words1));
        String[] nums = {"30", "34", "3"};
        Arrays.sort(nums, (a, b) ->  b.compareTo(a));
        System.out.println(Arrays.toString(nums));
        System.out.println(Integer.valueOf("000"));

    }
}
