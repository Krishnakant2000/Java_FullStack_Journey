package Week_1.Day_5_OOP_Basics;

public class CarApp {
    static void main() {

        Car myCar = new Car();
        myCar.brand = "BMW";
        myCar.color = "Red";
        myCar.currentSpeed = 50;

        System.out.println("--- Testing BMW ---");
        myCar.showData();
        myCar.accelerate(50);   // Speed becomes 50
        myCar.accelerate(30);   // Speed becomes 80
        myCar.brake(20);        // Speed becomes 60


        Car yourCar = new Car();
        yourCar.brand = "Tesla Truck";
        yourCar.color = "Silver";
        yourCar.currentSpeed = 0;

        System.out.println("--- Testing Tesla Truck ---");
        yourCar.accelerate(100);

    }
}
