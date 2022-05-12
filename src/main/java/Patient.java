

import java.time.LocalDate;
import java.util.ArrayList;

public class Patient extends User implements iUser{
    private ArrayList<String> currentMeds;
    private ArrayList<String> diagnoses;
    private int height;
    private int weight;
    private String phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
    private String gender;
    public static int patientNumber = 0;
    public int patNo;

    public Patient(String firstName, String lastName, int height, int weight, String phoneNumber, String address, LocalDate dateOfBirth, String gender) {
        super("Patient");
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.currentMeds = new ArrayList<String>();
        this.diagnoses = new ArrayList<String>();
        this.height = height;
        this.weight = weight;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        patientNumber ++;
        this.patNo = patientNumber;
    }

    public ArrayList<String> getCurrentMeds() {
        return currentMeds;
    }

    public void setCurrentMeds(ArrayList<String> currentMeds) {
        this.currentMeds = currentMeds;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ArrayList<String> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(ArrayList<String> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Patient" + "[" + patNo + "] " + firstName + " " + lastName;
    }
}
