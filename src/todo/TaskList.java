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


    public void addTask(String title, String projectName, LocalDate dueDate, String status)
    {

        Task T = new Task(title, projectName, dueDate, status);

        taskList.add(T);
        System.out.println("Task has been added successfully");
        System.out.println("");

    }

    /**
     * This will update the project
     * @param index the position of the task to update its project
     * @param project has been edited
     */
    public void updateProjectName(int index, String project)
    {

        taskList.get(index).setProjectName(project);
        System.out.println("Project name has been edited");
    }

    /**
     * this will update the title
     * @param index will select which title has to update
     * @param title has to be updated
     */
    public void updateTitle(int index, String title)
    {
        taskList.get(index).setTitle(title);
        System.out.println(("the title has been edited"));
    }

    /**
     * This will update the due date
     * @param index will select which date has to update
     * @param dueDate has been edited
     */
    public void updateDuedate(int index, LocalDate dueDate)
    {
        taskList.get(index).setDueDate(dueDate);
        System.out.println("the due date has been edited");
    }

    /**
     * This will remove the task
     * @param index will select which task has to be removed
     */
    public void removeTask(int index){
        taskList.remove(index);
        //saveTask();
        System.out.println("The taskList has been removed ");


    }


    public void setStatus(int id,String status ){
        printList();
        System.out.println("Choose the index of the task to update");
        taskList.get(id).setStatus(status);
        saveTask();
    }


    /**
     * This will update the status of the task
     * @param index will select which task status has to be updated
     * @param status  will update the status of the selected task
     */
    public void updateStatus (int index, String status)
    {
        taskList.get(index).setStatus(status);
        System.out.println("Status has been updated");

    }

    /**
     * This will save the task
     */

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

    /**
     * This will display the project by filtering
     * @param projectName can be filter to display
     * @return the filtered project
     */

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


    /**
     * this mehtod display the task by date
     * @return an array list of tasks order by date
     */
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

    /**
     * This will show the status of the task
     * @return show done if it completed
     * @return  show undone if it is not completed
     */
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

    }


}
