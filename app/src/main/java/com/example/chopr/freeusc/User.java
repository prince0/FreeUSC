package com.example.chopr.freeusc;

import com.google.gson.annotations.SerializedName;

/**
 * This is a POJO class for user
 * Created by Prince on 1/10/2018.
 */

class User {

    @SerializedName("email")
    String email;
    @SerializedName("first_name")
    String first_name;
    @SerializedName("last_name")
    String last_name;
    @SerializedName("gender")
    String gender;

    User(String firstName, String lastName, String email, String gender){
        this.first_name = firstName;
        this.last_name = lastName;
        this.email = email;
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
