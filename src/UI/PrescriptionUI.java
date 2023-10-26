package UI;

import Controller.PrescriptionController;
import Domain.Prescription;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PrescriptionUI extends BaseUI {
    private PrescriptionController controller;

    public PrescriptionUI(PrescriptionController controller) {
        this.controller = controller;
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("----------------------- SEATTLE GRACE HOSPITAL -----------------------");
            System.out.println("----------------------------- PRESCRIPTIONS ---------------------------");
            System.out.println("1. Add Prescription");
            System.out.println("2. Remove Prescription");
            System.out.println("4. View All Prescriptions");
            System.out.println("5. Return To The Main Page");
            System.out.println("6. Log Out");

            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    viewAll();
                    break;
                case 4:
                    running = false;
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    @Override
    public void add() {
        System.out.println("----------------------- ADDING TO DATABASE -----------------------");
        Scanner scanner = new Scanner(System.in);
        Date date;
        int doctorID;
        int patientID;
        System.out.println("Patient ID: ");
        patientID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Doctor ID: ");
        doctorID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Date (format: yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = dateFormat.parse(dateInput);
            controller.add(doctorID,patientID,date);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }
        System.out.println("Patient was added successfully!");
    }

    @Override
    public void remove() {
        System.out.println("----------------------- REMOVING FROM DATABASE -----------------------");
        int medicationID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        medicationID = scanner.nextInt();
        boolean result = controller.remove(medicationID);
        if (result)
            System.out.println("Removal completed");
    }

    @Override
    public void updateInfo() {
        System.out.println("No updates available");
    }

    @Override
    public void viewAll() {
        for (Prescription prescription : controller.getAll()) {
            System.out.println(prescription);
        }

    }
}
