import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student> {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student that) {
        return ((this.age > that.age) ? 1 : -1);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

}

public class ComparableLearning {
    static ArrayList<Student> students;

    public static void main(String[] args) {
        students = new ArrayList<>();
        getStudents();
        displayStudents();
        Collections.sort(students);
        displayStudents();
    }

    private static void displayStudents() {
        System.out.println("student details");
        for (Student student : students) {
            System.out.println(student.name + " " + student.age);

        }
    }

    private static void getStudents() {

        Scanner scan = new Scanner(System.in);
        System.out.println("enter the student size:");
        int size = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < size; i++) {
            System.out.println("enter the name:");
            String name = scan.nextLine();
            System.out.println("enter the age:");
            int age = scan.nextInt();
            scan.nextLine();
            students.add(new Student(name, age));

        }
    }
}
