package C6_binary_search;
// maximise the number of students getting 100 % scholarship
// N = students
// M = total num of discount coupons
// X = coupons needed to get 100 % scholarship for one student
// Y = coupons that can be taken by one weak student
public class A7_winning_scholarship {
    private static boolean is_possible(int N, int M, int X, int Y, int mid){
//        if num_students = mid get scholarships, then (N - mid) students wont get scholarship. Thus you can take Y coupons from each one of them for the mid number of students
        int non_scholars = (N - mid);
        int total_available_coupons = M + (non_scholars) * Y;
//        the mid number of students require mid * X coupons to get scholarships
        return mid * X <= total_available_coupons;
    }
    public static int maximum_scholarship(int N, int M, int X, int Y){
//        define the subspace for the possibility of ans
        int max_scholarships = 0;
        int s = 0;
        int e = N; //in the best case, all the students can get the scholarship
        while (s <= e){
            int mid = (s + e) / 2;
            if (is_possible(N, M, X, Y, mid)){
                max_scholarships = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return max_scholarships;
    }

    public static void main(String[] args) {
        System.out.println(maximum_scholarship(3, 5, 5, 6));
    }
}
