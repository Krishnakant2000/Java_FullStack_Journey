package Week_1_Java_Foundation.Day_6_Encapsulation;

public class CarApp {
    static void main() {

        // 1. THE CONSTRUCTOR IN ACTION
        // We MUST pass "Ford" and "Red". We cannot create an empty car.
        Car myCar = new Car("Ford", "Red");

        // 2. READ data using Getters
        System.out.println("Created a " +  myCar.getBrand());

        // 3. MODIFY data using Methods
        myCar.accelerate(40);

        // 4. ATTEMPTING BAD DATA
        // This won't work because we didn't make a 'setSpeed' method
        // myCar.currentSpeed = -100; // <--- ERROR! The field is private.

        // Instead, we trust the class logic:
        myCar.brake(100); // Should stop at 0, not go negative

        System.out.println("Final speed check : " + myCar.getCurrentSpeed());

    }
}
