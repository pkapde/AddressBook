package com.bridgelabz.addressbook;

public class Contact {
       private String firstName;
       private String lastName;
       private String phone;
       private String city;
       private String state;
       private String email;
       private String zip;
       private String address;


       public String getCity() {
              return city;
       }

       public void setCity(String city) {
              this.city = city;
       }

       public String getState() {
              return state;
       }

       public void setState(String state) {
              this.state = state;
       }

       public String getEmail() {
              return email;
       }

       public void setEmail(String email) {
              this.email = email;
       }

       public String getZip() {
              return zip;
       }

       public void setZip(String zip) {
              this.zip = zip;
       }

       public String getAddress() {
              return address;
       }

       public void setAddress(String address) {
              this.address = address;
       }



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

       public String getPhone() {
              return phone;
       }

       public void setPhone(String phone) {
              this.phone = phone;
       }

       public Contact(String firstName, String lastName, String phone, String city, String state, String email, String zip, String address) {
              this.firstName = firstName;
              this.lastName = lastName;
              this.phone = phone;
              this.city = city;
              this.state = state;
              this.email = email;
              this.zip = zip;
              this.address = address;
       }

       @Override
       public String toString() {
              return "Contact{" +
                      "firstName='" + firstName + '\'' +
                      ", lastName='" + lastName + '\'' +
                      ", phone='" + phone + '\'' +
                      ", city='" + city + '\'' +
                      ", state='" + state + '\'' +
                      ", email='" + email + '\'' +
                      ", zip='" + zip + '\'' +
                      ", address='" + address + '\'' +
                      '}';
       }
}