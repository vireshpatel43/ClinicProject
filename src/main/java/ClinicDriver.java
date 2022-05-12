import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

public class ClinicDriver {
    public ArrayList<Doctor> doctorAccounts;

    public static void main(String[] args) throws ParseException {
        UserInputManager uim = new UserInputManager();
        Scanner scannerMain = new Scanner(System.in);
        Calendar c = new Calendar();
        ArrayList<OrganRecipient> waitingList = new ArrayList<>();
        HashMap<String, Doctor> doctorAccounts = new HashMap<>();
        HashMap<String, Patient> patientAccounts = new HashMap<>();


        while (true) {
            System.out.println("Welcome to Vanier Clinic Application");
            int loginChoice = uim.retrieveLoginOption();
            switch (loginChoice) {
                case 1:
                    int userType = uim.retrieveUserType();
                    switch (userType) {
                        case 1:
                            System.out.println("Patient portal");
                            System.out.println("Enter the password associated with your account: ");
                            String password = UserInputManager.getPassword();
                            Patient p = patientAccounts.get(password);

                                int patientOption = -1;
                                while (patientOption != 0 && p != null) {
                                    patientOption = uim.retrievePatientOption();
                                    switch (patientOption) {
                                        case 0:
                                            System.out.println("Return to login page");
                                            break;

                                        case 1:
                                            UserInputManager.retrievePatientAppoint(doctorAccounts, c);
                                            break;

                                        case 2:
                                            System.out.println("Prescriptions: ");
                                            System.out.println(p.getCurrentMeds());
                                            break;

                                        case 3:
                                            System.out.println("Diagnoses: ");
                                            System.out.println(p.getDiagnoses());
                                            break;

                                        case 4:
                                            SelfDiagnosis sd = new SelfDiagnosis();
                                            sd.DiagnosisProgram();
                                            System.out.println("");
                                            break;

                                        default:
                                            System.out.println("Invalid input. Try again.");
                                    }

                                }

                            if (p == null) {
                                System.out.println("Invalid password!");
                            }
                            break;

                        case 2:
                            System.out.println("Doctor portal");
                            System.out.println("Enter the password associated with your account: ");
                            String dPassword = UserInputManager.getPassword();
                            Doctor d = doctorAccounts.get(dPassword);
                                int doctorOption = -1;
                                while (doctorOption != 0 && d != null) {
                                    doctorOption = uim.retrieveDoctorOption();
                                    switch (doctorOption) {
                                        case 0:
                                            System.out.println("Return to login page");
                                            break;

                                        case 1:
                                            System.out.println("Schedule: ");
                                            c.DisplayDoctorCalendar(d, c.getCalendarSystem());
                                            break;

                                        case 2:
                                            UserInputManager.viewPatientProfile(patientAccounts);
                                            break;

                                        case 3:
                                            UserInputManager.editPatientProfile(patientAccounts);
                                            break;

                                        case 4:
                                            UserInputManager.addDiag(patientAccounts);
                                            break;

                                        case 5:
                                            UserInputManager.addMeds(patientAccounts);
                                            break;

                                        case 6:
                                            UserInputManager.addWaitingList(patientAccounts, waitingList);
                                            break;

                                        default:
                                            System.out.println("Invalid input. Try again.");

                                    }
                                }
                            if (d == null) {
                                System.out.println("Invalid password!");
                            }
                            break;

                        case 3:
                            System.out.println("Clinic portal");
                            System.out.println("Enter the key provided by the admin: ");
                            String adminKey = UserInputManager.getPassword();
                                int clinicOption = -1;
                                while (clinicOption != 0 && adminKey.equals("43Clinicapp")) {
                                    clinicOption = uim.retrieveClinicOption();
                                    switch (clinicOption) {
                                        case 0:
                                            System.out.println("Return to login page");
                                            break;

                                        case 1:
                                            System.out.println("Patient list: ");
                                            List<Patient> patientList = new ArrayList<Patient>(patientAccounts.values());
                                            for (int i = 0; i < patientList.size(); i++) {
                                                System.out.println(patientList.get(i));
                                            }
                                            break;

                                        case 2:
                                            System.out.println("Doctor list: ");
                                            List<Doctor> doctorList = new ArrayList<Doctor>(doctorAccounts.values());
                                            for (int i = 0; i < doctorList.size(); i++) {
                                                System.out.println(doctorList.get(i));
                                            }
                                            break;

                                        case 3:
                                            Doctor d1 = UserInputManager.getDoctor(doctorAccounts);
                                            doctorAccounts.values().removeIf(r -> r.equals(d1));
                                            break;

                                        case 4:
                                            Patient q = UserInputManager.getPatient(patientAccounts);
                                            patientAccounts.values().removeIf(r -> r.equals(q));
                                            break;

                                        case 5:
                                            System.out.println("Waiting list sorted by urgency level: ");
                                            OrganRecipient.waitingListSort(waitingList);
                                            break;

                                        default:
                                            System.out.println("Invalid input. Try again.");
                                    }
                            }
                            if (!adminKey.equals("43Clinicapp")) {
                                System.out.println("Invalid key!");
                            }
                            break;

                        case 4:
                            break;

                        default:
                            System.out.println("Invalid input. Try again.");
                    }
                    break;

                case 2:
                    int creationType = uim.retrieveCreationType();
                    switch (creationType) {
                        case 1:
                            Patient p = uim.retrievePatientInfo();
                            System.out.println("Please enter a password to access your account: ");
                            String pPassword = scannerMain.nextLine();
                            MedicalDoc.createMedicalDocument(p);
                            patientAccounts.put(pPassword, p);
                            System.out.println("Patient added!");
                            break;

                        case 2:
                            Doctor d = uim.retrieveDoctorInfo();
                            System.out.println("Please enter a password to access your account: ");
                            String dPassword = scannerMain.nextLine();
                            doctorAccounts.put(dPassword, d);
                            System.out.println("Doctor added!");
                            break;

                        case 3:
                            break;

                        default:
                            System.out.println("Invalid input. Try again.");
                    }

            }

        }
    }


}
