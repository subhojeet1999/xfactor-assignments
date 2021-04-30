// Author - rudrajit1729
// Student Management System

import java.util.*;
import java.io.*;

class Student{
    private String name, gender, address;
    private int age;

    // Default constructor
    Student(){
        this.name = "";
        this.age = 0;
        this.gender = "";
        this.address = "";
    }

    // Setter Methods
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setAddress(String address){
        this.address = address;
    }

    // Getter methods

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getGender(){
        return this.gender;
    }

    public String getAddress(){
        return this.address;
    }
}

class Department{
    private String name, hod;

    // Default Constructor
    Department(){
        this.name = "";
        this.hod = "";
    }

    // Setter Methods

    public void setName(String name){
        this.name = name;
    }

    public void setHOD(String hod){
        this.hod= hod;
    }

    // Getter Methods

    public String getName(){
        return this.name;
    }

    public String getHOD(){
        return this.hod;
    }
}

class StudentManagementSystem{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int ch, studAge;
        String run = "Y", studName, studGender, studAddr, deptName, deptHOD;

        // ArrayList for storing info.
        ArrayList<Student> student = new ArrayList<Student>();
        ArrayList<Department> department = new ArrayList<Department>();

        System.out.println("---------- Student Management System ----------"+"\n");

        while(run.equalsIgnoreCase("Y"))
        {
            System.out.println("\n1. Add Student\n2. List Student\n3. Remove Student\n4. Add Department\n5. List Department\n6. Remove Department\n");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            sc.nextLine();

            switch(ch){
                case 1:
                    System.out.print("\nEnter student name: ");
                    studName = sc.nextLine();
                    System.out.print("\nEnter student age: ");
                    studAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nEnter student gender: ");
                    studGender = sc.nextLine();
                    System.out.print("\nEnter student address: ");
                    studAddr = sc.nextLine();

                    Student stud = new Student();
                    stud.setName(studName);
                    stud.setAge(studAge);
                    stud.setGender(studGender);
                    stud.setAddress(studAddr);

                    student.add(stud);
                    System.out.println("\nStudent added successfully\n");

                    break;

                case 2:
                    System.out.println("Student Database: \n");
                    System.out.print("Name \t | \t Age \t | \t Gender \t | \t Address\n\n");

                    for(Student st : student)
                        System.out.print(st.getName() + "\t\t" + st.getAge() + "\t\t" +st.getGender() + "\t\t" +st.getAddress() + "\n\n");

                    System.out.println("\n# of students = "+student.size()+"\n");
                    break;

                case 3:
                    System.out.print("\nEnter student name for deletion: ");
                    studName = sc.nextLine();
                    System.out.println();
                    boolean flag = false;

                    ArrayList<Student> temp = new ArrayList<Student>();

                    for(Student st : student){
                        if(st.getName().equalsIgnoreCase(studName)){
                            flag = true;
                            temp.add(st);
                        }
                    }

                    if(flag){
                        student.removeAll(temp);
                        System.out.println("\nStudent record deleted successfully\n");
                    }
                    else{
                        System.out.println("\nStudent name does not exist"+"\n");
                    }
                    break;


                case 4:
                    System.out.print("\nEnter department name: ");
                    deptName = sc.nextLine();
                    System.out.println();
                    System.out.print("Enter department HOD: ");
                    deptHOD = sc.nextLine();

                    Department dept = new Department();
                    dept.setName(deptName);
                    dept.setHOD(deptHOD);

                    department.add(dept);

                    System.out.println("\nDepartment added successfully\n");
                    break;

                case 5:
                    System.out.println("\nDepartment List: \n");
                    System.out.println("Dept \t | \t HOD\n");

                    for(Department dt : department)
                        System.out.print(dt.getName() + "\t\t" + dt.getHOD() + "\n\n");

                    System.out.println("\n# Departments = " + department.size() + "\n");
                    break;

                
                case 6:
	                System.out.print("\nEnter the department name for deletion: ");
	                deptName = sc.nextLine();
	                System.out.println();
	                boolean dFlag = false;

	                ArrayList<Department> dtemp = new ArrayList<Department>();

	                for(Department dt : department){
	                    if(dt.getName().equalsIgnoreCase(deptName)){
	                        dFlag = true;
	                        dtemp.add(dt);
	                    }
	                }

	                if(dFlag){
	                    department.removeAll(dtemp);
	                    System.out.println("\nDepartment removed successfully"+"\n");
	                }

	                else{
	                    System.out.println("Department name does not exist"+"\n");
	                }
	                break;

                default: 
                    System.out.println("Invalid Option :(\n");
            }
            System.out.print("Enter Y/N to continue/exit: ");
            run = sc.nextLine();
        }
        System.out.println("Thank You for using Student Management System");
        sc.close();
    }
}