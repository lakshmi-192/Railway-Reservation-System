import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Ticket {
    String name;
    String trainNumber;
    String source;
    String destination;
    String date;

    public Ticket(String name, String trainNumber, String source, String destination, String date) {
        this.name = name;
        this.trainNumber = trainNumber;
        this.source = source;
        this.destination = destination;
        this.date = date;
    }

    public void displayTicket() {
        System.out.println("Name: " + name);
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Date: " + date);
    }
}

public class RailwayReservationSystem {
    private Map<String, Ticket> tickets;
    private Scanner scanner;

    public RailwayReservationSystem() {
        tickets = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void bookTicket() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Enter source: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter date: ");
        String date = scanner.nextLine();

        Ticket ticket = new Ticket(name, trainNumber, source, destination, date);
        tickets.put(trainNumber, ticket);
        System.out.println("Ticket booked successfully!");
    }

    public void cancelTicket() {
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        if (tickets.containsKey(trainNumber)) {
            tickets.remove(trainNumber);
            System.out.println("Ticket cancelled successfully!");
        } else {
            System.out.println("Ticket not found!");
        }
    }

    public void displayTicket() {
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        if (tickets.containsKey(trainNumber)) {
            Ticket ticket = tickets.get(trainNumber);
            ticket.displayTicket();
        } else {
            System.out.println("Ticket not found!");
        }
    }

    public void run() {
        while (true) {
            System.out.println("Railway Reservation System");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    displayTicket();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void main(String[] args) {
        RailwayReservationSystem system = new RailwayReservationSystem();
        system.run();
    }
}