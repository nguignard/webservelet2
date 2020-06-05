package com.myapp.model;

public class User {

    public User(String firstName, String name, int salary) {
	this.firstName = firstName;
	this.lastName = name;
	this.salary = salary;
    }

    public String firstName;
    public String lastName;
    public int salary;

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

    public int getSalary() {
	return salary;
    }

    public void setSalary(int salary) {
	this.salary = salary;
    }

    @Override
    public String toString() {
	return "User [firstName=" + firstName + ", name=" + lastName + ", salary=" + salary + "]";
    }
}
