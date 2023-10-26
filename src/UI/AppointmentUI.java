package UI;

import Controller.AppointmentController;
import Domain.Appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AppointmentUI extends BaseUI {
    private AppointmentController controller;

    public AppointmentUI(AppointmentController controller) {
        this.controller = controller;
    }

    @Override
    public void menu() {

    }

    @Override
    public void add() {
        System.out.println("----------------------- ADDING TO DATABASE -----------------------");
        Scanner scanner = new Scanner(System.in);
        Date date;
        int doctorID;
        int patientID;
        int roomID;
        System.out.println("Patient ID: ");
        patientID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Doctor ID: ");
        doctorID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Room ID: ");
        roomID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Date (format: yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = dateFormat.parse(dateInput);
            controller.add(patientID, doctorID, date, roomID);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }
        System.out.println("Appointment was added successfully!");
    }

    @Override
    public void remove() {
        System.out.println("----------------------- REMOVING FROM DATABASE -----------------------");
        int appointmentID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        appointmentID = scanner.nextInt();
        boolean result = controller.remove(appointmentID);
        if (result)
            System.out.println("Removal completed");
    }

    @Override
    public void updateInfo() {
        Scanner scanner = new Scanner(System.in);
        int appointmentID;
        System.out.println("Appointment ID: ");
        appointmentID = scanner.nextInt();
        Date date;
        String dateInput = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = dateFormat.parse(dateInput);
            controller.reschedule(appointmentID, date);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }
        System.out.println("Appointment was added successfully!");


    }

    @Override
    public void viewAll() {
        for (Appointment appointment : controller.getAll()) {
            System.out.println(appointment);
        }
    }
}
