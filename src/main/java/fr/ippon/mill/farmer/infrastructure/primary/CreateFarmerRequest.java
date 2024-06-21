package fr.ippon.mill.farmer.infrastructure.primary;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * CreateFarmerRequest
 */
public class CreateFarmerRequest {
  @JsonProperty("firstName")
  @NotNull
  @NotBlank
  private String firstName;

  @NotNull
  @NotBlank
  @JsonProperty("lastName")
  private String lastName;

  @NotNull
  @NotBlank
  @Email
  @JsonProperty("email")
  private String email;

  @NotNull
  @NotBlank
  @JsonProperty("phoneNumber")
  private String phoneNumber;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}

