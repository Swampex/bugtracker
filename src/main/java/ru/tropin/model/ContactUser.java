package ru.tropin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.tropin.form.ProfileForm;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "firstName", column = @Column(name = "user_firstName")),
        @AttributeOverride(name = "lastName", column = @Column(name = "user_lastName")),
        @AttributeOverride(name = "phoneNumber", column = @Column(name = "user_phoneNumber"))
})
public class ContactUser {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public ContactUser(ProfileForm form) {
        this.firstName = form.getFirstName();
        this.lastName = form.getLastName();
        this.phoneNumber = form.getPhoneNumber();
    }
}
