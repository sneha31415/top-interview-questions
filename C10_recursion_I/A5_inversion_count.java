package C10_recursion_II_implementation_based;
// brute force is O(n ^ 2)
//optimal = O(n logn)
// count inversions such that a[i]>a[j] for i < j
public class A5_inversion_count {
    private static int merge(int[] input, int s, int e){
        int m = (s + e) / 2;
        int i = s;
        int j = m + 1;
        int k = 0;
        int[] result = new int[e - s + 1];
        int count = 0;
        while (i <= m && j <= e){
            if (input[i] > input[j]){
                result[k++] = input[j++];
//                key step
                count += m - i + 1;
            }else{
                result[k++] = input[i++];
            }
        }
        while (i <= m){
            result[k++] = input[i++];
        }
        while (j <= e){
            result[k++] = input[j++];
        }
//        copy the sorted order back into original array
        for (int idx = 0; idx < result.length; idx++){
            input[idx + s] = result[idx];
        }
        return count;
    }
    public static int inversion_count(int[] input, int s, int e){
//        base case
//        no inversion counts are possible if
        if (s >= e){
            return 0;
        }
        int mid = (s + e) / 2;
        int x = inversion_count(input, s, mid);
        int y = inversion_count(input, mid + 1, e);
        int cross_inversions = merge(input, s, e);
        return x + y + cross_inversions;
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 0};
        System.out.println(inversion_count(arr, 0, arr.length - 1));
    }
}
