package org.javaspringapp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class OrderDTO {
    @Min(value = 1, message = "User's ID must be > 0")
    @JsonProperty("user_id")
    private Long userID;

    @JsonProperty("fullname")
    private String fullName;

    private String email;

    @JsonProperty("phone_number")
    @Size(min = 5, message = "phone number must be at least 5 characters")
    private String phoneNumber;

    private String address;

    private String note;

    @JsonProperty("total_money")
    @Min(value = 0, message = "Total money must be >= 0")
    private Float totalMoney;

    @JsonProperty("shipping_method")
    private String shippingMethod;

    @JsonProperty("shipping_address")
    private String shippingAddress;

    @JsonProperty("payment_method")
    private String paymentMethod;

    public OrderDTO() {
    }

    public OrderDTO(String fullName, String email, Long userID, String phoneNumber, String address, String note, Float totalMoney, String shippingMethod, String shippingAddress, String paymentMethod) {
        this.fullName = fullName;
        this.email = email;
        this.userID = userID;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.note = note;
        this.totalMoney = totalMoney;
        this.shippingMethod = shippingMethod;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
    }

    public @Min(value = 1, message = "User's ID must be > 0") Long getUserID() {
        return userID;
    }

    public void setUserID(@Min(value = 1, message = "User's ID must be > 0") Long userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public @Size(min = 5, message = "phone number must be at least 5 characters") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public @Min(value = 0, message = "Total money must be >= 0") Float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(@Min(value = 0, message = "Total money must be >= 0") Float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
