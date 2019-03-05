import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainSelection {
    List<Task> task= new ArrayList<>();
    private Scanner sc;
    private Scanner sc2;




    public void addTask() {

        System.out.println();
        System.out.println("The title of the task");
        Scanner keyboard = new Scanner(System.in);
        String title = keyboard.nextLine();

        System.out.println("Enter your project Name");
        String projectName = keyboard.nextLine();

        System.out.println("Enter due date");
        String dueDate = keyboard.nextLine();

        System.out.println("Enter status");
        String status = keyboard.nextLine();

        Task T = new Task(title, projectName, dueDate, status);

        task.add(T);
        System.out.println("Task has been added successfully");
        System.out.println("");

    }



      public void displayTasks() {
      Iterator<Task> it = task.iterator();
      while(it.hasNext()) {
          System.out.println(it.next());
      }
    }


    public void exit() {
       System.out.println("Good Bye!!");
       System.exit(0);


    }}



