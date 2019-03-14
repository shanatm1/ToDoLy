package todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validator {
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    //validate date
    public static LocalDate validateDate() {
        LocalDate localDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (true) {
            System.out.println("Enter due date with format dd-MM-yyyy");
            String dateString = scanner.next();
            //option1 for validating int: int fdgd = scanner.nextInt();
            //option2: int fgdg =Integer.parseInt(dateString);
            try {
                localDate = LocalDate.parse(dateString, formatter);

                return localDate;
            } catch (Exception e) {
                System.out.println("you enter invalid date");
            }
        }

    }


    //validate number with min and max value


    public int validateNumber(int maxRange) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter a number >> ");
        while (true) {
            try {
                // get input as a int
                int res = scanner.nextInt();
                // check the range
                if (res >= 0 && res <= maxRange) {
                    // valid input = true
                    return res;
                } else {
                    System.out.println(" out of range detected! Please enter again");
                }
            } catch (Exception e) {
                System.out.println(" invalid input! please enter a number");
            }
        }

    }
}