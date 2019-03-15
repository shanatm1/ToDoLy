package todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTask {


    //List<Task> taskList = new ArrayList<>();
    TaskList taskList = new TaskList();
    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    //TODO use stream to count the task that is done or undone
    public void addTask() {

        System.out.println();
        System.out.println("The title of the taskList");
        String title = scanner.next();

        System.out.println("Enter your project Name");
        String projectName = scanner.next();

        LocalDate dueDate = Validator.validateDate();

        System.out.println("Enter status");
        String status = scanner.next();

        taskList.addTask(title, projectName, dueDate, status);


    }
    public void updateTasks() {
        taskList.printList();

        System.out.println("Choose which taskList to update:");
        int item = scanner.nextInt();

        //option 1
        System.out.println("choose what to update: 1--> Title, 2--> Project, 3--> Date");
        int selection = scanner.nextInt();

        switch (selection) {

            case 1:

            System.out.println("Enter new title:");
            String title = scanner.next();
            taskList.updateTitle(item, title);
            break;

            case 2:

                System.out.println("Enter new project name:");
                String projectName = scanner.next();
                //  This is for edit title
                taskList.updateProjectName(item, projectName);
                break;

            case 3:

                LocalDate dueDate = Validator.validateDate();
                taskList.updateDuedate(item, dueDate);
                System.out.println("Date has been edited");

                break;

        }

    }



    public void RemoveTask()
    {
        taskList.printList();
        System.out.println("Choose which taskList to remove:");
        int item = scanner.nextInt();
        taskList.removeTask(item);


    }

    public void UpdateStatus ()
    {
        taskList.printList();
        System.out.println("Choose which taskList status yoy need to update:");
        int item = scanner.nextInt();
        //  This is for edit title
        System.out.println("Enter updated status:");
        String status = scanner.next();
        //  This is for edit title
        taskList.updateStatus(item, status);

    }



    public void filterByProject()
    {
        System.out.println("what project do you want to filter?");
        String projectName = scanner.next();

        ArrayList<Task> filtered = taskList.filterByProject(projectName);


        if (filtered == null || filtered.size() == 0 )
        {
            System.out.println("this project doen't exist");
            return;
        }

        for(Task t : filtered){
            System.out.println(t);

        }
    }

    //TODO no scanner
    public void displayByDate()
    {
        ArrayList<Task> sortByDate = taskList.displayByDate();

        for(Task t : sortByDate){
            System.out.println(t);
        }

        //displayList(sorted);
    }



    public void exit() {
        System.out.println("<<< Thank you for using ToDo list app >>>");
       System.out.println(" Good Bye!! ");
       System.exit(0);


    }

    public void saveTask()
    {
        taskList.saveTask();
    }

    //TODO no scanner
    public void showStatus()
    {
        int[] status = taskList.showStatus();
        System.out.println("You have " + status[0] + " tasks done and " + status[1] + " tasks to do" );
    }


    //these methods are just for testing



}



