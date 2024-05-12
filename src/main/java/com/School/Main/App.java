package com.School.Main;

import com.School.dao.StudentDao;
import com.School.model.Student;


import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    private static Scanner sc=new Scanner(System.in);
    private static StudentDao studentDao=new StudentDao();
    private static Student student=new Student();
    public static void main(String[] args) {
        while (true){
            System.out.println("1 , Save Student");
            System.out.println("2 , get All Students");
            System.out.println("3 , update Students");
            System.out.println("4 , delete Students");
            System.out.println("5 , Exit");
            System.out.println("Enter your choice");

            int choice= sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    saveStudents();
                    break;
                case 2:
                    getAllStudents();
                    break;
                case 3:
                    updateStudents();
                    break;
                case 4:
                    deleteStudents();
                    break;
                case 5:
                    System.out.println("Exiting the program");
                    System.exit(2);
                default:
                    System.out.println("Invalid choice, please try again");
            }
        }

    }
    private static void saveStudents(){
        System.out.println("Enter firstName");
        String  firstName= sc.nextLine();
        System.out.println("Enetr lastName");
        String  lastName=sc.nextLine();
        System.out.println("Emter email");
        String email=sc.nextLine();

        studentDao.saveStudent(firstName,lastName,email);
    }

    private  static void getAllStudents(){
        List<Student> st=studentDao.getStudent();
        for (Student sts: st){
            System.out.println(sts);
        }
    }

    private static void updateStudents(){
        student.setFirstName("Prashant");
        student.setLastName("Kumar");
        student.setEmail("prashant@gamil.com");
        student.setId(3);
        System.out.println(studentDao.updateStudent(student));
    }

    private static void deleteStudents(){
        System.out.println("Enter id");
        int id= sc.nextInt();
        System.out.println(studentDao.deleteStudent(id));
    }
}
