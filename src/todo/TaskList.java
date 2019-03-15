package todo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskList
{
    List<Task> taskList = new ArrayList<>();

    public TaskList()
    {
        readTask();
    }

    //TODO use stream to count the task that is done or undone
    public void addTask(String title, String projectName, LocalDate dueDate, String status)
    {

        Task T = new Task(title, projectName, dueDate, status);

        taskList.add(T);
        System.out.println("Task has been added successfully");
        System.out.println("");

    }


    public void updateProjectName(int index, String project)
    {
        taskList.get(index).setProjectName(project);
        System.out.println("Project name has been edited");
    }


    public void updateTitle(int index, String title)
    {
        taskList.get(index).setTitle(title);
        System.out.println(("the title has been edited"));
    }

    public void updateDuedate(int index, LocalDate dueDate)
    {
        taskList.get(index).setDueDate(dueDate);
        System.out.println("the due date has been edited");
    }


    public void removeTask(int index){
        taskList.remove(index);
        //saveTask();
        System.out.println("The taskList has been removed ");


    }


    //TODO
    public void setStatus(int id,String status ){
        printList();
        System.out.println("Choose the index of the task to update");
        taskList.get(id).setStatus(status);
        saveTask();
    }



    public void updateStatus (int index, String status)
    {
        taskList.get(index).setStatus(status);
        System.out.println("Status has been updated");

    }



    public void saveTask() {
        System.out.println("<<< New changes has been saved to the system >>>");
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


    //TODO   no scanenr
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


    public ArrayList<Task> filterByProject(String projectName)
    {
        ArrayList<Task> filtered = (ArrayList<Task>) taskList.stream()
                .filter(task -> task.getProjectName().equals(projectName)).collect(Collectors.toList());

        if (filtered.size() == 0)
        {
            return null;
        }
        else
            return filtered;

    }

    //TODO no scanner
    public  ArrayList<Task> displayByDate()
    {
        ArrayList<Task> displayDate = (ArrayList<Task>) taskList.stream().sorted(Comparator.comparing(task->task.getDueDate())).collect(Collectors.toList());


        return displayDate;
        //displayList(sorted);
    }


    public void printList()
    {
        for (int i=0; i < taskList.size(); i++)
        {
            System.out.println("(" + i + ") " + taskList.get(i));
        }
    }


    //TODO no scanner
    public int[] showStatus()
    {
        int done=0;
        int undone=0;

        for(Task task:taskList)
        {
            if(task.getStatus().toLowerCase().equals("done")){
                done++;
            }
            else //if (task.getStatus().equals("undone")){
                undone++;

        }

        return new int[]{done, undone};
        //System.out.println("You have " + done + " tasks done and " + undone + " tasks to do" );
    }


    //these methods are just for testing
}
