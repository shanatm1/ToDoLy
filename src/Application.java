import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MainSelection selection = new MainSelection();
        Scanner input = new Scanner(System.in);
        int userOpt = 0;

        while (userOpt !=4) {
            System.out.println("    Welcome User");
            System.out.println("---------------------");

            System.out.println("1. Add new Task");
            System.out.println("2. Display Tasks (sort by date, filter by project)");
            System.out.println("3. Edit Tasks (Remove, update, update status)");
            System.out.println("4. Save and Exit");

            System.out.print("Please select one of the options below: ");
            userOpt = input.nextInt();
            //System.out.println(line);
            //Scanner sc = new Scanner(System.in);
            //String i = sc.nextLine();

            if(userOpt==4) {
            selection.exit();
            }

            else if(userOpt == 1){
                selection.addTask();
            }

            else if(userOpt == 2) {
                selection.displayTasks();
            }

            //else if(userOpt ==3){
                //selection.EditTask();
                // }
        }
    }
}
