package fr.ippon.mill.farmer.domain;

import fr.ippon.mill.error.domain.Assert;

import java.util.UUID;

public class Farmer {

    private UUID reference;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;

    public static Farmer create(String firstName, String lastName, String email, String phoneNumber) {
        return new Farmer(UUID.randomUUID(), firstName, lastName, email, phoneNumber);
    }

    public Farmer(UUID reference, String firstName, String lastName, String email, String phoneNumber) {
        Assert.assertNotNull("reference",reference);
        Assert.assertNotBlank("firstName",firstName);
        Assert.assertNotBlank("lastName",lastName);
        Assert.assertNotBlank("email",email);
        Assert.assertNotBlank("phoneNumber",phoneNumber);
        this.reference = reference;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UUID getReference() {
        return reference;
    }

    public void setReference(UUID reference) {
        this.reference = reference;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
