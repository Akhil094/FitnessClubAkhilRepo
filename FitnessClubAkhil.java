import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FitnessClubAkhil {
    private HashMap<String, ArrayList<String>> bookings;
    private HashMap<String, HashMap<String, Integer>> attendance;

    public static double YOGA_PRICE = 0;
    public static double ZUMBA_PRICE = 0;
    public static double Aquasice_PRICE = 0;
    public static double BoxFit_PRICE = 0;

    public FitnessClubAkhil() {
        this.bookings = new HashMap<>();
        this.attendance = new HashMap<>();
    }

    public void viewTimetable() {
        System.out.println("Timetable:");
        System.out.println("Saturday:");
        System.out.println("  9:00am - Zumba");
        System.out.println(" 11:00am - Yoga");
        System.out.println("  2:00pm - Aquasice");
        System.out.println("  4:00pm - BoxFit");
        System.out.println("Sunday:");
        System.out.println(" 10:00am - Yoga");
        System.out.println(" 12:00pm - Zumba");
        System.out.println("  3:00pm - Aquasice");
        System.out.println("  5:00pm - BoxFit");
    }

    public void viewBookings() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        ArrayList<String> userBookings = bookings.get(name);
        if (userBookings == null || userBookings.isEmpty()) {
            System.out.println("No bookings found for " + name);
            return;
        }
        System.out.println("Bookings for " + name + ":");
        for (String booking : userBookings) {
            System.out.println("- " + booking);
        }
    }

    public void makeBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the lesson you want to book: ");
        String lesson = scanner.nextLine();
        ArrayList<String> userBookings = bookings.getOrDefault(name, new ArrayList<>());
        if (userBookings.contains(lesson)) {
            System.out.println("You have already booked this lesson.");
        } else {
            userBookings.add(lesson);
            bookings.put(name, userBookings);
            System.out.println("Booking successful!");
            if (lesson.equals("Yoga")){
                YOGA_PRICE = YOGA_PRICE + 10;
                
            }
            else if (lesson.equals("Zumba")){
                ZUMBA_PRICE = ZUMBA_PRICE + 20;
            }
            else if (lesson.equals("Aquasice")){
                Aquasice_PRICE = Aquasice_PRICE + 50;
            }
            else if (lesson.equals("BoxFit")){
                BoxFit_PRICE = BoxFit_PRICE + 15;
            }
        }
    }

    public void cancelBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        ArrayList<String> userBookings = bookings.get(name);
        if (userBookings == null || userBookings.isEmpty()) {
            System.out.println("No bookings found for " + name);
            return;
        }
        System.out.print("Enter the lesson you want to cancel: ");
        String lesson = scanner.nextLine();
        if (!userBookings.contains(lesson)) {
            System.out.println("You have not booked this lesson.");
        } else {
            userBookings.remove(lesson);
            bookings.put(name, userBookings);
            System.out.println("Booking cancelled!");
        }
    }

    public void HighestIncome(){
                       if (YOGA_PRICE < ZUMBA_PRICE) {
            if(BoxFit_PRICE < ZUMBA_PRICE){
                if(Aquasice_PRICE < ZUMBA_PRICE){
                    System.out.println("The most elevated pay creating lesson is ZUMBA.");
                }
            }
            
        } 

        if (ZUMBA_PRICE < YOGA_PRICE) {
            if(BoxFit_PRICE < YOGA_PRICE){
                if(Aquasice_PRICE < YOGA_PRICE){
                    System.out.println("The most elevated pay creating lesson is Yoga.");
                }
            }
        } 

        if (ZUMBA_PRICE < Aquasice_PRICE) {
            if(YOGA_PRICE < Aquasice_PRICE){
                if(BoxFit_PRICE < Aquasice_PRICE){
                    System.out.println("The most elevated pay creating lesson is Aquasice.");
                }
            }
        } 
        if (ZUMBA_PRICE < BoxFit_PRICE) {
            if(BoxFit_PRICE < BoxFit_PRICE){
                if(YOGA_PRICE < BoxFit_PRICE){
                    System.out.println("The most elevated pay creating lesson is BoxFit.");
                }
            }
        } 

        else {
            System.out.println("There are 0 bookings made by the customer so the earning of each lesson is zero");
        }
    }

    public void averageRating() {
        System.out.println("Average Rating:");
        System.out.println("Saturday:");
        System.out.println("- Zumba: " + getAverageRatingForLesson("Zumba") + " (" + getNumCustomersForLesson("Zumba") + " customers)");
        System.out.println("- Yoga: " + getAverageRatingForLesson("Yoga") + " (" + getNumCustomersForLesson("Yoga") + " customers)");
        System.out.println("- Aquasice: " + getAverageRatingForLesson("Aquasice") + " (" + getNumCustomersForLesson("Aquasice") + " customers)");
        System.out.println("- BoxFit: " + getAverageRatingForLesson("BoxFit") + " (" + getNumCustomersForLesson("BoxFit") + " customers)");
        System.out.println("Sunday:");
        System.out.println("- Yoga: " + getAverageRatingForLesson("Yoga") + " (" + getNumCustomersForLesson("Yoga") + " customers)");
        System.out.println("- Zumba: " + getAverageRatingForLesson("Zumba") + " (" + getNumCustomersForLesson("Zumba") + " customers)");
        System.out.println("- Aquasice: " + getAverageRatingForLesson("Aquasice") + " (" + getNumCustomersForLesson("Aquasice") + " customers)");
        System.out.println("- BoxFit: " + getAverageRatingForLesson("BoxFit") + " (" + getNumCustomersForLesson("BoxFit") + " customers)");
    }
    
    private int getNumCustomersForLesson(String lesson) {
        int count = 0;
        for (ArrayList<String> userBookings : bookings.values()) {
            if (userBookings.contains(lesson)) {
                count++;
            }
        }
        return count;
    }
    
    private double getAverageRatingForLesson(String lesson) {
        double totalRating = 0;
        int count = 0;
        for (HashMap<String, Integer> userAttendance : attendance.values()) {
            if (userAttendance.containsKey(lesson)) {
                totalRating += userAttendance.get(lesson);
                count++;
            }
        }
        if (count > 0) {
            return totalRating / count;
        } else {
            return 0;
        }
    }
    


    

    public void attendLesson() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the lesson you attended: ");
        String lesson = scanner.nextLine();
        HashMap<String, Integer> userAttendance = attendance.getOrDefault(name, new HashMap<>());
        if (userAttendance.containsKey(lesson)) {
            System.out.print("You have already attended this lesson. Would you like to update your rating? (Y/N)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                System.out.print("Enter your rating (1-5): ");
                int rating = scanner.nextInt();
                userAttendance.put(lesson, rating);
                attendance.put(name, userAttendance);
                System.out.println("Rating updated!");
            }
        } else {
            System.out.print("Did you attend the lesson? (Y/N) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                System.out.print("Enter your rating (1-5): ");
                int rating = scanner.nextInt();
                userAttendance.put(lesson, rating);
                attendance.put(name, userAttendance);
                System.out.println("Attendance recorded!");
            }
        }
    }
    
    public static void main(String[] args) {
        FitnessClubAkhil FitnessClubAkhil = new FitnessClubAkhil();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Weekend Fitness Club!");
        boolean exit = false;
        while (!exit) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. View timetable");
            System.out.println("2. Make a booking");
            System.out.println("3. Cancel a booking");
            System.out.println("4. View your bookings");
            System.out.println("5. Attend a lesson");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    FitnessClubAkhil.viewTimetable();
                    break;
                case 2:
                    FitnessClubAkhil.makeBooking();
                    break;
                case 3:
                    FitnessClubAkhil.cancelBooking();
                    break;
                case 4:
                    FitnessClubAkhil.viewBookings();
                    break;
                case 5:
                    FitnessClubAkhil.attendLesson();
                    break;
                case 6:
                    FitnessClubAkhil.averageRating();
                    break;
                case 7:
                    FitnessClubAkhil.HighestIncome();
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        System.out.println("Thank you for using the Weekend Fitness Club system!");
    }
}    