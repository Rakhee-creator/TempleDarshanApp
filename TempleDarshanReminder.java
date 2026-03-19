import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.util.ArrayList;

public class TempleDarshanReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> templeName=new ArrayList<>();
        ArrayList<String> dateInput=new ArrayList<>();
        int temples = 5; // number of temples

// Step 1: Input temple names
        for (int i = 0; i < temples; i++) {
            System.out.print("Enter temple name: ");
            templeName.add(sc.nextLine());
        }

// Step 2: Input darshan dates
        for (int i = 0; i < temples; i++) {
            System.out.print("Enter darshan date (yyyy-mm-dd) for " + templeName.get(i) + ": ");
            dateInput.add(sc.nextLine());
        }

// Step 3: Convert each date string to LocalDate and compare
        LocalDate today = LocalDate.now();

        for (int i = 0; i < temples; i++) {
            LocalDate darshanDate = LocalDate.parse(dateInput.get(i));
            Period diff = Period.between(today, darshanDate);

            // Step 4: Reminder logic
            if (diff.getYears() == 0 && diff.getMonths() == 0 && diff.getDays() == 0) {
                System.out.println("Today is your Darshan day at " + templeName.get(i) + "!");
            } else if (diff.getYears() == 0 && diff.getMonths() == 0 && diff.getDays() == 1) {
                System.out.println("Reminder: Darshan at " + templeName.get(i) + " tomorrow!");
            } else {
                System.out.println("Darshan at " + templeName.get(i) + " is after "
//                        + diff.getYears() + " years, "
//                        + diff.getMonths() + " months, "
                        + diff.getDays() + " days.");
            }
        }

        sc.close();
    }
}

