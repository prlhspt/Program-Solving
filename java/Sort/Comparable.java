package Sort;

import java.util.Arrays;
import java.util.Comparator;

public class Comparable {

    public static void main(String[] args) {

        Student[] arr = new Student[9];

        arr[0] = new Student(3, 70);	// 3반 70점
        arr[1] = new Student(1, 70);	// 1반 70점
        arr[2] = new Student(1, 50);	// 1반 50점
        arr[3] = new Student(2, 60);	// 2반 60점
        arr[4] = new Student(2, 80);	// 2반 80점
        arr[5] = new Student(1, 30);	// 1반 30점
        arr[6] = new Student(2, 70);	// 2반 70점
        arr[7] = new Student(3, 90);	// 3반 90점
        arr[8] = new Student(3, 60);	// 3반 60점

        Student[] arr2 = arr.clone();
        Student[] arr3 = arr.clone();

        System.out.print("정렬 전 : ");
        for (Student a : arr) {
            System.out.println(a);
        }
        System.out.println();

        Arrays.sort(arr);

        System.out.print("comparable : ");
        for (Student a : arr) {
            System.out.println(a);
        }
        System.out.println();

        Arrays.sort(arr2, comp1);

        System.out.print("comp1 : ");
        for (Student a : arr2) {
            System.out.println(a);
        }
        System.out.println();

        Arrays.sort(arr3, comp2);

        System.out.print("comp1 : ");
        for (Student a : arr3) {
            System.out.println(a);
        }
        System.out.println();

    }

    static Comparator<Student> comp1 = (o1, o2) -> {
        if (o1.classNum == o2.classNum) {
            return o1.score - o2.score;
        }
        return o1.classNum - o2.classNum;
    };

    static Comparator<Student> comp2 = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.score == o2.score) {
                return o1.classNum - o2.classNum;
            }
            return o2.score - o1.score;
        }
    };
}

class Student implements java.lang.Comparable<Student> {
    int classNum;
    int score;

    public Student(int classNum, int score) {
        this.classNum = classNum;
        this.score = score;
    }
    @Override
    public int compareTo(Student o) {

        if (this.classNum == o.classNum) {
            return o.score - this.score;
        }

        return this.classNum - o.classNum;
    }

    @Override
    public String toString() {
        return "Sort.Student{" +
                "classNum=" + classNum +
                ", score=" + score +
                '}';
    }
}
