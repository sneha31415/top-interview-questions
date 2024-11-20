package C11_more_sorting_techniques;

import java.util.ArrayList;
import java.util.Scanner;

public class A5_bucket_sort {
    static class Student{
        String name;
        int marks;

        public Student(String name, int marks){
            this.name = name;
            this.marks = marks;
        }
    }
    public static void bucket_sort(Student[] students){
//        since marks lie in the range 0 to 100
//        Array index used as marks for buckets and arraylist to store multiple students
        ArrayList<Student>[] buckets = new ArrayList[101];
        for (int i = 0; i < buckets.length; i++){
            buckets[i] = new ArrayList<>();
        }
//        add the students in the buckets corresponding to their marks
        for (Student s : students){
            int marks = s.marks;
            buckets[marks].add(s);
        }

//        for printing the highest student first go reverse
        for (int i = (buckets.length - 1); i >= 0; i--){
            for(Student s : buckets[i]){
                System.out.println(s.name + " " + s.marks);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++){
            String name = sc.next();
            int marks = sc.nextInt();
            Student s = new Student(name, marks);
            students[i] = s;
        }
        bucket_sort(students);

    }
}
