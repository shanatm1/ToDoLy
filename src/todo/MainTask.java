package todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class is for the main task,
 * Its shows the output to the user according to the selection
 */
public class MainTask {



    TaskList taskList = new TaskList();
    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");


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

        /**
         * Update task based on 3 condition
         * @param update title
         * @param update project
         * @param update date
         *
         */
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

    /**
     * This will remove the task corresponding to the select item
     * @param. item of the task to be removed
     */

    public void RemoveTask()
    {
        taskList.printList();
        System.out.println("Choose which taskList to remove:");
        int item = scanner.nextInt();
        taskList.removeTask(item);

    }

    /**
     * The selected status has to be updated
     */
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

    /**
     * This will filter the project by selecting item
     */

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

    /**
     * This will display the project sort by date
     *
     */

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


    public void showStatus()
    {
        int[] status = taskList.showStatus();
        System.out.println("You have " + status[0] + " tasks done and " + status[1] + " tasks to do" );
    }


    //these methods are just for testing



}



