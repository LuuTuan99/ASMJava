package entity;


import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String fullname;
    private String username;
    private  String password;

    public HashMap<String, ArrayList<String>> getErrors() {
        return this.errors;
    }

    public void setErrors(HashMap<String, ArrayList<String>> errors) {
        this.errors = errors;
    }

    private HashMap<String, ArrayList<String>> errors;


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public User(String fullname, String username, String password) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
    }

    public User() {
    }


    public boolean isValid() {
        validate();
        return this.errors.size() == 0;
    }

    private void validate() {
        if (this.errors == null){
            this.errors = new HashMap();
        }
        ArrayList<String> userNameError  =this.errors.get("username");

        if (userNameError == null){
            userNameError = new ArrayList<>();
        }
        if (this.username == null || this.username.length() ==0){
            userNameError.add("*Username is required");
        }if (this.username.length()<2 || this.username.length()>30){
            userNameError.add("*Username must be between 2 and 30 chacracters!");
        }if (userNameError.size()>0){
            this.errors.put("username", userNameError);
        }
        ArrayList<String> fullNameError  =this.errors.get("fullname");
        if (fullNameError == null){
            fullNameError = new ArrayList<>();
        }if (this.fullname == null || this.username.length() == 0){
            fullNameError.add("*FullName is required");
        }if (this.fullname.length()<1 || this.fullname.length()>50) {
            fullNameError.add("*FullName must be between 1 and 50 chacracters");
        }if (fullNameError.size()>0){
            this.errors.put("fullname",fullNameError);
        }
        ArrayList<String> passWordError = this.errors.get("password");
        if (passWordError == null){
            passWordError = new ArrayList<>();
        }if (this.password == null || this.password.length()<5){
            passWordError.add("*Password is required and Password is bigger 5 chacracters");
        }if (passWordError.size()>0){
            this.errors.put("password",passWordError);
        }
    }

}


