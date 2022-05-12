import java.util.Comparator;

public class SortByUrgencyLevel implements Comparator<OrganRecipient> {
    public int compare(OrganRecipient or1, OrganRecipient or2) {
        if (or1.getUrgencyLevel() > or2.getUrgencyLevel()) {
            return -1;
        }
        else
            return 1;
    }
}
