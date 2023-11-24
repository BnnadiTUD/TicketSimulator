import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class EventDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EventDriver
{
    /** declare arraylist as global variable */
    ArrayList<Event> eventInfo;

    /** Make a constructor for events */
    public EventDriver()
    {
        //1. Create the ArrayList
        eventInfo = new ArrayList<Event>();

        // 2. Input 3 events into the ArrayList
        inputEvents();

        System.out.print("\f");
        processMenu();

    }

    public static void main (String[] args )
    {
        new EventDriver();
    }

    /** Create a method to input the events data */
    public void inputEvents()
    {
        String comedianName, dayOfTheWeek, time; // this method is how the user inputs the event data
        int numberOfTicketsSold = 0;
        double price;
        Event event1;

        Scanner scan = new Scanner(System.in);// declare scanner to input value

        for (int count = 1; count <= 5; count++) //for loop allows us to enter three items into the arraylist
        {
            System.out.print("\nComedian: ");
            comedianName = scan.nextLine();

            System.out.print("Day (Friday - Sunday): ");
            dayOfTheWeek = scan.nextLine();
            do
            { //this do while states if the user doesnt choose either friday, saturday or sunday they wont be able to move on 
                if(dayOfTheWeek.equalsIgnoreCase("Friday"))
                {
                }
                else if(dayOfTheWeek.equalsIgnoreCase("Saturday"))
                {
                }
                else if(dayOfTheWeek.equalsIgnoreCase("Sunday"))
                {
                }
                else 
                {
                    System.out.print("Day (Friday - Sunday): ");
                    dayOfTheWeek = scan.nextLine();
                }
            }while(!dayOfTheWeek.equalsIgnoreCase("friday") && !dayOfTheWeek.equalsIgnoreCase("saturday") && 
            !dayOfTheWeek.equalsIgnoreCase("sunday"));

            System.out.print("Time (evening or late): ");
            time = scan.nextLine();
            do 
            { // do while states the user has to either input late or evening for the time
                if(time.equalsIgnoreCase("evening"))
                {
                }
                else if (time.equalsIgnoreCase("late"))
                {

                }
                else
                {
                    System.out.print("Time (evening or late): ");
                    time = scan.nextLine();  
                }
            }while(!time.equalsIgnoreCase("evening") && !time.equalsIgnoreCase("late"));

            System.out.print("Price: ");
            price = scan.nextDouble();

            System.out.print("Amount sold: " + numberOfTicketsSold + "/50" + "\n"); // state the amount of tickets sold 
            scan.nextLine();

            event1 = new Event (comedianName, dayOfTheWeek, time, price, numberOfTicketsSold);
            eventInfo.add(event1); // add the event info into the arraylist
        }
        /** Clear the screen */
        System.out.println(" Press return to continue and clear screen ");
        scan.nextLine();
        System.out.print("\f");
    }

    /** Create a method to display the menu*/
    public void displayMenu()
    {
        System.out.println("\n1. Buy tickets for an event.");
        System.out.println("\n2. Cancel tickets for an event.");
        System.out.println("\n3. Display Full Event Schedule.");
        System.out.println("\n4. Menu option to test your extra event responsibility");
        System.out.println("\n5. Exit System\n");
    }

    /** Create a function which returns a choice 1-5 on the menu*/
    public int getMenuOption()
    {
        Scanner scan = new Scanner(System.in);
        int choice;
        do
        {
            System.out.println("Please choose either 1, 2, 3, 4 or 5");
            choice = scan.nextInt();
        }while(choice < 1 || choice > 5);
        return choice;
    }

    /** Create method that allows user to buy a ticket for an event*/
    public void buyTicketsForAnEvent()
    {

        Scanner scan = new Scanner(System.in);
        String value;
        String day;
        String name;
        String email;
        int number;
        int amount = 0;
        boolean found = false;
        int numberOfTicketsSold; 
        int numberOfTickets = 50;
        int ticketsBooked;
        System.out.print("What event do you want buy tickets for ?:");
        value = scan.nextLine();
        System.out.print("What day do you want buy tickets for ?:");
        day = scan.nextLine();
        for (Event buy : eventInfo)
        {
            if(value.equalsIgnoreCase(buy.getComedianName()) && day.equalsIgnoreCase(buy.getDayOfTheWeek()))
            { //if the comedian name and day match an event proceed to buy tickets
                found = true;
                System.out.println("How many tickets would you like to buy for" + " "  + buy.getComedianName() + " " + 
                    "on" + " " + buy.getDayOfTheWeek());
                amount = scan.nextInt();
                if (buy.numberOfTicketsAvailible() == 0) 
                { // if there are 0 tickets availible print out the following message
                    System.out.println("There are no tickets left for this event");
                }
                else if (amount <= buy.numberOfTicketsAvailible() && buy.numberOfTicketsAvailible() > 0)
                { //if the amount of tickets a user wants to buy is greater than or equal to the amount availible proceed
                    //and if the amount availble is greater than zero proceed

                    ticketsBooked = amount + buy.getNumberOfTicketsSold(); // amount inputed by user is added to number of 
                    //tickets sold method in event class which updates it each time the method is ran which creates the variable
                    // ticketsBooked
                    buy.setTicketsSold(ticketsBooked);
                    int amountLeft = numberOfTickets - buy.getNumberOfTicketsSold();
                    System.out.println("There are" + " " + amountLeft + "/50 tickets left for" + " " + 
                    buy.getComedianName() + " on " + buy.getDayOfTheWeek());
                    System.out.println("Input customer name:");
                    name = scan.nextLine(); name = scan.nextLine();
                    System.out.println("Input customer number:");
                    number = scan.nextInt();
                    System.out.println("Input email:");
                    email = scan.nextLine(); email = scan.nextLine();

                    System.out.println("Thank you for purchasing tickets today - Your receipt is here");
                    System.out.println("Name:" + name);
                    System.out.println("Number:" + number);
                    System.out.println("Email Address:" + email);
                    System.out.println("Tickets bought:" + ticketsBooked);
                    System.out.println("Event booked:" + buy.getComedianName());
                    System.out.println("Day:" + buy.getDayOfTheWeek());
                }
                else if (amount > buy.numberOfTicketsAvailible())
                { //if a user tries to buy more tickets than there are availible they wont be able to do so
                    System.out.println("Please reduce the amount of tickets you want to buy");
                }

                if (found==false)
                { // boleean is false when a user searches for an event thats not been made
                    System.out.println("The event " + value + " does not exist");
                }
            }
        }                                                                
    }

    public void cancelTicketsForAnEvent()
    {
        Scanner scan = new Scanner(System.in);
        String value;
        String day;
        int amount = 0;
        int ticketsCancelled;
        int numberOfTickets = 50;
        boolean found = false;
        System.out.print("What event do you want cancel tickets for ?:");
        value = scan.nextLine();
        System.out.print("What day do you want cancel tickets for ?:");
        day = scan.nextLine();
        /** for each loop to search the arraylist
         */
        for (Event cancel : eventInfo)
        {
            if(value.equalsIgnoreCase(cancel.getComedianName()) && day.equalsIgnoreCase(cancel.getDayOfTheWeek()))
            {//if the comedian name and day match an event proceed to cancel tickets
                found = true;
                System.out.println("How many tickets would you like to cancel for" + " "  + cancel.getComedianName() + " " + 
                    "on" + " " + cancel.getDayOfTheWeek());
                amount = scan.nextInt();
                if (cancel.numberOfTicketsAvailible() == 50) 
                { // cannot cancel tickets if theres still 50 availible
                    System.out.println("There are no tickets availible to cancel");
                }
                else if (amount <= cancel.numberOfTicketsAvailible() && amount == 0)
                { // when the amount youre trying to cancel is less than or equal to the amount availble you can proceed
                    int ticketsLeft = cancel.numberOfTicketsAvailible() + amount;
                    cancel.setTicketsSold(cancel.getNumberOfTicketsSold() - amount);                  
                    System.out.println("There are" + " " + ticketsLeft + "/50 tickets left for" + " " + 
                    cancel.getComedianName() + " on " + cancel.getDayOfTheWeek());
                }
                else if (amount == 50 && cancel.numberOfTicketsAvailible() == 0)
                {
                    int ticketsLeft = cancel.numberOfTicketsAvailible() + amount;
                    cancel.setTicketsSold(cancel.getNumberOfTicketsSold() - amount);                  
                    System.out.println("There are" + " " + ticketsLeft + "/50 tickets left for" + " " + 
                    cancel.getComedianName() + " on " + cancel.getDayOfTheWeek());
                }
            }
        }
    }

    /** Short method to display events of arraylist*/
    public void displayEvents()
    {
        int number = 1;
        for (Event s: eventInfo)
        {
            System.out.println("\nEvent" + number);
            System.out.println(s.toString());
            number ++;
      }
    }

    public void chooseASeat()
    {
        ArrayList<Seat> seats = new ArrayList<>();

        // add premium seat
        Seat premiumSeat = new Seat("premium", 75.0);
        seats.add(premiumSeat);

        // add standard seat
        Seat standardSeat = new Seat("standard", 37.5);
        seats.add(standardSeat);

        // add VIP seat
        Seat vipSeat = new Seat("vip", 150.0);
        seats.add(vipSeat);

        for (Seat seat : seats) {
            System.out.println("Seat type: " + seat.getType() + ", price: " + seat.getPrice());
        }

        Scanner scan = new Scanner(System.in);
        String type;
        boolean found = false;
        System.out.println("\nWhich seat type do you want to buy?");
        type = scan.nextLine();

        for (Seat a : seats) 
        {
            if(type.equalsIgnoreCase(a.getType()))
            {
                found = true;

                if (type.equalsIgnoreCase("vip"))
                {
                    System.out.println("The VIP package contains... ");
                    System.out.println("Front row premium leather recliner sofe beds ");
                    System.out.println("Free 3 course meal ");
                    System.out.println("Free soft drink and glass of champagne/wine ");
                    System.out.println("Free t-shirt, cap and scarf ");
                    System.out.println("Free autograph from comedian of your choice");
                    System.out.println("Exclusive backstage pass ");
                    System.out.println("Automatic entry to raffle with €1000 cash prize");

                }
                else if (type.equalsIgnoreCase("premium"))
                {
                    System.out.println("The premium pacakge contains... ");
                    System.out.println("Middle row recliner seats ");
                    System.out.println("Free starter and main ");
                    System.out.println("Free soft drink");
                    System.out.println("Free t-shirt and cap merchandise ");
                    System.out.println("Signed autograph from comedian of your choice ");
                }
                else if (type.equalsIgnoreCase("standard"))
                {
                    System.out.println("The standard package contains... ");
                    System.out.println("Normal backrow seats ");
                    System.out.println("Free snack");
                    System.out.println("Free soft drink ");
                    System.out.println("Free t-shirt merchendise ");
                }
                System.out.println("\nAre you sure you want to purchase a" + " " + a.getType() + " " + "for" + " " + "€" +
                    a.getPrice() + "? (Type yes or no)"); 

                String confirmation;
                confirmation = scan.nextLine();
                if (confirmation.equalsIgnoreCase("yes")) {
                    System.out.println("Enjoy your seat!\n");
                } else {
                    System.out.println("You will be redirected back to the menu.\n");
                }
            }
        }
    }

    /** Method that ends the program*/
    public void exitMenu()
    {
        // empty method as it indicates the end to the program
    }

    /** Put together the menu choice so that it calls one of the methods */
    public void processMenu()
    {
        int menuOption = 0;

        do
        {
            displayMenu();

            menuOption = getMenuOption();
            if(menuOption == 1)
            {
                buyTicketsForAnEvent();
            }
            else if (menuOption == 2)
            {
                cancelTicketsForAnEvent();
            }
            else if (menuOption == 3)
            {
                displayEvents();
            }
            else if (menuOption == 4)
            {
                chooseASeat();
            }
            else if (menuOption == 5)
            {
                System.out.print("Thank you for buying tickets, come again :)");
            }
        }while(menuOption != 5);
    }
}

