package org.example.comparatorProblems;

import org.example.comparator.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortStudents {
    public static void main(String[] args){
        List<Student> students = new ArrayList<>();
        Student student = new Student("Akshay",25);
        Student student1 = new Student("Akshay",26);
        Student student2 = new Student ("Bob",24);

        students.add(student);
        students.add(student1);
        students.add(student2);

      List<Student> students1 =  students.stream().sorted(Comparator.comparing(Student::getName).reversed()
                .thenComparing(Student::getAge))
                .collect(Collectors.toUnmodifiableList());

     students1.forEach(s-> System.out.println(s.getName()));

    }
}
