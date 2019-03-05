public class Task
{

    private String title;
    private String projectName;
    private String dueDate;
    private String status;




    public Task(String title,String projectName, String dueDate, String status)
    {
        this.title = title;
        this.projectName = projectName;
        this.dueDate = dueDate;
        this.status = status;
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getDueDate()
    {
        return dueDate;
    }

    public  void setDueDate(String dueDate)
    {
        this.dueDate = dueDate;
    }

    public String getStatus()
   {
       return status;
   }
    public void setStatus(String status)
   {
       this.status = status;
    }


    @Override
    public String toString()
    {
       return title + "---------" + status;
    }



}
