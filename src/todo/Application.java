package todo;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {


        MainTask selection = new MainTask();
        Scanner input = new Scanner(System.in);
        int userOpt = 0;


        while (userOpt != 9) {
            System.out.println("********************");
            System.out.println(">>> Welcome User <<<");
            System.out.println("********************");

            //System.out.println("You have X to do and y task are done");
            System.out.println("=========================================");
            selection.showStatus();
            System.out.println("=========================================");
            System.out.println();

            System.out.println("-->  1. Add new todo.Task");
            System.out.println("-->  2. Display Tasks sort by date");
            System.out.println("-->  3. Display Task sort by project");
            System.out.println("-->  4. update Task ");
            System.out.println("-->  5. Remove Task");
            System.out.println("-->  6. update status");
            System.out.println("-->  7. Save ");
            System.out.println("-->  8. Exit ");
            System.out.println("========================================");

            System.out.print("Please select one of the options above: ");
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
                selection.filterByProject();
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
