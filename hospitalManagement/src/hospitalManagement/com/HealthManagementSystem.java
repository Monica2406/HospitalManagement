package hospitalManagement.com;

import java.util.*;

class Patient {
    private int id;
    private String name;
    private int age;
    private String ailment;
    private String contact;

    public Patient(int id, String name, int age, String ailment, String contact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAilment() {
        return ailment;
    }

    public void setAilment(String ailment) {
        this.ailment = ailment;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + "\n" +
               "Name: " + name + "\n" +
               "Age: " + age + "\n" +
               "Ailment: " + ailment + "\n" +
               "Contact: " + contact;
    }
}

public class HealthManagementSystem {
    private final List<Patient> patients = new ArrayList<>();

    public void addPatient() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Patient pat : patients) {
            if (pat.getId() == id) {
                System.out.println("Patient with the given ID already exists!");
                return;
            }
        }

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Patient Ailment: ");
        String ailment = scanner.nextLine();

        System.out.print("Enter Patient Contact: ");
        String contact = scanner.nextLine();

        patients.add(new Patient(id, name, age, ailment, contact));
        System.out.println("Patient added successfully!");
    }

    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients to display.");
            return;
        }

        for (Patient pat : patients) {
            System.out.println(pat);
            System.out.println();
        }
    }

    public void searchPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Patient ID to search: ");
        int id = scanner.nextInt();

        for (Patient pat : patients) {
            if (pat.getId() == id) {
                System.out.println(pat);
                return;
            }
        }

        System.out.println("Patient not found!");
    }

    public void modifyPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Patient ID to modify: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Patient pat : patients) {
            if (pat.getId() == id) {
                System.out.println("Current Details:");
                System.out.println(pat);
                System.out.println();

                System.out.print("Enter new name (leave blank to keep current): ");
                String name = scanner.nextLine();
                if (!name.isBlank()) {
                    pat.setName(name);
                }

                System.out.print("Enter new age (leave blank to keep current): ");
                String ageInput = scanner.nextLine();
                if (!ageInput.isBlank()) {
                    pat.setAge(Integer.parseInt(ageInput));
                }

                System.out.print("Enter new ailment (leave blank to keep current): ");
                String ailment = scanner.nextLine();
                if (!ailment.isBlank()) {
                    pat.setAilment(ailment);
                }

                System.out.print("Enter new contact (leave blank to keep current): ");
                String contact = scanner.nextLine();
                if (!contact.isBlank()) {
                    pat.setContact(contact);
                }

                System.out.println("Patient details updated successfully!");
                return;
            }
        }

        System.out.println("Patient not found!");
    }

    public void deletePatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();

        Iterator<Patient> iterator = patients.iterator();
        while (iterator.hasNext()) {
            Patient pat = iterator.next();
            if (pat.getId() == id) {
                iterator.remove();
                System.out.println("Patient deleted successfully!");
                return;
            }
        }

        System.out.println("Patient not found!");
    }

    public void deleteAllPatients() {
        patients.clear();
        System.out.println("All patients deleted successfully!");
    }

    public static void main(String[] args) {
        HealthManagementSystem system = new HealthManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== Health Management System ==========");
            System.out.println("1. Add Patient");
            System.out.println("2. Display Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Modify Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Delete All Patients");
            System.out.println("7. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.addPatient();
                    break;
                case 2:
                    system.displayPatients();
                    break;
                case 3:
                    system.searchPatient();
                    break;
                case 4:
                    system.modifyPatient();
                    break;
                case 5:
                    system.deletePatient();
                    break;
                case 6:
                    system.deleteAllPatients();
                    break;
                case 7:
                    System.out.println("Thank you for using the Health Management System!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
