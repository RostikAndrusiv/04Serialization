package org.example.externalize;

import java.io.Serializable;

public class BankCardDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String number;
    private UserDto userDto;

    public BankCardDto(String number, UserDto userDto) {
        this.number = number;
        this.userDto = userDto;
    }

    public BankCardDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UserDto getUser() {
        return userDto;
    }

    public void setUser(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String toString() {
        return "BankCardDto{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", userDto=" + userDto +
                '}';
    }
}
