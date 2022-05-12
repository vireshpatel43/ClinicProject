import java.time.LocalDate;
import java.util.Date;

public class User {

    protected String type;
    protected String password;
    protected String username;
    protected String firstName;
    protected String lastName;

    public User(String type) {
        this.type = type;
        this.password = password;
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
