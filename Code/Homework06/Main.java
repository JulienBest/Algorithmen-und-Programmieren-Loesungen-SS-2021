
public class Main {

    public static void main(String[] args) {
        // Creating ListNode objects
        int element1 = 5;
        int element2 = 10;
        int element3 = 15;

        // Initializing the list
        List list = new List();

        // Adding a ListNode object to the end of the list
        list.append(element1);
        list.append(element2);
        list.append(element3);
        list.print();

        // Removing the desired (in this case the 2nd) element from the list
        System.out.println("läuft");
        list.end();
        list.prev();
        list.remove();
        System.out.println("läuft nicht mehr");
        list.print();

        list.removeAll();
        list.print();
        System.out.println("Läuft noch");
        // Filling the list with values from 0 to 20
        for (int i = 1; i <= 20; i++) {
            list.append(i);
        }

        // Printing the values in it
        list.print();

    }

}
