package todo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TaskTest {

    private Task task1;
    private Task emptyTask;

    @Before
    public void setUp() throws Exception
    {
        task1 = new Task("tit", "pro", LocalDate.now(), "done");
        emptyTask = new Task();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setAndGetTitleTest()
    {
        assertEquals("tit", task1.getTitle());
        task1.setTitle("new tit");
        assertEquals("new tit", task1.getTitle());

        emptyTask.setTitle("sdf");
        assertEquals("sdf", emptyTask.getTitle());
    }

    @Test
    public void setAndGetProjectNameTest() {
        task1.setProjectName("new pro");
        assertEquals("new pro", task1.getProjectName());

    }

    @Test
    public void setAndGetDuedateTest() {
        LocalDate lo=LocalDate.now();
        task1.setDueDate(lo);
        assertEquals(lo, task1.getDueDate());
    }


    @Test
    public void setAndGetStatusTest() {
        task1.setStatus("Done");
        assertEquals("Done", task1.getStatus());
    }



    @Test
    public void getIdTest() {
    }

    @Test
    public void toStringTestTest() {
    }
}