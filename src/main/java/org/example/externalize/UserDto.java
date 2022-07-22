package org.example.externalize;

import lombok.Data;

import java.io.*;
import java.time.LocalDate;

@Data
public class UserDto implements Externalizable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String surName;
    private LocalDate dob;
    private CountryEnum country;

    public UserDto(String name, String surName, LocalDate dob, CountryEnum country) {
        this.name = name;
        this.surName = surName;
        this.dob = dob;
        this.country = country;
    }

    public UserDto() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(name);
        out.writeObject(surName);
        out.writeObject(dob);
        out.writeObject(country);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        name = (String) in.readObject();
        surName = (String) in.readObject();
        dob = (LocalDate) in.readObject();
        country = (CountryEnum) in.readObject();
    }
}
