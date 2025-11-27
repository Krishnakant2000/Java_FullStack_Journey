package Week_1_Java_Foundation.Day_6_Encapsulation;

public class Car {

    // 1. ENCAPSULATION: Data is 'private'
    // No one outside this file can touch these directly.
    private String brand;
    private String color;
    private int currentSpeed;

    // 2. CONSTRUCTOR
    // This runs automatically when you say "new Car()".
    // We force the user to provide brand and color immediately.
    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
        this.currentSpeed = 0;// Default start speed
    }

    // 3. GETTERS (Read-Only access)
    public String getBrand() {
        return brand;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    // 4. LOGIC METHODS (Replacing direct Setters for speed)
    public void accelerate(int increase) {
        if (increase > 0) {
            this.currentSpeed += increase;
            System.out.println(this.brand + " speed increased to " + this.currentSpeed);
        } else {
            System.out.println("Invalid acceleration amount.");
        }
    }

    public void brake(int decrease) {
        this.currentSpeed -= decrease;
        if (this.currentSpeed < 0) {
            this.currentSpeed = 0;
        }
        System.out.println(this.brand + " slowed to " + this.currentSpeed);
    }

}
