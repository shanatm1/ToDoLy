package todo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskList {
    List<Task> taskList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    //TODO use stream to count the task that is done or undone
    public void addTask() {

        System.out.println();
        System.out.println("The title of the taskList");
        String title = scanner.next();

        System.out.println("Enter your project Name");
        String projectName = scanner.next();

        LocalDate dueDate = Validator.validateDate();

        System.out.println("Is task done? true/false");
        boolean isDone = scanner.nextBoolean();
        //handle incorrect boolean value here..

        Task T = new Task(title, projectName, dueDate, isDone);

        taskList.add(T);
        System.out.println("Task has been added successfully");
        System.out.println("");

    }
    public void updateTasks() {
        printList();

        System.out.println("Choose which taskList to update:");
        int item = scanner.nextInt();

        //option 1
        System.out.println("choose what to update: 1-title, 2- project, 3- date");
        //option 2:
        // ask user to enter the new title, and the new project and the new date
        System.out.println("Enter new title:");
        String title = scanner.next();
        //  This is for edit title
        taskList.get(item).setTitle(title);
        System.out.println("Task has been updated successfully");
    }



    public void RemoveTask()
    {
        printList();
        System.out.println("Choose which taskList to remove:");
        int item = scanner.nextInt();
        taskList.remove(item);
        saveTask();
        System.out.println("The taskList has been removed ");


    }

    public void UpdateStatus () {
        int index = 0;
        Iterator<Task> it = taskList.iterator();
        while (it.hasNext()) {
            System.out.println("(" + index++ + ") " + it.next());
        }
        System.out.println("Choose which taskList status you need to update:");
        int item = scanner.nextInt();
        //  This is for edit title
        System.out.println("Is task done? true/false");
        boolean isDone = scanner.nextBoolean();
        //  This is for edit title
        taskList.get(item).setDone(isDone);
        System.out.println("Task status has been updated successfully");

    }
    public void saveTask() {
        try {
            FileOutputStream fos = new FileOutputStream( "TaskData" );
            ObjectOutputStream oos = new ObjectOutputStream( fos );
            oos.writeObject(taskList);
            oos.close();
        } catch (Exception e) {
            System.out.println("Fail to write");
            e.printStackTrace();
        }
    }


    public void readTask() {
        try {
            FileInputStream fis = new FileInputStream( "TaskData" );
            ObjectInputStream ois = new ObjectInputStream( fis );
            taskList = (ArrayList<Task>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println( "Fail to read" );
            e.printStackTrace();
        }
    }


    public void sortByProject(){
        List<Task> sorted = taskList.stream().sorted(Comparator.comparing(task->task.getProjectName())).collect(Collectors.toList());
        for(Task t:sorted){
            System.out.println(t);

        }
    }

    public void displayByDate(){
        List<Task> sorted = taskList.stream().sorted(Comparator.comparing(task->task.getDueDate())).collect(Collectors.toList());
        for(Task t:sorted){
            System.out.println(t);
        }

        //displayList(sorted);
    }


    private void printList()
    {
        for (int i=0; i < taskList.size(); i++)
        {
            System.out.println("(" + i + ") " + taskList.get(i));
        }
    }


    public void exit() {
       System.out.println("Good Bye!!");
       System.exit(0);


    }

    public void showStatus(){
        int done=0,undone=0;
        for(Task task:taskList){
            if(task.isDone()){
                done++;
            }
            else if (!task.isDone()){
                undone++;
            }

        }
        System.out.println("You have " + done + " tasks done and " + undone + " tasks to do" );
    }


}



