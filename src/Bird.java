public class Bird extends Animal {
    private boolean canFly;

    // Constructor
    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    // Getter & Setter
    public boolean getCanFly() { return canFly; }
    public void setCanFly(boolean canFly) { this.canFly = canFly; }

    // Method Overriding
    @Override
    public String makeSound() {
        return "The bird chirps.";
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Can Fly: " + canFly;
    }
}
