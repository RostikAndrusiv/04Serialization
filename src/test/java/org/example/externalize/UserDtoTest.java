package org.example.externalize;

import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class UserDtoTest {

    @Test
    public void whenCustomSerializingAndDeserializing_ThenObjectIsTheSame()
            throws IOException, ClassNotFoundException {

        var user = new UserDto("Homer", "Simpson", LocalDate.parse("1956-04-12"), CountryEnum.Ukraine);
        user.setId(15);
        var card = new BankCardDto("123456789", user);

        FileOutputStream fileOutputStream
                = new FileOutputStream("myfile.txt");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(card);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream("myfile.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        var cardDeserialized = (BankCardDto) objectInputStream.readObject();
        objectInputStream.close();

        assertEquals(cardDeserialized.getUser().getDob(), card.getUser().getDob());
        assertEquals(cardDeserialized.getNumber(), cardDeserialized.getNumber());
        assertEquals(15, cardDeserialized.getUser().getId());
        assertEquals(CountryEnum.Ukraine, cardDeserialized.getUser().getCountry());
    }
}