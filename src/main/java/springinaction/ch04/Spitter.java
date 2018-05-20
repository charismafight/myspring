package springinaction.ch04;

public class Spitter implements Cloneable {
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public String getFirstName() {
        return firstName;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Object clone() {
        Spitter result = new Spitter();
        result.setId(getId());
        result.setFirstName(getFirstName());
        result.setLastName(getLastName());
        result.setUsername(getUsername());
        result.setPassword(getPassword());
        return result;
    }
}
