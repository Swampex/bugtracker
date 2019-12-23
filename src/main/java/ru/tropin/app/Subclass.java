package ru.tropin.app;
class Superclass {
    int age;

    Superclass() {
        System.out.println("Default constructor of Superclass");
    }

    Superclass(int x) {
        System.out.println("Constructor of a parent: x="+x);
    }

    public void getAge() {
        System.out.println("The value of the variable named age in super class is: " +age);
    }
}

public class Subclass extends Superclass {

    Subclass() {
        super();

    }

    public static void main(String argd[]) {
        Subclass s = new Subclass();
        s.getAge();
    }
}
