import java.lang.StringBuilder;

public class Todo {
    String title;
    String description;

    int month;
    int day;
    int year;
    int daysLeft;       // Days left until the todo needs to be completed

    // Constructor
    Todo(){
        this.title = "none";
        this.description = "none";

        this.month = 0;
        this.day = 0;
        this.year = 0;
        this.daysLeft = 0;
    }

    /*
    * Uses this objects date and compares it to the system clock to calculate
    * the amount of days until it needs to be completed
    */
    static void calculateDaysLeft(){

    }

    public void print(){
        System.out.println(this.title);

        //Create a string
        String dateStr = "Due by: " + this.month + " - " + this.day + " - " + this.year;
        System.out.println(dateStr);

        System.out.println("---------------------------------------");

        System.out.println(this.description);
        System.out.println();
    }
}
