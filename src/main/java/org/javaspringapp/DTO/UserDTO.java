package org.javaspringapp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class UserDTO {
    @JsonProperty("fullname")
    private String fullName;
    @JsonProperty("phone_number")
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    private String address;
    @NotBlank(message = "Password cannot be empty")
    private String password;
    @JsonProperty("retype_password")
    private String retypePasword;
    @JsonProperty("date_of_birth")
    private Date dateOfBirth;
    @JsonProperty("facebook_account_id")
    private String facebookAccountId;
    @JsonProperty("google_account_id")
    private String googleAccountId;
    @JsonProperty("role_id")
    @NotNull(message = "Role ID is required")
    private Long roleId;

    public UserDTO() {
    }

    public UserDTO(String fullName, Long roleId, String googleAccountId, String facebookAccountId, String password, String retypePasword, String address, String phoneNumber, Date dateOfBirth) {
        this.fullName = fullName;
        this.roleId = roleId;
        this.googleAccountId = googleAccountId;
        this.facebookAccountId = facebookAccountId;
        this.password = password;
        this.retypePasword = retypePasword;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public @NotBlank(message = "Phone number is required") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotBlank(message = "Phone number is required") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public @NotBlank(message = "Password cannot be empty") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password cannot be empty") String password) {
        this.password = password;
    }

    public String getRetypePasword() {
        return retypePasword;
    }

    public void setRetypePasword(String retypePasword) {
        this.retypePasword = retypePasword;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFacebookAccountId() {
        return facebookAccountId;
    }

    public void setFacebookAccountId(String facebookAccountId) {
        this.facebookAccountId = facebookAccountId;
    }

    public String getGoogleAccountId() {
        return googleAccountId;
    }

    public void setGoogleAccountId(String googleAccountId) {
        this.googleAccountId = googleAccountId;
    }

    public @NotNull(message = "Role ID is required") Long getRoleId() {
        return roleId;
    }

    public void setRoleId(@NotNull(message = "Role ID is required") Long roleId) {
        this.roleId = roleId;
    }
}
