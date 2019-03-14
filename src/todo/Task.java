package todo;

import java.io.Serializable;
import java.time.LocalDate;

//public class Task implements Comparable<Task>, Serializable {
    public class Task implements  Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String projectName;
    private LocalDate dueDate;
    private boolean isDone;


    public Task(String title, String projectName, LocalDate dueDate, boolean isDone) {
        this.id = id;
        this.title = title;
        this.projectName = projectName;
        this.dueDate = dueDate;
        this.isDone = isDone;
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

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "" +
                " title\t:\t'" + title + '\'' +
                ", dueDate\t:'" + dueDate + '\'' +
                ", taskStatus\t:" + (isDone ? "done" : "undone") +
                ", project\t:'" + projectName + '\''
                ;
    }


}



