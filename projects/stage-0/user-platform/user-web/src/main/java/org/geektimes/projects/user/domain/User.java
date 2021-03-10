package org.geektimes.projects.user.domain;

import org.geektimes.projects.user.validator.bean.validation.group.UserGroup;
import org.geektimes.projects.user.validator.bean.validation.user.Phone;
import org.geektimes.projects.user.validator.bean.validation.user.Pwd;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * 用户领域对象
 *
 * @since 1.0
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
//    @GeneratedValue(strategy = AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull
    private Long id;

    @Column
    private String name;

    @Column
//    @Max(32)
//    @Min(6)
//    @Size(min = 6, max = 32, groups = UserGroup.Register.class)
    @Pwd(min = 6, max = 32, groups = UserGroup.Register.class)
    private String password;

    @Column
    @Email
    private String email;

    @Column
//    @Pattern(regexp = "^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$", groups = UserGroup.Register.class)
    @Phone(groups = UserGroup.Register.class)
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
