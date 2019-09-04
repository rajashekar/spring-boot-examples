package com.example.springbootvalidation.model;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class User {
    @NotBlank(message = "username cannot be empty")
    private String name;
    @NotBlank(message = "password cannot be empty")
    @Length(min = 6, max = 10, message = "Length of password should be between 6 and 10 characters")
    private String password;
    @Min(value = 0)
    @Max(value = 100)
    private Double grade;
    @Email
    private String email;

    public User() {
    }

    public User(String name, String password, Double grade, String email) {
        this.name = name;
        this.password = password;
        this.grade = grade;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getGrade() {
        return this.grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public User grade(Double grade) {
        this.grade = grade;
        return this;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password)
                && Objects.equals(grade, user.grade) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, grade, email);
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", password='" + getPassword() + "'" + ", grade='" + getGrade() + "'"
                + ", email='" + getEmail() + "'" + "}";
    }

}