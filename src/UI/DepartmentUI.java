package UI;

import Controller.DepartmentController;
import Domain.Department;

import java.util.Scanner;

public class DepartmentUI extends BaseUI{
    private DepartmentController controller;

    public DepartmentUI(DepartmentController controller) {
        this.controller = controller;
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("----------------------- SEATTLE GRACE HOSPITAL -----------------------");
            System.out.println("----------------------------- DEPARTMENTS ---------------------------");
            System.out.println("1. Add Department");
            System.out.println("2. Remove Department");
            System.out.println("3. Update Department's info");
            System.out.println("4. View All Department");
            System.out.println("5. Return To The Main Page");
            System.out.println("6. Log Out");

            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            String option;
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    updateInfo();
                    break;
                case 4:
                    viewAll();
                    break;
                case 5:
                    running = false;
                    break;

                case 6:
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
        String name;
        int concentration;
        System.out.println("Name: ");
        name = scanner.nextLine();
        controller.add(name);
        System.out.println("Department was added successfully!");
    }

    @Override
    public void remove() {
        System.out.println("----------------------- REMOVING FROM DATABASE -----------------------");
        int patientID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        patientID = scanner.nextInt();
        boolean result = controller.remove(patientID);
        if (result)
            System.out.println("Removal completed");
    }

    @Override
    public void updateInfo() {
        System.out.println("----------------------- UPDATING INFORMATION -----------------------");
        Scanner scanner  = new Scanner(System.in);
        int id;
        String name;
        System.out.println("Department ID: ");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("New Name: ");
        name = scanner.nextLine();
        controller.updateName(id,name);
    }

    @Override
    public void viewAll() {
        for(Department department: controller.getAll()){
            System.out.println(department);
        }

    }
}
