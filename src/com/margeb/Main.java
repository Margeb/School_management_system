package com.margeb;

import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        String scanner_next;
        Scanner scanner = new Scanner(System.in);
        do
        {
            System.out.println("-----------\nOptions: " +
                    "\n   (S)tudent" +
                    "\n   (T)eacher" +
                    "\n   (Q)uit");
            scanner_next = scanner.next().substring(0,1);

            if(scanner_next.equals("Q"))
            {
                break;
            }
            else if(scanner_next.equals("T"))
            {
                //Show available options about teachers
                do
                {
                    List<Teacher> list = School.getTeacherList();
                    System.out.println("-----------\nTeacher: " +
                            "\n   (L)ist all teachers" +
                            "\n   (F)ind teacher" +
                            "\n   (A)dd teacher" +
                            "\n   (B)ack");

                    scanner_next = scanner.next().substring(0,1);

                    switch (scanner_next)
                    {
                        case "L":
                        {
                            if(list.isEmpty())
                            {
                                System.out.println("There are no teachers hired!");
                                break;
                            }
                            System.out.println("-----------\nList of teachers: ");
                            for(int i = 0; i < list.size() ; i++)
                            {
                                System.out.println(list.get(i) + "\n");
                            }
                            break;
                        }
                        case "F":
                        {
                            System.out.println("-----------\nTeacher's ID: ");
                            int scanner_int = scanner.nextInt();
                            int scanner_int_value;
                            try
                            {
                                System.out.println(list.get(scanner_int-1));
                                System.out.println("Add subjects to this teacher?(Y/N)");
                                scanner_next = scanner.next().substring(0,1);
                                while(scanner_next.equals("Y"))
                                {
                                    System.out.println("Subjects to add: ");
                                    int i = 1;
                                    for(Subjects subject: Subjects.values())
                                    {
                                        System.out.println(i + " - " + subject);
                                        i++;
                                    }
                                    System.out.println("Pick a subject to add: ");
                                    scanner_int_value = scanner.nextInt();
                                    list.get(scanner_int-1).addSubject(Subjects.values()[scanner_int_value]);
                                    System.out.println("Add another subject?(Y/N) ");
                                    scanner_next = scanner.next().substring(0,1);
                                }
                            }
                            catch(Exception e)
                            {
                                System.out.println("There is no teacher with that ID or the ID is incorrect");
                            }


                            break;
                        }
                        case "A":
                        {
                            System.out.println("-----------\nAdding a teacher: " +
                                            "\n Name: ");
                            String name = scanner.next();
                            System.out.println("Last name: ");
                            String last_name = scanner.next();
                            System.out.println("Salary : ");
                            Float salary = scanner.nextFloat();
                            School.addTeacher(new Teacher(name, last_name, salary));
                            break;
                        }
                        case "B":
                        {
                            System.out.println("Going back...");
                            break;
                        }
                        default:
                        {
                            System.out.println("Choose a valid option!");
                            break;
                        }
                    }
                } while(!scanner_next.equals("B"));

            }
            else if (scanner_next.equals("S"))
            {
                //Show available options about students
                do
                {
                    List<Student> list = School.getStudentList();
                    System.out.println("-----------\nStudent: " +
                            "\n   (L)ist all students" +
                            "\n   (F)ind student" +
                            "\n   (A)dd student" +
                            "\n   (B)ack");

                    scanner_next = scanner.next().substring(0,1);

                    switch (scanner_next)
                    {
                        case "L":
                        {
                            if(list.isEmpty())
                            {
                                System.out.println("There are no students here!");
                                break;
                            }
                            System.out.println("-----------\nList of students: ");
                            for(int i = 0; i < list.size() ; i++)
                            {
                                System.out.println(list.get(i) + "\n");
                            }
                            break;
                        }
                        case "F":
                        {
                            System.out.println("-----------\nStudent's ID: ");
                            int scanner_int = scanner.nextInt();
                            int scanner_int_value;
                            try
                            {
                                System.out.println(list.get(scanner_int-1));
                                System.out.println("Modify student?(Y/N)");
                                scanner_next = scanner.next().substring(0,1);
                                while(scanner_next.equals("Y"))
                                {
                                    System.out.println("-----------\n    1 - Change name\n" +
                                                        "    2 - Change last name\n" +
                                                        "    3 - Change grade\n" +
                                                        "    4 - Add subjects\n" +
                                                        "    5 - Pay for classes\n" +
                                                        "    0 - Back");
                                    scanner_int_value = scanner.nextInt();
                                    if(scanner_int_value!=0)
                                    {
                                        switch (scanner_int_value)
                                        {
                                            case 1:
                                            {
                                                System.out.println("Enter new name: ");
                                                scanner_next = scanner.next();
                                                list.get(scanner_int-1).setName(scanner_next);
                                                break;
                                            }

                                            case 2:
                                            {
                                                System.out.println("Enter new last name: ");
                                                scanner_next = scanner.next();
                                                list.get(scanner_int-1).setLast_name(scanner_next);
                                                break;
                                            }

                                            case 3:
                                            {
                                                System.out.println("Enter new grade: ");
                                                int grade = scanner.nextInt();
                                                list.get(scanner_int-1).setGrade(grade);
                                                break;
                                            }

                                            case 4:
                                            {
                                                while(scanner_next.equals("Y"))
                                                {
                                                    System.out.println("Subjects to add: ");
                                                    int i = 1;

                                                    for(Subjects subject: Subjects.values())
                                                    {
                                                        System.out.println(i + " - " + subject);
                                                        i++;
                                                    }
                                                    System.out.println("Pick a subject to add: ");
                                                    scanner_int_value = scanner.nextInt();

                                                    try
                                                    {
                                                        list.get(scanner_int-1).addSubject(Subjects.values()[scanner_int_value]);
                                                    }
                                                    catch (Exception e)
                                                    {
                                                        System.out.println("Choose a valid option!");
                                                    }

                                                    System.out.println("Add another subject?(Y/N) ");
                                                    scanner_next = scanner.next().substring(0,1);
                                                }
                                                break;
                                            }
                                            case 5:
                                            {
                                                System.out.println("Your current debt is " + list.get(scanner_int-1).getBalance() + ". How much do You want to pay?");
                                                Float balance = scanner.nextFloat();
                                                list.get(scanner_int-1).setBalance(-balance);
                                                System.out.println("Thank You! Your current debt is " + list.get(scanner_int-1).getBalance());
                                                break;
                                            }
                                            default:
                                            {
                                                System.out.println("Choose available option(0-5)");
                                                break;
                                            }
                                        }
                                        System.out.println("Anything else to change?(Y/N) ");
                                        scanner_next = scanner.next().substring(0,1);
                                    }
                                    else
                                    {
                                        break;
                                    }

                                }
                            }
                            catch(Exception e)
                            {
                                System.out.println("Invalid ID!");
                            }


                            break;
                        }
                        case "A":
                        {
                            System.out.println("-----------\nAdding a student: " +
                                    "\n Name: ");
                            String name = scanner.next();
                            System.out.println("Last name: ");
                            String last_name = scanner.next();
                            System.out.println("Grade : ");
                            int grade = scanner.nextInt();
                            School.addStudent(new Student(name, last_name, grade));
                            break;
                        }
                        case "B":
                        {
                            System.out.println("Going back...");
                            break;
                        }
                        default:
                        {
                            System.out.println("Choose a valid option!");
                            break;
                        }
                    }
                } while(!scanner_next.equals("B"));



            }
            else
            {
                System.out.println("Choose a valid option!");
            }

        } while (!scanner_next.equals("Q"));

    scanner.close();
    }
}
