public class Car {
    private String title;
    private Person owner;
    private double distanceCounter = 0.0;
    private int gasolineConsumption = 8;
    private double gasolineTank = 50;
    private int topSpeed;

    public Car(String title, Person owner, int topSpeed){
        this.title = title;
        this.owner = owner;
        this.topSpeed = topSpeed;
    }

    public void move(int speed, int duration){
        if ( speed > this.topSpeed){
            speed = this.topSpeed;
            System.out.println("Warnung: maximale Geschwindigkeit = " + this.topSpeed);
        }
        double distance = speed *(duration/60.0);
        double remainingRange = this.gasolineTank/this.gasolineConsumption * 100;
        if (distance > remainingRange){
            distance = remainingRange;
            System.out.println("Warnung: Benzin leer nach "  + distance + " km!");
        }
        this.gasolineTank -= distance/100.0 * this.gasolineConsumption; 
        this.distanceCounter += distance;
    }

    public void refuel(int liters){
        if((this.gasolineTank + liters) >50){
            liters = 50 - (int)this.gasolineTank;
            System.out.println("Warnung: maximal können " + liters + " Liter getankt werden!");
        }
        this.gasolineTank += liters;
    }

    @Override
    public String toString(){
        return("Das ist ein Objekt von Typ Car mit dem Titel " + this.title + " und dem Kilometerstand " + this.distanceCounter);
    }

}
