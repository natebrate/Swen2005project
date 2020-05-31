public class User {
    private int ID;
    private String fullName;
    private String firstName;
    private String lastName;
    private String username;
    private boolean isAdmin;

    User(int ID, String firstName, String lastName, String username, Boolean isAdmin)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.username = username;
        this.isAdmin = isAdmin;
    }
    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }
}

