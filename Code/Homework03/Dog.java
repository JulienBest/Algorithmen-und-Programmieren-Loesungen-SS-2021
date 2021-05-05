public class Dog {
    private String name;
    private String color;
    private int age;
    private Person owner;

    public Dog(String name, String color, int age, Person owner) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.owner = owner;
    }

    public void bark() {
        System.out.println(this.name + " bellt!");
    }

    public void sit() {
        System.out.println(this.name + " sitzt!");
    }

    @Override
    public String toString() {
        return "Ein Hund mit dem Namen " + this.name + ", der Farbe " + this.color + ", des Alters " + this.age + "und dem Besitzer " + this.owner;
    }
}
