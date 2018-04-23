package com.ABCBank.BankingSystem.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class AccountDto {

    @NotNull
    private String accountType;

    @Min(10)
    @Max(10)
    private  String nic;

    @Min(8)
    @Max(30)
    private  String password;

    @Size(max=255)
    @NotNull
    private String firstName;

    @Size(max=255)
    @NotNull
    private  String lastName;

    @Size(max=255)
    @NotNull
    private  String address;

    @Size(max=255)
    @NotNull
    private String occupation;

    @Min(10)
    @Max(10)
    private String contactNumber;

    @NotNull
    private Date dateOfBirth;

    public AccountDto(@NotNull String accountType, @Min(10) @Max(10) String nic, @Min(8) @Max(30) String password, @Size(max = 255) @NotNull String firstName, @Size(max = 255) @NotNull String lastName, @Size(max = 255) @NotNull String address, @Size(max = 255) @NotNull String occupation, @Min(10) @Max(10) String contactNumber, @NotNull Date dateOfBirth) {
        this.accountType = accountType;
        this.nic = nic;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.occupation = occupation;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getNic() {
        return nic;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
