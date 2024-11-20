package C6_binary_search;

import java.util.Arrays;

//problem statement : Given an N sized array of number of pages in each book (sorted), distribute book in the M students continuously such that we minimise the max number of pages that the students have to read
// i/p = books[] = {10, 20, 30, 40}, M = 2 students
// >>> output = 60, distribution => max(s1 : {10, 20, 30}, s2: {40})
public class A5_book_allocation {
//    hard code - practice
    private static boolean is_possible_configuration(int[] books, int M, int min_pages) {
        int students_used = 1;
        int pages_reading = 0;
        for (int i = 0; i < books.length; i++) {
            if (pages_reading + books[i] > min_pages) {
                students_used++; //students_used denotes the curr student to which we are allocating pages_reading
                pages_reading = books[i];
//                important edge case handling, when one single elem only is greater than the limit
                if (pages_reading > min_pages) {
                    return false;
                }
//                if the count so student is so low that more students are required to fulfill the condition that each student must read only "min-pages" number of pages, then return false
                if (students_used > M) {
                    return false;
                }
            } else {
                pages_reading += books[i];
            }
//            the whole books array is used with each student reading no more than min_pages
        }
        return true;
    }
    public static int max_books(int[] books, int M){
//    here, search space is going to be number of pages as that is what our output is going to be
        int max_books = 0;
        int n = books.length;
        int total_pages = 0;
        for (int pages : books){
            total_pages += pages;
        }
//        define the search space
        int s = books[n - 1]; //in the best case each student reads one book, so max pages any student has to read= max elem of books array.
        int e = total_pages; //in worst case other students will not read any page so 1 student has to read all the pages. Thus min(max pages) = total_pages

        while (s <= e){
            int mid = (s + e) / 2;
//            is it possible that each student reads no more than mid no. of pages?
            if (is_possible_configuration(books, M, mid)){
                max_books = mid;
//             don't stop, search for a even smaller no. of pages that each student has to read
                e = mid - 1;
            }else{
//             it is not possible that each student reads a max of "mid" no. of pages, so reduce the search space to a larger number of pages
                s = mid + 1;
            }
        }
        return max_books;
    }

    public static void main(String[] args) {
        int[] books = {10, 20, 30, 40};
        int M = 2;
        System.out.println(max_books(books, M));

        System.out.println(Arrays.binarySearch(books, 100));
    }
}
