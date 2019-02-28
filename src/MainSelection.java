
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainSelection {
    List<Task> task= new ArrayList<>();
    private Scanner sc;
    private Scanner sc2;




    public void addTask() {

        System.out.println("Please enter the project name ");
        sc = new Scanner(System.in);
        String projectName = sc.nextLine();
        String title = sc.nextLine();
        //LocalDate dueDate = sc.nextInt();
        String dueDate = sc.nextLine();
        //TODO how to convert string to date
        //TODO ask user about title and date
        Task t = new Task(title, projectName, dueDate);
        //projectName.add(projectName);
        //System.out.println("project "+projectName+" added sucessfully");
        //System.out.println(project.size());
        System.out.println("task has been added suceesfully");
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


    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MainSelection selection = new MainSelection();
        Boolean exit =  true;
        while(exit) {
            System.out.println("    Welcome User");
            System.out.println("---------------------");
            System.out.println("Please select one of the options below :");
            String line = ("1. Add new Task  \n" +
                    "2. Display Tasks (sort by date, filter by project) \n" +
                    "3. Edit Tasks (Remove, update, update status) \n" +
                    "4. Save And Exit");
            System.out.println(line);
            Scanner sc = new Scanner(System.in);
            String i = sc.nextLine();

            if(i.equals("4")) {
                selection.exit();
            }else if(i.equals("1")){
                selection.addTask();
            }else if(i.equals("2")){
                selection.displayTasks();
           // }else if(i.equals("3")){
               // selection.EditTask();
           // }
        }}
    }}

