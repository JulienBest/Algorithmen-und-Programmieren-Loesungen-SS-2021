public class Homework_03 {
    public static void main(String[] args) {
        
        Person peter = new Person("Peter", 30, 170);
        peter.sayHello();
        peter.walk(5.2);

        String peterString = peter.toString();
        System.out.println(peterString);
        System.out.println(peter); //toString() is internally called
        int age = peter.getAge();
        System.out.println(age);
        
        Dog bruno = new Dog("Bruno","black", 5, peter);
        bruno.sit();
        System.out.println(bruno);
        

        Car vw = new Car("VW", peter, 180);
        vw.move(190,60);

        System.out.println(vw);

        
    }
}
