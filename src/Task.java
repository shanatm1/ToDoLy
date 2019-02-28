public class Task
{
    //title
    //project
    //dueDate
    //status
    private String title;
    private String projectName;
    private String dueDate;
    private String status;


    //constructor

    public Task(String title,String projectName, String dueDate)
    {
        this.title = title;
        this.projectName = projectName;
        this.dueDate = dueDate;
        this.status = "undone";
    }

    //getter
    public String getTitle()
    {
        return title;
    }

    //setter
    public void setTitle(String title)
    {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return title + "---------" + status;
    }



}
