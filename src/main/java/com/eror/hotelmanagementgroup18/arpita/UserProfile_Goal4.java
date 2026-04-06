package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;

public class UserProfile_Goal4 implements Serializable {

    private int userID;
    private String fullName;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String role;
    private String gender;
    private String preference;
    private String status;

    public UserProfile_Goal4(int userID, String fullName, String userName,
                              String password, String email, String phone,
                              String role, String gender, String preference,
                              String status) {
        this.userID = userID;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.gender = gender;
        this.preference = preference;
        this.status = status;
    }

    // Getters
    public int getUserID() { return userID; }
    public String getFullName() { return fullName; }
    public String getUserName() { return userName; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getRole() { return role; }
    public String getGender() { return gender; }
    public String getPreference() { return preference; }
    public String getStatus() { return status; }

    // Setters (for updating)
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setPassword(String password) { this.password = password; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setRole(String role) { this.role = role; }
    public void setGender(String gender) { this.gender = gender; }
    public void setPreference(String preference) { this.preference = preference; }
    public void setStatus(String status) { this.status = status; }
}
