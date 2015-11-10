package gsonexample;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DeserializeToJavaObjectTest {

    public static final Logger LOGGER = Logger.getLogger(DeserializeToJavaObjectTest.class.getSimpleName());
    final String jsonString = "{id:1,name: \"john\"}";

    public static class Person{
        int id;
        String name;

        boolean calledMyConstructor = false;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;

            calledMyConstructor = true;
            LOGGER.info("Person.constructor was called.");
        }
    }

    @Test
    public void test_constructor() {
        Person cathy = new Person(1, "Cathy");
        assertThat(cathy.calledMyConstructor, is(true));
    }

    @Test
    public void test_gsonDeserialize() {
        Gson gson = new Gson();
        Person deserializedJohn = gson.fromJson(jsonString, Person.class);
        assertThat(deserializedJohn.calledMyConstructor, is(false));
    }

    @Test
    public void test_allocateInstanceWithOutConstructor() {
        try {
            Person person = DeserializeToJavaObject.allocateInstanceWithOutConstructor(Person.class);
            Objects.requireNonNull(person);
            assertThat(person.calledMyConstructor, is(false));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
