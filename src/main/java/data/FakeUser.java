package data;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FakeUser {
    private static final Faker faker = new Faker();

    public static String getFirstName(){
        return faker.name().firstName();
    }

    public static String getLastName(){
        return faker.name().lastName();
    }

    public static String getBirthDate(){
        Date birthDate = faker.date().birthday();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(birthDate);
    }
}
