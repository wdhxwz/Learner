package com.wangdh.learner.redis.Spring.data;

/**
 * @author wangdh
 * @Description
 * @date 2017-12-22
 */
public class Person {
    private String firstname;
    private String lastname;
    private Address address;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "firstName=" + this.firstname + ",lastName=" + this.lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
