package test;

import com.example.main.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
        Field[] fields1 = personClass.getFields();//获取public 属性
        Field[] declaredFields = personClass.getDeclaredFields();//获取声明的属性
        Method[] methods = personClass.getMethods();//获得类中public类型的方法
        Method[] declaredMethods = personClass.getDeclaredMethods();//获取类中的所有方法，包括private声明的和继承的
        Constructor[] constructors = personClass.getConstructors();
        getConsturctor(personClass);
        printFields(name1,fields1,declaredFields,methods,declaredMethods,constructors);
        try {
            Person person1 = personClass1.newInstance();
            System.out.println(person1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Person person1 = (Person) personClass.newInstance();
            Method setAge = personClass.getMethod("setAge", int.class);
            setAge.setAccessible(true);
            setAge.invoke(person1,5);//调用类中的方法
            Field age = personClass.getDeclaredField("age");
            age.setAccessible(true);
//            age.set(person1,20);
            System.out.println("age-----------");
            System.out.println(age);
            System.out.println(age.get(person1));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private static void getConsturctor(Class personClass) {
        System.out.println("constructor-name-------------");
        try {
            Constructor constructor = personClass.getConstructor();
            Constructor constructor1 = personClass.getConstructor(String.class, int.class, String.class);
            if (constructor!=null){
                System.out.println(constructor.getName());
            }
            if (constructor1 != null) {
                System.out.println(constructor1.getName());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void printFields(String name1, Field[] fields1, Field[] declaredFields,Method[] methods,Method[] declaredMethods,Constructor[] constructors ) {
        System.out.println("name:"+name1);
        System.out.println("fields---------------");
        for (Field field : fields1) {
            System.out.println(field.getName());
        }
        System.out.println("declaredFields-----------------");
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        System.out.println("methods---------------");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("declaredMethods----------------");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }

        System.out.println("constructor---------------------");
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }

    }
}
