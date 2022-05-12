
import java.time.LocalDate;
import java.util.*;

public class PatientAppoint {
    
    private int startHour;
    private int endHour;
    private LocalDate localdate;
    private String reason;
    final static int OPENING_HOUR = 9;
    final static int CLOSING_HOUR = 17;
    private Doctor preferredDoctor;
    private boolean available = true;
    

    public PatientAppoint(LocalDate ld, String reason, Doctor preferredDoctor, int SH, int EH) {
        this.startHour = SH;
        this.endHour = EH;
        this.localdate = ld;
        this.reason = reason;
        this.preferredDoctor = preferredDoctor;
    }
    
    @Override
    public String toString(){
        return "\\Date: " + localdate + "\\Time: " + startHour + "-" + endHour + "\\Reason: " + reason;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public LocalDate getLocaldate() {
        return localdate;
    }

    public void setLocaldate(LocalDate localdate) {
        this.localdate = localdate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Doctor getPreferredDoctor() {
        return preferredDoctor;
    }

    public void setPreferredDoctor(Doctor preferredDoctor) {
        this.preferredDoctor = preferredDoctor;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

