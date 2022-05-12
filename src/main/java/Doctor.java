
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Doctor extends User {

    public int licenceNo;
    public ArrayList<PatientAppoint> doctorAppointments;
    int urgencyLevel;
    public static int doctorNumber = 0;
    public int doctorNo;


    public Doctor(String firstName, String lastName, int licenceNo) {
        super("Doctor");
        this.firstName = firstName;
        this.lastName = lastName;
        this.licenceNo = licenceNo;
        this.doctorAppointments = new ArrayList<PatientAppoint>();
        doctorNumber++;
        this.doctorNo = doctorNumber;
    }


    public static void EditPatientProfile(Patient p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would like to Edit?");
        System.out.println("[0] Exit \n" + "[1] Weight \n" + "[2] Height \n" + "[3] Address");
        int chosenEdit = sc.nextInt();
        while (chosenEdit != 0) {
            switch (chosenEdit) {
                case 1:
                    System.out.println("What is the New Value in Kilograms?");
                    int weightEdit = sc.nextInt();
                    p.setWeight(weightEdit);
                    System.out.println("");
                    System.out.println("Would you like to Exit? ('Y' for Yes, 'N' for No)");
                    sc.nextLine();
                    String ConsoleNWgt = sc.nextLine();
                    if (ConsoleNWgt.equalsIgnoreCase("Y")) {
                        chosenEdit = 0;
                        break;
                    } else if (ConsoleNWgt.equalsIgnoreCase("N")) {
                        System.out.println("What would like to Edit?");
                        System.out.println("[0] Exit \n" + "[1] Weight \n" + "[2] Height \n" + "[3] Address");
                        chosenEdit = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Invalid Answer.");
                        System.out.println("");
                        break;
                    }
                case 2:
                    System.out.println("What is the New Value in Centimeters?");
                    int heightEdit = sc.nextInt();
                    p.setHeight(heightEdit);
                    System.out.println("");
                    System.out.println("Would you like to Exit? ('Y' for Yes, 'N' for No)");
                    sc.nextLine();
                    String ConsoleNHgt = sc.nextLine();
                    if (ConsoleNHgt.equalsIgnoreCase("Y")) {
                        chosenEdit = 0;
                        break;
                    } else if (ConsoleNHgt.equalsIgnoreCase("N")) {
                        System.out.println("What would like to Edit?");
                        System.out.println("[0] Exit \n" + "[1] Weight \n" + "[2] Height \n" + "[3] Address");
                        chosenEdit = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Invalid Answer.");
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.println("What is the New Adress?");
                    sc.nextLine();
                    String addressEdit = sc.nextLine();
                    p.setAddress(addressEdit);
                    System.out.println("");
                    System.out.println("Would you like to Exit? ('Y' for Yes, 'N' for No)");
                    String ConsoleNAdd = sc.nextLine();
                    if (ConsoleNAdd.equalsIgnoreCase("Y")) {
                        chosenEdit = 0;
                        break;
                    } else if (ConsoleNAdd.equalsIgnoreCase("N")) {
                        System.out.println("What would like to Edit?");
                        System.out.println("[0] Exit \n" + "[1] Weight \n" + "[2] Height \n" + "[3] Address");
                        chosenEdit = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Invalid Answer.");
                        System.out.println("");
                        break;
                    }
                default:
                    System.out.println("Invalid Option. Please try again");
                    break;
            }
        }
    }


    public void AddPrescription(Patient p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the Prescription you would like to Add?");
        String pres = sc.nextLine();
        p.getCurrentMeds().add(pres);
    }

    public void AddDiagnosis(Patient p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the Diagnosis you would like to Add?");
        String diag = sc.nextLine();
        p.getDiagnoses().add(diag);
    }

    @Override
    public String toString() {
        return "Doctor" + "[" + doctorNo + "] " + firstName + " " + lastName + " licence: " + licenceNo;
    }

    public int getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(int licenceNo) {
        this.licenceNo = licenceNo;
    }

    public ArrayList<PatientAppoint> getDoctorAppointments() {
        return doctorAppointments;
    }

    public void setDoctorAppointments(ArrayList<PatientAppoint> doctorAppointments) {
        this.doctorAppointments = doctorAppointments;
    }

    public int getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(int urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }



}
