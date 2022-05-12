import java.awt.image.SinglePixelPackedSampleModel;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.*;

public class UserInputManager {
    Scanner sc = new Scanner(System.in);

    public int retrieveUserType() {
        System.out.println("[1] Patient\n" + "[2] Doctor\n" + "[3] Admin\n" + "[4] Return to homepage");
        int userOption = sc.nextInt();
        return userOption;
    }

    public int retrieveCreationType() {
        System.out.println("[1] Patient\n" + "[2] Doctor\n" + "[3] Return to login\n");
        int userOption = sc.nextInt();
        return userOption;
    }


    public int retrieveLoginOption() {
        System.out.println("[1] Login\n" + "[2] Create an account");
        int loginType = sc.nextInt();
        return loginType;
    }

    public int retrievePatientOption() {
        System.out.println("Choose one of the following options: ");
        System.out.println("[1] Create appointment\n" + "[2] See prescriptions\n" + "[3] See diagnoses\n" + "[4] Self diagnosis\n" + "[0] Exit");
        int patientOption = sc.nextInt();
        return patientOption;
    }

    public int retrieveDoctorOption() {
        System.out.println("Choose one of the following options: ");
        System.out.println("[1] View schedule\n" + "[2] View patient profile\n" + "[3] Edit patient profile\n" +
                "[4] Add patient diagnosis\n" + "[5] Add patient prescriptions\n" + "[6] Add patient to donor waiting list\n" + "[0] Exit");
        int doctorOption = sc.nextInt();

        return doctorOption;
    }

    public int retrieveClinicOption() {
        System.out.println("Choose one of the following options: ");
        System.out.println("[1] View patient list\n" + "[2] View doctor list\n" +
                "[3] Remove doctor from list\n" + "[4] Remove patient from list\n" + "[5] View organ waiting list\n" + "[0] Exit");
        int clinicOption = sc.nextInt();

        return clinicOption;
    }

    public Patient retrievePatientInfo() throws ParseException {
        Patient p1 = null;
        System.out.println("Enter your first name: ");
        String s = sc.nextLine();
        String firstName = sc.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter your height in centimeters: ");
        int height = sc.nextInt();
        System.out.println("Enter your weight in kilograms: ");
        int weight = sc.nextInt();
        System.out.println("Enter your 10 digit phone number (ex. 5146751254): ");
        String p = sc.nextLine();
        String phoneNumber = sc.nextLine();
        while (phoneNumber.length() != 10) {
            System.out.println("Enter a 10-digit phone number. Try again.");
            phoneNumber = sc.nextLine();
        }
        System.out.println("Enter your address (ex. 1234 rue Decarie, Montreal, Quebec, Canada): ");
        String address = sc.nextLine();
        LocalDate date1 = getBirthDate("Enter your date of birth (ex. yyyy-mm-dd): ");
        String gender = retrieveGender();
        p1 = new Patient(firstName, lastName, height, weight, phoneNumber, address, date1, gender);
        return p1;
    }

    public static LocalDate getBirthDate(String question) {
        Scanner sc = new Scanner(System.in);
        boolean Winput = false;
        LocalDate date1 = null;
        while(!Winput) {
            try {
                System.out.println(question);
                String dateInput = sc.nextLine();
                date1 = LocalDate.parse(dateInput);
                Winput = true;
            } catch (Exception e) {
                System.out.println("Invalid format!");
            }
        }
        return date1;
    }

    public static LocalDate getDate(String question) {
        Scanner sc = new Scanner(System.in);
        boolean Winput = false;
        LocalDate date1 = null;
        LocalDate now = LocalDate.now();
        while (!Winput) {
            try {
                System.out.println(question);
                String dateInput = sc.nextLine();
                date1 = LocalDate.parse(dateInput);
                while (date1.isBefore(now)) {
                    System.out.println("You are trying to book an appointment in the past. Enter a new date: ");
                    dateInput = sc.nextLine();
                    date1 = LocalDate.parse(dateInput);
                }
                Winput = true;
            } catch (Exception c) {
                System.out.println("Invalid format!");
            }
        }
        return date1;
    }

    public Doctor retrieveDoctorInfo() {
        System.out.println("Enter your first name: ");
        String s = sc.nextLine();
        String firstName = sc.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter your 6 digit licence number");
        int licenceNo = sc.nextInt();
        while (String.valueOf(licenceNo).length() != 6) {
            System.out.println("Enter a 6-digit licence number. Try again.");
            licenceNo = sc.nextInt();
        }
        Doctor d1 = new Doctor(firstName, lastName, licenceNo);
        return d1;
    }

    public String retrieveGender() {
        System.out.println("Select one of the following options:\n" + "[1] Male\n" + "[2] Female");
        int genderOption = sc.nextInt();
        while (genderOption != 1 || genderOption != 2) {
            if (genderOption == 1) {
                return "Male";
            }
            else if (genderOption == 2) {
                return "Female";
            }
            System.out.println("Invalid Input! Try again.");
            genderOption = sc.nextInt();
        }
        return null;
    }

    public static Patient getPatient(HashMap<String, Patient> patientAccounts) {
        Scanner sc = new Scanner(System.in);
        List<Patient> patientList = new ArrayList<Patient>(patientAccounts.values());
        for (int i = 0; i < patientList.size(); i++) {
            System.out.println(patientList.get(i));
        }
        System.out.println("Enter the number of the patient you would like to see: ");
        int chosenPatient = sc.nextInt();
        for (int i = 0; i < patientList.size(); i++) {
            if (chosenPatient == patientList.get(i).patNo) {
                return patientList.get(i);
            }
            else if (patientList.get(i) == null) {
                System.out.println("Patient not found!");
            }
        }
        if (patientList.size() == 0) {
            System.out.println("There are no patients in the Clinic system.");
        }
        return null;
    }

    public static void viewPatientProfile(HashMap<String, Patient> patientAccounts) {
        Scanner sc = new Scanner(System.in);
        List<Patient> patientList = new ArrayList<Patient>(patientAccounts.values());
        for (int i = 0; i < patientList.size(); i++) {
            System.out.println(patientList.get(i));
        }
        System.out.println("Enter the number of the patient you would like to see: ");
        int chosenPatient = sc.nextInt();
        for (int i = 0; i < patientList.size(); i++) {
            if (chosenPatient == patientList.get(i).patNo) {
                Patient p1 = patientList.get(i);
                System.out.println(p1.firstName + " " + p1.lastName + "\n" + "Height:" + p1.getHeight() + "\n" + "Weight: " + p1.getWeight() + "\n" +
                        "Current Diagnoses: " + p1.getDiagnoses() + "\n" + "Current medications: " + p1.getCurrentMeds());
            }
            else {
                System.out.println("Patient not found!");
            }
        }
        if (patientList.size() == 0) {
            System.out.println("There are no patients in the Clinic system.");
        }

    }

    public static void editPatientProfile(HashMap<String, Patient> patientAccounts) {
        Scanner sc = new Scanner(System.in);
        List<Patient> patientList = new ArrayList<Patient>(patientAccounts.values());
        for (int i = 0; i < patientList.size(); i++) {
            System.out.println(patientList.get(i));
        }
        System.out.println("Enter the number of the patient you would like to see: ");
        int chosenPatient = sc.nextInt();
        for (int i = 0; i < patientList.size(); i++) {
            if (chosenPatient == patientList.get(i).patNo) {
                Patient p1 = patientList.get(i);
                Doctor.EditPatientProfile(p1);
            }
            else {
                System.out.println("Patient not found!");
            }
        }
        if (patientList.size() == 0) {
            System.out.println("There are no patients in the Clinic system.");
        }

    }

    public static void addDiag(HashMap<String, Patient> patientAccounts) {
        Scanner sc = new Scanner(System.in);
        List<Patient> patientList = new ArrayList<Patient>(patientAccounts.values());
        for (int i = 0; i < patientList.size(); i++) {
            System.out.println(patientList.get(i));
        }
        System.out.println("Enter the number of the patient you would like to see: ");
        int chosenPatient = sc.nextInt();
        for (int i = 0; i < patientList.size(); i++) {
            if (chosenPatient == patientList.get(i).patNo) {
                Patient p1 = patientList.get(i);
                System.out.println("Enter a diagnosis to assign the patient: ");
                String s = sc.nextLine();
                String diagnosis = sc.nextLine();
                p1.getDiagnoses().add(diagnosis);
            }
            else {
                System.out.println("Patient not found!");
            }
        }
        if (patientList.size() == 0) {
            System.out.println("There are no patients in the Clinic system.");
        }

    }

    public static void addMeds(HashMap<String, Patient> patientAccounts) {
        Scanner sc = new Scanner(System.in);
        List<Patient> patientList = new ArrayList<Patient>(patientAccounts.values());
        for (int i = 0; i < patientList.size(); i++) {
            System.out.println(patientList.get(i));
        }
        System.out.println("Enter the number of the patient you would like to see: ");
        int chosenPatient = sc.nextInt();
        for (int i = 0; i < patientList.size(); i++) {
            if (chosenPatient == patientList.get(i).patNo) {
                Patient p1 = patientList.get(i);
                System.out.println("Enter a prescription to assign the patient: ");
                String s = sc.nextLine();
                String meds = sc.nextLine();
                p1.getCurrentMeds().add(meds);
            }
            else {
                System.out.println("Patient not found!");
            }
        }
        if (patientList.size() == 0) {
            System.out.println("There are no patients in the Clinic system.");
        }

    }

    public static void addWaitingList (HashMap<String, Patient> patientAccounts, ArrayList<OrganRecipient> waitingList) {
        Scanner sc = new Scanner(System.in);
        List<Patient> patientList = new ArrayList<Patient>(patientAccounts.values());
        for (int i = 0; i < patientList.size(); i++) {
            System.out.println(patientList.get(i));
        }
        System.out.println("Enter the number of the patient you would like to see: ");
        int chosenPatient = sc.nextInt();
        for (int i = 0; i < patientList.size(); i++) {
            if (chosenPatient == patientList.get(i).patNo) {
                Patient p1 = patientList.get(i);
                System.out.println("Enter the type of organ needed: ");
                String organType = UserInputManager.getOrgan();
                System.out.println("Enter the urgency level (1-5): ");
                int urgencyLevel = sc.nextInt();
                while (urgencyLevel < 1 || urgencyLevel > 5) {
                    System.out.println("Please enter a number between 1 and 5. Try again.");
                    urgencyLevel = sc.nextInt();
                }
                OrganRecipient or = new OrganRecipient(p1, urgencyLevel, organType);
                waitingList.add(or);
                System.out.println("Patient added to waiting list.");
            }
            else {
                System.out.println("Patient not found!");
            }
        }
        if (patientList.size() == 0) {
            System.out.println("There are no patients in the Clinic system.");
        }

    }




    public static Doctor getDoctor(HashMap<String, Doctor> doctorAccounts) {
        Scanner sc = new Scanner(System.in);
        List<Doctor> doctorList = new ArrayList<Doctor>(doctorAccounts.values());
        for (int i = 0; i < doctorList.size(); i++) {
            System.out.println(doctorList.get(i));
        }
        System.out.println("Enter the number of the doctor you would like to see: ");
        int chosenDoc = sc.nextInt();
        for (int i = 0; i < doctorList.size(); i++) {
            if (chosenDoc == doctorList.get(i).doctorNo) {
                return doctorList.get(i);
            }
            else {
                System.out.println("Doctor not found!");
            }

        }
        if (doctorList.size() == 0) {
            System.out.println("There are no patients in the Clinic system.");
        }
        return null;
    }

    public static String getPassword() {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        return password;
    }

    public static String getOrgan() {
        Scanner sc = new Scanner(System.in);
        String organ = sc.nextLine();
        return organ;
    }

    public static PatientAppoint retrievePatientAppoint(HashMap<String, Doctor> doctorAccounts, Calendar c) {
        Scanner scApp = new Scanner(System.in);
        int chosenStartHour;
        int chosenEndHour;
        String chosenReason;
        LocalDate date = UserInputManager.getDate("Enter the date of your appointment (ex. yyyy-mm-dd): ");
        System.out.println("When would you like your appointment to begin? (value between: 9 - 17)");
        chosenStartHour = scApp.nextInt();;
        while (chosenStartHour < PatientAppoint.OPENING_HOUR || chosenStartHour > PatientAppoint.CLOSING_HOUR) {
            System.out.println("Clinic is closed at that time. Enter a different time");
            chosenStartHour = scApp.nextInt();
        }
        chosenEndHour = chosenStartHour + 1;
        System.out.println("What is the reason behind your appointment?");
        scApp.nextLine();
        chosenReason = scApp.nextLine();
        System.out.println("");
        PatientAppoint pa = null;
        Doctor d;
        List<Doctor> doctorList = new ArrayList<Doctor>(doctorAccounts.values());
        for (int i = 0; i < doctorList.size(); i++) {
            System.out.println(doctorList.get(i));
        }
        System.out.println("Enter the number of the doctor you would like to see: ");
        int chosenDoc = scApp.nextInt();
        for (int i = 0; i < doctorList.size(); i++) {
            if (chosenDoc == doctorList.get(i).doctorNo) {
                d = doctorList.get(i);
                pa = new PatientAppoint(date,chosenReason,d,chosenStartHour,chosenEndHour);
                d.getDoctorAppointments().add(pa);
                if (c.getCalendarSystem().contains(pa) == false) {
                    c.getCalendarSystem().add(pa);
                    pa.setAvailable(false);
                } else {
                    System.out.println("An appointment is already scheduled.");
                    System.out.println("Please try another date.");
                }
            }
            else {
                System.out.println("Doctor not found! Try again.");
            }

        }
        if (doctorList.size() == 0) {
            System.out.println("There are no doctors in the Clinic system.");
        }
        return pa;
    }




}
