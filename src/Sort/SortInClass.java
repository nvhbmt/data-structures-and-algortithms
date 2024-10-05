package Sort;

import java.util.Arrays;
import java.util.Comparator;


public class SortInClass {
    static class Student implements Comparable {
        int age;
        String name;

        public Student(String name, int age) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }


        @Override
        public int compareTo(Object other) {
            Student otherStudent = (Student) other;
            if (this.age == otherStudent.age) return 0;
            if (this.age > otherStudent.age) return 1;
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] intArray = {3, 2, 1, 0};
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));


        Student[] students = {
                new Student("A", 20),
                new Student("B", 10),
        };
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(Arrays.toString(students));

    }
}
