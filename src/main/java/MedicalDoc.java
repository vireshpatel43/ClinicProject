
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicalDoc {

    private static ArrayList<FileOutputStream> systemFileDatabase = new ArrayList<FileOutputStream>();
    private static String firstName;
    private static String lastName;
    private static String phoneNumber;
    private static String address;
    private static String gender;
    private static String birthday;
    private static String height;
    private static String weight;

    public static void WriteMDoc(String FileName) {
        try {
            FileWriter fout = new FileWriter(FileName);
            BufferedReader fread = new BufferedReader(new FileReader(FileName));
            BufferedWriter buff = new BufferedWriter(fout);
            buff.write("||Vanier Clinic Medical Document||");
            buff.newLine();
            buff.newLine();
            buff.newLine();
            buff.write("First Name");
            buff.newLine();
            buff.write(firstName);
            buff.newLine();
            buff.newLine();
            buff.write("Last Name");
            buff.newLine();
            buff.write(lastName);
            buff.newLine();
            buff.newLine();
            buff.write("Phone number");
            buff.newLine();
            buff.write(phoneNumber);
            buff.newLine();
            buff.newLine();
            buff.write("Address");
            buff.newLine();
            buff.write(address);
            buff.newLine();
            buff.newLine();
            buff.write("Date of birth");
            buff.newLine();
            buff.write(birthday);
            buff.newLine();
            buff.newLine();
            buff.write("Height (cm)");
            buff.newLine();
            buff.write(height);
            buff.newLine();
            buff.newLine();
            buff.write("Weight (kg)");
            buff.newLine();
            buff.write(weight);
            buff.newLine();
            buff.newLine();
            buff.write("Gender");
            buff.newLine();
            buff.write(gender);
            buff.newLine();
            buff.newLine();
            buff.newLine();
            buff.newLine();
            buff.newLine();
            buff.newLine();
            buff.newLine();
            buff.newLine();
            buff.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException ex) {
            Logger.getLogger(MedicalDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        public static void createMedicalDocument(Patient p){
        try {
            MedicalDoc md = new MedicalDoc();
            String FileName = "D:\\Patient" + p.patNo + ".txt";
            FileOutputStream fout = new FileOutputStream(FileName);
            systemFileDatabase.add(fout);

            File file = new File(FileName);
            BufferedReader br = new BufferedReader(new FileReader(FileName));
            Desktop desktop = Desktop.getDesktop();

            System.out.println("");
            firstName = p.getFirstName();
            lastName = p.getLastName();
            phoneNumber = String.valueOf(p.getPhoneNumber());
            address = p.getAddress();
            birthday = String.valueOf(p.getDateOfBirth());
            height = Integer.toString(p.getHeight());
            weight = Integer.toString(p.getWeight());
            gender = String.valueOf(p.getGender());

            md.WriteMDoc(FileName);
            desktop.open(file);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MedicalDoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MedicalDoc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
