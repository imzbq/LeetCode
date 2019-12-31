package test.ref;

public class Person extends SuperPerson{
    private String name;
    private Integer age;
    public Person(){}
    public Person(String name, Integer age){
        this.age = age;
        this.name = name;
    }
    public void sayHello(){
        System.out.println("你好");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
