package C11_more_sorting_techniques;

public class A2_inversion_count {
    public static int inversion_count(int[] input, int s, int e){
//        single element cant be compared
        if(s >= e){
            return 0;
        }
        int mid = (s + e) / 2;
        int x = inversion_count(input, s, mid);
        int y = inversion_count(input, mid + 1, e);
        int z = merge(input, s, e);
        return x + y + z;
    }
    private static int merge(int[] input, int s, int e){
        int mid = (s + e) / 2;
        int i = s;
        int j = mid + 1;
        int inver_counts = 0;

        int k = 0;
        int[] storage = new int[e - s + 1];
        while (i <= mid && j <= e){
            if(input[i] > input[j]){
                inver_counts += (mid - i + 1);
                storage[k++] = input[j++];
            }else{
                storage[k++] = input[i++];
            }
        }
        while(i <= mid){
            storage[k++] = input[i++];
        }
        while(j <= e){
            storage[k++] = input[j++];
        }

//        copy back storage array into temp
        for (int idx = 0; idx < k; idx++){
            input[idx + s] = storage[idx];
        }

        return inver_counts;
    }
    public static void main(String[] args) {
        int[] input = {6, 1, 2, 3, 4, 5};
        System.out.println(inversion_count(input, 0, input.length - 1));
    }
}
