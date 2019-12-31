package test.ref;

import test.ref.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class Refperson {
    public static void main(String[] args) throws Exception{
        Class<?> clzz = Class.forName("test.ref.Person");
        Object o = clzz.newInstance();
        Method method = clzz.getMethod("sayHello");
        method.invoke(o);

        Constructor<?> con = clzz.getDeclaredConstructor(String.class, Integer.class);
        Object zbq = con.newInstance("周葆全", 18);
        System.out.println(zbq);
    }
}
