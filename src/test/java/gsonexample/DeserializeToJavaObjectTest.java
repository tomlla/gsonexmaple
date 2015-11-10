package gsonexample;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import com.google.gson.*;

public class DeserializeToJavaObjectTest {
    
    final String jsonString = "{id:1,name: \"john\"}";
    
    public static class Person {
        int id;
        String name;
        
        boolean calledMyConstructor = false;
        
        public Person(final int id, final String name) {
            this.id = id;
            this.name = name;
            
            calledMyConstructor = true;
            System.out.println("Person.constructor was called."
                    + String.format(" [id:%s name:%s]", id, name));
        }
    }
    
    @Test
    public void test_constructor() {
        final Person cathy = new Person(1, "Cathy");
        assertThat(cathy.calledMyConstructor, is(true));
    }
    
    @Test
    public void test_gsonDeserialize() {
        final Gson gson = new Gson();
        final Person deserializedJohn = gson.fromJson(jsonString, Person.class);
        assertThat(deserializedJohn.calledMyConstructor, is(false));
    }
    
    @Test
    public void test_allocateInstanceWithOutConstructor() {
        try {
            final Person person = DeserializeToJavaObject.allocateInstanceWithOutConstructor(Person.class);
            Objects.requireNonNull(person);
            assertThat(person.calledMyConstructor, is(false));
            
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }
    
}
