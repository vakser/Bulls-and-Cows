
class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        if (firstName != null && !"".equals(firstName)) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        // write your code here
        if (lastName != null && !"".equals(lastName)) {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        if (firstName != null && !"".equals(firstName) && lastName != null && !"".equals(lastName)) {
            return firstName + " " + lastName;
        } else if (firstName == null || "".equals(firstName) && lastName != null && !"".equals(lastName)) {
            return lastName;
        } else if (lastName == null || "".equals(lastName) && firstName != null && !"".equals(firstName)) {
            return firstName;
        } else {
            return "Unknown";
        }
    }
}