package me.estrela.java2020.records;

record Car(int doors, String color) {
    Car {
        if (doors > 5 || color == null || color.isBlank()) { //String::isBlank added in J11
            throw new IllegalStateException("Invalid car");
        }
    }
}

public class Vehicle {

    public static void main(String[] args) {
        Car car1 = new Car(5, "blue");
        Car car2 = new Car(5, "blue");
        Car car3 = new Car(3, "red");
        System.out.println(car1.color());
        System.out.println(car3.doors());
        System.out.println(car1.equals(car2));
        try {
            new Car(6, "");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

}
