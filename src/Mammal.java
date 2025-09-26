public class Mammal extends Animal {
    private String furColor;

    // Constructor
    public Mammal(String name, int age, String furColor) {
        super(name, age); // call Animal constructor
        this.furColor = furColor;
    }

    // Getter & Setter
    public String getFurColor() { return furColor; }
    public void setFurColor(String furColor) { this.furColor = furColor; }

    // Method Overriding
    @Override
    public String makeSound() {
        return "The mammal makes a sound.";
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Fur Color: " + furColor;
    }
}
