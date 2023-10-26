package UI;

import java.util.Objects;
import java.util.Scanner;

public class UI {
    private PatientUI patientUI;
    private MedicationUI medicationUI;
    private DoctorUI doctorUI;

    public UI(PatientUI patientUI, MedicationUI medicationUI, DoctorUI doctorUI) {
        this.patientUI = patientUI;
        this.medicationUI = medicationUI;
        this.doctorUI = doctorUI;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------- WELCOME TO SEATTLE GRACE HOSPITAL -----------------------");
            System.out.println("1. Patients");
            System.out.println("2. Doctors");
            System.out.println("3. Medications");
            System.out.println("4. Appointments");
            System.out.println("5. Prescriptions");
            System.out.println("6. Departments");
            System.out.println("7. Examination Rooms");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            String option;
            switch (choice) {
                case 1:
                    patientUI.menu();
                case 2:
                    doctorUI.menu();
                    break;
                case 3:
                    medicationUI.menu();
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
