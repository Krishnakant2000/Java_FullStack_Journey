package Week_1_Java_Foundation.Day_5_OOP_Basics;

public class Car {

    String brand;
    String color;
    int currentSpeed;

    void accelerate(int increaseSpeed) {
        currentSpeed += increaseSpeed;
        System.out.println(brand + " is accelerating. Speed: " + currentSpeed + " km/h");
    }

    void brake(int decreaseSpeed) {
        currentSpeed -= decreaseSpeed;
        if (currentSpeed < 0) {
            currentSpeed = 0; // Physics check: Speed can't be negative
        }
        System.out.println(brand + " is braking. Speed: " + currentSpeed + " km/h");
    }

    void showData() {
        System.out.println("=== Car Details ===");
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
        System.out.println("Current Speed: " + currentSpeed);
    }

}
