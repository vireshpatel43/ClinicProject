import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class OrganRecipient{
    private int urgencyLevel;
    private String organType;
    private Patient p1;

    public OrganRecipient(Patient p1, int urgencyLevel, String organType) {
        this.urgencyLevel = urgencyLevel;
        this.organType = organType;
        this.p1 = p1;
    }

    public int compare(OrganRecipient or1, OrganRecipient or2) {
        return or1.urgencyLevel - or2.urgencyLevel;
    }

    public static void waitingListSort (ArrayList<OrganRecipient> waitingList) {
        Collections.sort(waitingList, new SortByUrgencyLevel());
        for (int i = 0; i < waitingList.size(); i++) {
            System.out.println(waitingList.get(i));
        }
    }

    @Override
    public String toString() {
        return p1.toString() + ", Organ Type: " + organType + ", Urgency level: " + urgencyLevel;

    }

    public int getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(int urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getOrganType() {
        return organType;
    }

    public void setOrganType(String organType) {
        this.organType = organType;
    }

    public Patient getP1() {
        return p1;
    }

    public void setP1(Patient p1) {
        this.p1 = p1;
    }
}
