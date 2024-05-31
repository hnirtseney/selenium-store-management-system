package pos.form.usermanagement;

public class CreateUserForm {
    public String userName;
    public String userMail;
    public String userPassword;
    public String userConfirmPassword;
    public String userRole;
    public String userStatus;


    // Constructor
    public CreateUserForm(String userName, String userMail, String userPassword, String userConfirmPassword, String userRole, String userStatus) {
        this.userName = userName;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userConfirmPassword = userConfirmPassword;
        this.userRole = userRole;
        this.userStatus = userStatus;
    }
}
