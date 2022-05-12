
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calendar {

    private ArrayList<PatientAppoint> CalendarSystem = new ArrayList<PatientAppoint>();
    private static String month;
    
    public Calendar() {
        
    }

    
    public void DisplayDoctorCalendar(Doctor d, List<PatientAppoint> cal){ //displays all appointments for a specific doctor
        List doctorAppointment = cal.stream().filter(x -> (x.getPreferredDoctor().getFirstName().equals(d.getFirstName()))
                                && (x.getPreferredDoctor().getLastName().equals(d.getLastName()))).collect(Collectors.toList());
        System.out.println(doctorAppointment);
    }    

    public static String getMonth() {
        return month;
    }

    public static void setMonth(String m) {
        month = m;
    }

    public ArrayList<PatientAppoint> getCalendarSystem() {
        return CalendarSystem;
    }

    public void setCalendarSystem(ArrayList<PatientAppoint> CalendarSystem) {
        this.CalendarSystem = CalendarSystem;
    }
    
    
    

}
