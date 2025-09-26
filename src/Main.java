public class Main {
    public static void main(String[] args) {
        // Create animals
        Mammal lion = new Mammal("Leo", 5, "Golden");
        Bird parrot = new Bird("Polly", 2, true);

        // Show info
        System.out.println(lion.getInfo());
        System.out.println(lion.makeSound());

        System.out.println(parrot.getInfo());
        System.out.println(parrot.makeSound());
    }
}
