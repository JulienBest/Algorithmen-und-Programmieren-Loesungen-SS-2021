public class Person {
    private String name;
    private int age;
    private int height;

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public void sayHello() {
        System.out.println(this.name + " sagt Hallo!");
    }

    public void walk(double meters) {
        System.out.println(this.name + " läuft " + meters + "m");
    }

    @Override
    public String toString() {
        return "Eine Person mit dem Namen " + this.name + " und dem Alter: " + this.age + " und der Größe: " + this.height;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getHeight() {
        return this.height;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
