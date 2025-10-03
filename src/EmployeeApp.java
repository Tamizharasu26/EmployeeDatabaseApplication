import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class EmployeeApp {
    public static void main(String[] args) {
       EmployeeDB emp=new EmployeeDB();
       Scanner sc=new Scanner(System.in);
       while(true){
           System.out.println("1.Add Employee\n2.View Employee\n3.Update Employee Salary\n4.Delete Employee\n5.Exit");
           System.out.print("Enter your choice:");
           int choice=sc.nextInt();
           sc.nextLine();
           switch(choice){
               case 1:
                   System.out.print("Enter name:");
                   String name=sc.nextLine();
                   System.out.print("Enter department:");
                   String dept=sc.nextLine();
                   System.out.print("Enter salary:");
                   double salary=sc.nextDouble();
                   sc.nextLine();
                   emp.addEmployee(name,dept,salary);
                   break;
               case 2:
                   emp.viewEmployee();
                   break;
               case 3:
                   System.out.print("Enter id:");
                   int id=sc.nextInt();
                   sc.nextLine();
                   System.out.print("Enter new salary:");
                   double newSalary=sc.nextDouble();
                   sc.nextLine();
                   emp.updateEmployeeSalary(id,newSalary);
                   break;
               case 4:
                   System.out.print("Enter id:");
                   id=sc.nextInt();
                   sc.nextLine();
                   emp.deleteEmployee(id);
                   break;
               case 5:
                   System.exit(0);
                   break;
               default:
                   System.out.println("Invalid choice");
                   break;
           }
       }
    }
}