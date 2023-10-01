import java.io.*;
import java.util.*;

import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
class Driver implements Serializable{
    String unique_id;
    String driver_name;
    String driver_age;
    String driver_cnic;
    String driver_license;

    Driver(String unique_id, String driver_name, String driver_age, String driver_cnic, String driver_license) {
        this.unique_id = unique_id;
        this.driver_name = driver_name;
        this.driver_age = driver_age;
        this.driver_cnic = driver_cnic;
        this.driver_license = driver_license;
    }


    @Override
    public String toString() {
        return
                "unique_id=" + unique_id +
                        " driver_name=" + driver_name +
                        " driver_age= " + driver_age +
                        " driver_cnic= " + driver_cnic +
                        " driver_license= " + driver_license;
    }
}
class Student implements Serializable{
    String student_unique_id;
    String student_name;
    String student_class;
    String student_drop_location;
    Student(String student_unique_id, String student_name, String student_class, String student_drop_location) {
        this.student_unique_id=student_unique_id;
        this.student_name=student_name;
        this.student_class=student_class;
        this.student_drop_location=student_drop_location;
    }


    @Override
    public String toString() {
        return
                "unique_id=" + student_unique_id +
                        " student_name= " + student_name +
                        " student class= " + student_class +
                        " student drop location= " + student_drop_location;
    }
}
class Bus implements Serializable{
    String bus_number;
    String bus_model;
    String bus_driver;
    String bus_route;
    Bus(String bus_number, String bus_model, String bus_driver, String bus_route) {
        this.bus_number = bus_number;
        this.bus_model=bus_model;
        this.bus_driver=bus_driver;
        this.bus_route=bus_route;
    }


    @Override
    public String toString() {
        return
                "Bus Number=" + bus_number +
                        " Bus Model= " + bus_model +
                        " Bus Driver= " + bus_driver +
                        " Bus route= " + bus_route;
    }
}
class Project{
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int PASSWORD = 12345;
        int password;
        File new_driver = new File("add_new_driver.txt");
        File new_student = new File("add_new_student.txt");
        File buses = new File("add_bus.txt");
        ArrayList<Driver> add_new = new ArrayList<Driver>();
        ArrayList<Student> add_students = new ArrayList<>();
        ArrayList<Bus> add_bus = new ArrayList<>();

        System.out.println("----------------------------------------------------------------------");

        System.out.println("ENTER WHO YOU ARE ------");
        System.out.println("1: MANAGER");
        System.out.println("2: STUDENT");
        System.out.println("3: DRIVER");
        int person=input.nextInt();
        switch (person) {
            case 1:
                ObjectOutputStream Driver = null;
                ObjectInputStream driver = null;
                ObjectOutputStream Student = null;
                ObjectInputStream student = null;
                ObjectOutputStream Bus = null;
                ObjectInputStream bus = null;
                ListIterator li3 = null;
                ListIterator li = null;
                ListIterator li2 = null;
                while (true) {
                    try {
                        System.out.println("Enter your ID");
                        password = input.nextInt();

                        if (password == PASSWORD) {
                            System.out.println("You are true user");
                            break;
                        } else {
                            System.out.println("Wrong ID\nTRY AGAIN");
                        }
                    } catch (InputMismatchException e) {
                        input.nextLine();
                        System.out.println("ID must be in integer");
                        System.out.println("Try again");
                    }
                }
                int i = -1;
                do {

                    try {
                        if (new_driver.isFile()) {
                            driver = new ObjectInputStream(new FileInputStream(new_driver));
                            add_new = (ArrayList<Driver>) driver.readObject();
                            driver.close();
                        }
                    } catch (IOException io) {
                        System.out.print("");
                    }
                    try {
                        if (new_student.isFile()) {
                            student = new ObjectInputStream(new FileInputStream(new_student));
                            add_students = (ArrayList<Student>) student.readObject();
                            student.close();
                        }
                    } catch (IOException e) {
                        System.out.println("ioexception");
                    }
                    try {
                        if (buses.isFile()) {
                            bus = new ObjectInputStream(new FileInputStream(buses));
                            add_bus = (ArrayList<Bus>) driver.readObject();
                            bus.close();
                        }
                    } catch (IOException E) {
                        System.out.println();
                    }
                    System.out.println("-----------------------------------------------------\n");

                    System.out.println("1 ADD DRIVER ");
                    System.out.println("2 VIEW DRIVER DATA");
                    System.out.println("3 UPDATE DRIVER DATA");
                    System.out.println("4: DELETE DRIVER");
                    System.out.println("5 ADD STUDENT ");
                    System.out.println("6: VIEW STUDENT DATA ");
                    System.out.println("7: MODIFY STUDENT DATA");
                    System.out.println("8: DELETE STUDENT");
                    System.out.println("9: Add BUS and ROUTE");
                    System.out.println("10: View BUSES and DRIVER ");
                    System.out.println("11: DELETE BUS RECORD ");
                    System.out.println("0 to exit ");
                    System.out.println("Now enter your choice");

                    System.out.println();
                    i = input.nextInt();
                    switch (i) {
                        case 1:
                            System.out.println("welcome and fill this information");
                            System.out.println("Enter the number of Drivers you want to enter the data");
                            int number = input.nextInt();
                            for (int j = 0; j < number; j++) {
                                System.out.println("Enter unique ID of the Driver ");
                                String unique_id = input.next();
                                System.out.println("Enter driver name");
                                String name = input.next();
                                System.out.println("enter driver age");
                                String age = input.next();
                                System.out.println("enter 13 digit CNIC of driver");
                                String cnic = input.next();
                                System.out.println("enter licence number of driver");
                                String license = input.next();
                                add_new.add(new Driver(unique_id, name, age, cnic, license));
                            }
                            Driver = new ObjectOutputStream(new FileOutputStream(new_driver));
                            Driver.writeObject(add_new);
                            Driver.close();
                            break;
                        case 2:
                            if (new_driver.isFile()) {
                                driver = new ObjectInputStream(new FileInputStream(new_driver));
                                add_new = (ArrayList<Driver>) driver.readObject();
                                driver.close();
                                li = add_new.listIterator();
                                while (li.hasNext()) {
                                    System.out.println(li.next());
                                }
                            }

                            break;
                        case 3:
                            if (new_driver.isFile()) {
                                driver = new ObjectInputStream(new FileInputStream(new_driver));
                                add_new = (ArrayList<Driver>) driver.readObject();
                                driver.close();
                                boolean update_driver = false;
                                System.out.println("enter unique id to UPDATE a driver");
                                String update_driver_data = input.next();
                                li = add_new.listIterator();
                                while (li.hasNext()) {
                                    Driver m = (Driver) li.next();
                                    if (m.unique_id.equals(update_driver_data)) {
                                        System.out.println("enter new user name");
                                        String driver_name = input.next();
                                        System.out.println("enter new driver age");
                                        String driver_age = input.next();
                                        System.out.println("enter new 13 digit CNIC of driver");
                                        String driver_cnic = input.next();
                                        System.out.println("enter new licence number of driver");
                                        String driver_license = input.next();
                                        li.set(new Driver(update_driver_data, driver_name, driver_age, driver_cnic, driver_license));
                                        update_driver = true;
                                    }
                                    break;
                                }
                                if (update_driver) {
                                    Driver = new ObjectOutputStream(new FileOutputStream(new_driver));
                                    Driver.writeObject(add_new);
                                    Driver.close();
                                    System.out.println("Driver updated sucessfully");
                                } else
                                    System.out.println("Record not found");
                            } else {
                                System.out.println("file not found");
                            }
                            break;

                        case 4:
                            if (new_driver.isFile()) {
                                driver = new ObjectInputStream(new FileInputStream(new_driver));
                                add_new = (ArrayList<Driver>) driver.readObject();
                                driver.close();
                                boolean delete_driver = false;
                                System.out.println("enter unique id to delete a driver");
                                String delete_id_driver = input.next();
                                li = add_new.listIterator();
                                while (li.hasNext()) {
                                    Driver m = (Driver) li.next();
                                    if (m.unique_id.equals(delete_id_driver)) {
                                        li.remove();
                                        delete_driver = true;
                                    }
                                    if (delete_driver) {
                                        Driver = new ObjectOutputStream(new FileOutputStream(new_driver));
                                        Driver.writeObject(add_new);
                                        Driver.close();
                                        System.out.println("Driver deleted sucessfully");
                                    } else
                                        System.out.println("Record not found");
                                }
                            } else {
                                System.out.println("file not found");
                            }
                            break;


                        //###############     STUDENT CLASS     #####################


                        case 5:
                            System.out.println("welcome and fill this information");
                            System.out.println("enter the number of Students you want to enter the data");
                            int number1 = input.nextInt();
                            for (int j = 0; j < number1; j++) {
                                System.out.println("Enter unique ID of the Student ");
                                String student_id = input.next();
                                System.out.println("Enter student name");
                                String name = input.next();
                                System.out.println("Enter student class");
                                String stu_class = input.next();
                                System.out.println("Enter the adress of student ");
                                String adress = input.next();
                                add_students.add(new Student(student_id, name, stu_class, adress));
                            }
                            Student = new ObjectOutputStream(new FileOutputStream(new_student));
                            Student.writeObject(add_students);
                            Student.close();
                            break;
                        case 6:
                            if (new_student.isFile()) {
                                student = new ObjectInputStream(new FileInputStream(new_student));
                                add_students = (ArrayList<Student>) student.readObject();
                                student.close();
                                try {
                                    li2 = add_students.listIterator();
                                    while (li2.hasNext()) {
                                        System.out.println(li2.next());
                                    }
                                } catch (NullPointerException n) {
                                    System.out.println("null");
                                }
                            }
                            break;
                        case 7:
                            if (new_student.isFile()) {
                                student = new ObjectInputStream(new FileInputStream(new_student));
                                add_students = (ArrayList<Student>) student.readObject();
                                student.close();
                                boolean update_student = false;
                                System.out.println("enter unique id to modify a student data");
                                String update_student_data = input.next();
                                li2 = add_students.listIterator();
                                while (li2.hasNext()) {
                                    Student s = (Student) li2.next();
                                    if (s.student_unique_id.equals(update_student_data)) {
                                        System.out.println("enter new Student name");
                                        String student_name = input.next();
                                        System.out.println("Enter new student class");
                                        String student_class = input.next();
                                        System.out.println("Enter new adress of the student");
                                        String student_adress = input.next();
                                        li2.set(new Student(update_student_data, student_name, student_class, student_adress));
                                        update_student = true;
                                        System.out.println("Student data updated sucessfully");
                                        break;
                                    } else
                                        System.out.println("Your data is not matched");
                                }
                                if (update_student) {
                                    Student = new ObjectOutputStream(new FileOutputStream(new_student));
                                    Student.writeObject(add_students);
                                    Student.close();
                                    System.out.println("Record UPDATED successfully");
                                } else
                                    System.out.println("Record not found");
                            } else {
                                System.out.println("file not found");
                            }
                            break;
                        case 8:
                            if (new_student.isFile()) {
                                student = new ObjectInputStream(new FileInputStream(new_student));
                                add_students = (ArrayList<Student>) student.readObject();
                                student.close();
                                boolean delete_student = false;
                                System.out.println("enter unique id to DELETE a student data");
                                String update_student_data = input.next();
                                li2 = add_students.listIterator();
                                while (li2.hasNext()) {
                                    Student s = (Student) li2.next();
                                    if (s.student_unique_id.equals(update_student_data)) {
                                        li2.remove();
                                        delete_student = true;
                                        System.out.println("Student data Deleted sucessfully");
                                        break;
                                    } else
                                        System.out.println("Your data is not matched");
                                }
                                if (delete_student) {
                                    Student = new ObjectOutputStream(new FileOutputStream(new_student));
                                    Student.writeObject(add_students);
                                    Student.close();
                                    System.out.println("Record DELETED successfully");
                                } else
                                    System.out.println("Record not found");

                            } else {
                                System.out.println("file not found");
                            }
                            break;


                        //#############         BUSES CLASS        ###################


                        case 9:
                            System.out.println("welcome and fill this information");
                            System.out.println("enter the number of BUSES you want to enter the data");
                            int num = input.nextInt();
                            for (int j = 0; j < num; j++) {
                                System.out.println("Enter the Number Regestration Number ");
                                String bus_unique_id = input.next();
                                System.out.println("Enter the Bus Model");
                                String model = input.next();
                                System.out.println("Enter Bus Driver");
                                String bus_driver = input.next();
                                System.out.println("Enter Bus Route");
                                String route = input.next();
                                add_bus.add(new Bus(bus_unique_id, model, bus_driver, route));
                            }
                            Bus = new ObjectOutputStream(new FileOutputStream(buses));
                            Bus.writeObject(add_bus);
                            Bus.close();

                            break;
                        case 10:
                            if (buses.isFile()) {
                                bus = new ObjectInputStream(new FileInputStream(buses));
                                add_bus = (ArrayList<Bus>) bus.readObject();
                                bus.close();
                                try {
                                    li3 = add_bus.listIterator();
                                    while (li3.hasNext()) {
                                        System.out.println(li3.next());
                                    }
                                } catch (NullPointerException n) {
                                    System.out.println("null");
                                }
                            }
                            break;
                        case 11:
                            if (buses.isFile()) {
                                bus = new ObjectInputStream(new FileInputStream(buses));
                                add_bus = (ArrayList<Bus>) bus.readObject();
                                bus.close();
                                boolean delete_bus = false;
                                System.out.println("enter Bus Regestration number to DELETE a BUS");
                                String delete_BUS = input.next();
                                li3 = add_bus.listIterator();
                                while (li3.hasNext()) {
                                    Bus b = (Bus) li3.next();
                                    if (b.bus_number.equals(delete_BUS)) {
                                        li3.remove();
                                        delete_bus = true;
                                        System.out.println("Bus data Deleted sucessfully");
                                        break;
                                    } else
                                        System.out.println("Your BUS regestration number is not matched");
                                    break;
                                }
                                if (delete_bus) {
                                    Bus = new ObjectOutputStream(new FileOutputStream(buses));
                                    Bus.writeObject(add_bus);
                                    Bus.close();
                                    System.out.println("Record DELETED successfully");
                                } else
                                    System.out.println("Record not found");

                            } else {
                                System.out.println("file not found");
                            }
                            break;
                        default:
                    }

                } while (i != 0);



                //--------------------------------------------MAIN STUDENT CLASS ---------------------------------------------------------------



            case 2:
                String STU_REG = "SP22-BSE-030";
                String STU_PASS = "asif";
                System.out.println("Enter your regestration Number");
                String stu_reg = input.next();
                System.out.println("Enter your Password");
                String stu_pass = input.next();
                for (int j = 1; j > 0;j++) {
                    if ((STU_REG.equals(stu_reg)) && (STU_PASS.equals(stu_pass))) {
                        System.out.println("You are valid user");
                        break;
                    } else {
                        System.out.println("You are invalid user");
                        System.out.println("Enter a valid registration no: ");
                        stu_reg = input.next();
                        System.out.println("Enter a valid password: ");
                        stu_pass = input.next();
                    }
                    if ((STU_REG.equals(stu_reg)) && (STU_PASS.equals(stu_pass))) {
                        System.out.println("You are valid user");
                        break;
                    }
                }
                int activity=-1;
                do {
                    System.out.println("--------------------------------------");
                    System.out.println("Which activity do you want to perform: ");
                    System.out.println("1. VIEW ROUTE AND BUS ");
                    System.out.println("2. MAKE REGESTRATION ");
                    System.out.println("3. CHEK REGESTRATION ");
                    System.out.println("4. UPDATE DATA ");
                    System.out.println("0: to exit");
                    activity = input.nextInt();
                    switch (activity) {
                        case 1:
                            if (buses.isFile()) {
                                bus = new ObjectInputStream(new FileInputStream(buses));
                                add_bus = (ArrayList<Bus>) bus.readObject();
                                bus.close();
                                try {
                                    li3 = add_bus.listIterator();
                                    while (li3.hasNext()) {
                                        System.out.println(li3.next());
                                    }
                                } catch (NullPointerException n) {
                                    System.out.println("null");
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Enter unique ID of the Student ");
                            String student_id = input.next();
                            System.out.println("Enter student name");
                            String name = input.next();
                            System.out.println("Enter student class");
                            String stu_class = input.next();
                            System.out.println("Enter the Location of student ");
                            String adress = input.next();
                            add_students.add(new Student(student_id, name, stu_class, adress));
                            Student = new ObjectOutputStream(new FileOutputStream(new_student));
                            Student.writeObject(add_students);
                            Student.close();
                            break;
                        case 3:
                            try{
                                if (new_student.isFile()) {
                                    student = new ObjectInputStream(new FileInputStream(new_student));
                                    add_students = (ArrayList<Student>) student.readObject();
                                    student.close();
                                    boolean search = false;
                                    System.out.println("Enter your name to search your regestration");
                                    String search_reg = input.next();
                                    li2 = add_students.listIterator();
                                    while (li2.hasNext()) {
                                        Student s = (Student) li2.next();
                                        if (s.student_name.equals(search_reg)) {
                                            search = true;
                                            System.out.println("Your regestration has been done");
                                            break;
                                        } else
                                            System.out.println("You are still not registered");break;

                                    }
                                }
                            }catch (ClassNotFoundException c){
                                System.out.println("Class not Found Exception");

                            }
                            break;
                        case 4:
                            if (new_student.isFile()) {
                                student = new ObjectInputStream(new FileInputStream(new_student));
                                add_students = (ArrayList<Student>) student.readObject();
                                student.close();
                                boolean update_student = false;
                                System.out.println("Enter you name to update your information");
                                String update_student_data = input.next();
                                li2 = add_students.listIterator();
                                while (li2.hasNext()) {
                                    Student s = (Student) li2.next();
                                    if (s.student_name.equals(update_student_data)) {
                                        System.out.println("enter new Student name");
                                        String student_name = input.next();
                                        System.out.println("Enter new student class");
                                        String student_class = input.next();
                                        System.out.println("Enter new adress of the student");
                                        String student_adress = input.next();
                                        li2.set(new Student(update_student_data, student_name, student_class, student_adress));
                                        update_student = true;
                                        System.out.println("Student data updated sucessfully");
                                        break;
                                    } else
                                        System.out.println("You are still not regestered");
                                }
                                if (update_student) {
                                    Student = new ObjectOutputStream(new FileOutputStream(new_student));
                                    Student.writeObject(add_students);
                                    Student.close();
                                    System.out.println("Record UPDATED successfully");
                                } else
                                    System.out.println("Record not found");
                            } else {
                                System.out.println("file not found");
                            }
                            break;
                        default:
                            System.out.println("ALERT: You have entered the wrong option");

                    }
                }while (activity!= 0);


                // ---------------------------------------- MAIN DRIVER CLASS ------------------------------------------------------



            case 3:
                while (true) {
                    try {
                        System.out.println("Enter your ID");
                        password = input.nextInt();

                        if (password == PASSWORD) {
                            System.out.println("You are true user");
                            break;
                        } else {
                            System.out.println("Wrong ID\nTRY AGAIN");
                        }
                    } catch (InputMismatchException e) {
                        input.nextLine();
                        System.out.println("ID must be in integer");
                        System.out.println("Try again");
                    }
                }
                System.out.println("------------WELCOME-------------");
                int option =-1;
                while(option!=0) {
                    System.out.println(" 1: CHEK DEUTY ROUTE DETAIL");
                    System.out.println(" 2: UPDATE INFORMATION");
                    System.out.println(" 0: TO EXIT");
                    option = input.nextInt();
                    switch (option){
                        case 1:
                            if (buses.isFile()) {
                                bus = new ObjectInputStream(new FileInputStream(buses));
                                add_bus = (ArrayList<Bus>) bus.readObject();
                                bus.close();
                                try {
                                    li3 = add_bus.listIterator();
                                    while (li3.hasNext()) {
                                        System.out.println(li3.next());
                                    }
                                } catch (NullPointerException n) {
                                    System.out.println("null");
                                }
                            }
                            break;
                        case 2:
                            if (new_driver.isFile()) {
                                driver = new ObjectInputStream(new FileInputStream(new_driver));
                                add_new = (ArrayList<Driver>) driver.readObject();
                                driver.close();
                                boolean update_driver = false;
                                System.out.println("Enter you name to update your data");
                                String update_driver_data = input.next();
                                li = add_new.listIterator();
                                while (li.hasNext()) {
                                    Driver m = (Driver) li.next();
                                    if (m.driver_name.equals(update_driver_data)) {
                                        System.out.println("enter new user name");
                                        String driver_name = input.next();
                                        System.out.println("enter new driver age");
                                        String driver_age = input.next();
                                        System.out.println("enter new 13 digit CNIC of driver");
                                        String driver_cnic = input.next();
                                        System.out.println("enter new licence number of driver");
                                        String driver_license = input.next();
                                        li.set(new Driver(update_driver_data, driver_name, driver_age, driver_cnic, driver_license));
                                        update_driver = true;
                                    }else
                                        System.out.println("SORRY: Your data in not found");
                                    break;
                                }
                                if (update_driver) {
                                    Driver = new ObjectOutputStream(new FileOutputStream(new_driver));
                                    Driver.writeObject(add_new);
                                    Driver.close();
                                    System.out.println("Driver updated sucessfully");
                                } else
                                    System.out.println("Record not found");
                            } else {
                                System.out.println("file not found");
                            }
                            break;
                        default:
                            System.out.println("ALERT: You have entered the wrong option");

                    }
                }






        }
    }
}