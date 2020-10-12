import java.sql.Timestamp;

enum Status {
    ACTIVE ("Active"),
    INACTIVE("Inactive"),
    BLOCKED("Blocked"),
    NEW("New");
    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return status;
    }
}

public class User {
    private String firstname;
    private String lastname;
    private int age;
    private Status status;
    private String email;
    private final Timestamp timestamp;

    public User(String firstname, String lastname, int age, Status status, String email, Timestamp timestamp) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.status = status;
        this.email = email;
        this.timestamp = timestamp;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString(){
        return String.format("%15s | %15s | %3d | %20s | %10s | %15s",
                firstname, lastname, age, email, status, timestamp);
    }
}
