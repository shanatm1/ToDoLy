package todo;

/**
  * ToDo List App
  *
  * @author shana
  * @version 2019-03-15


 */
import java.io.Serializable;
import java.time.LocalDate;


  /**
   *  Task class

   */
//public class Task implements Comparable<Task>, Serializable {
    public class Task implements  Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String projectName;
    private LocalDate dueDate;
    private String status;


    public Task(){}

    public Task(String title, String projectName, LocalDate dueDate, String status) {
        this.id = id;
        this.title = title;
        this.projectName = projectName;
        this.dueDate = dueDate;
        this.status = status;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "" +
                " title\t:\t'" + title + '\'' +
                ", dueDate\t:'" + dueDate + '\'' +
                ", taskStatus\t:" + status +
                ", project\t:'" + projectName + '\''
                ;
    }


}



