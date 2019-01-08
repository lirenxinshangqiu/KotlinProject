package test;

import com.example.main.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person();
        Class personClass = person.getClass();
        Class<Person> personClass1 = Person.class;
        try {
            Class<?> personClass2 = Class.forName("com.example.main.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String name1 = personClass.getName();
        Field[] fields1 = personClass.getFields();
        Field[] declaredFields = personClass.getDeclaredFields();
        Method[] methods = personClass.getMethods();
        Method[] declaredMethods = personClass.getDeclaredMethods();
        printFields(name1,fields1,declaredFields,methods,declaredMethods);
    }

    private static void printFields(String name1, Field[] fields1, Field[] declaredFields,Method[] methods,Method[] declaredMethods ) {
        System.out.println("name:"+name1);
        System.out.println("fields");
        for (Field field : fields1) {
            System.out.println(field.getName());
        }
        System.out.println("declaredFields");
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        System.out.println("methods");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("declaredMethods");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }

    }
}
