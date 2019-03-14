package todo;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        TaskList selection = new TaskList();
        Scanner input = new Scanner(System.in);
        int userOpt = 0;

        selection.readTask();

        while (userOpt != 9) {
            System.out.println("    Welcome User");
            System.out.println("---------------------");
            //System.out.println("You have X to do and y task are done");
            selection.showStatus();

            System.out.println("1. Add new todo.Task");
            System.out.println("2. Display Tasks sort by date");
            System.out.println("3. Display Task sort by project");
            System.out.println("4. update Task ");
            System.out.println("5. Remove Task");
            System.out.println("6. update status");
            System.out.println("7. Save ");
            System.out.println("8. Exit ");

            System.out.print("Please select one of the options below: ");
            userOpt = input.nextInt();
            //System.out.println(line);
            //Scanner sc = new Scanner(System.in);
            //String i = sc.nextLine();

            if (userOpt == 8) {
                selection.exit();
            } else if (userOpt == 1) {
                selection.addTask();
            } else if (userOpt == 2) {
                selection.displayByDate();
            } else if (userOpt == 3) {
                selection.sortByProject();
            } else if (userOpt == 4) {
                selection.updateTasks();
            } else if (userOpt == 5) {
                selection.RemoveTask();
            } else if (userOpt == 6) {
                selection.UpdateStatus();
            } else if (userOpt == 7) {
                selection.saveTask();

            }

        }

    }

}
