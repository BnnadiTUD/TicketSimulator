import java.util.Scanner;
/**
 * Write a description of class Event here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Event 
{
    /** declare all variables */
    private String comedianName;
    private String dayOfTheWeek;
    private String time;
    private double price;
    private int numberOfTicketsSold;
    
    public Event()
    {
        /**
         * Constructor 1 - create space for an Event object
         * Data elements are empty so far
         */
        this.comedianName = "";
        this.dayOfTheWeek = "";
        this.time = "";
        this.price = 0;
        this.numberOfTicketsSold = 0;
    }

    /**
     * Constructor 2 - create space for an Event object
     * Data elements passed in as parameters
     */
    public Event(String comedianName, String dayOfTheWeek, String time, 
    double price, int numberOfTicketsSold)
    {
        this.comedianName = comedianName;
        this.dayOfTheWeek = dayOfTheWeek;
        this.time = time;
        this.price = price;
        this.numberOfTicketsSold = numberOfTicketsSold;
    }
    
    /** create a function to call all data in the constructor **/
    /** return the comedianname */
    public  String getComedianName()
    {
        return this.comedianName;
    }
    
    /** return the dayOfTheWeek */
    public String getDayOfTheWeek()
    {
        return this.dayOfTheWeek;
    }
    
    /** return the time */
    public String getTime()
    {
        return this.time;
    }
    
    /** return the price */
    public double price()
    {
        return this.price;
    }
    
    /** return the numberOfTicketsSold */
    public int getNumberOfTicketsSold()
    {
        return numberOfTicketsSold;
    }
    
    /** make pure modules to replace any data later */
    
    public void setComedianName(String comedianName)
    {
        this.comedianName = comedianName ;
    }
    
    public void setDayOfTheWeek(String dayOfTheWeek)
    {
        this.dayOfTheWeek = dayOfTheWeek;
    }
    
    public void setTime(String time)
    {
        this.time = time;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public void setTicketsSold(int tickets)
    {
        this.numberOfTicketsSold = tickets;
    }
    
    public String toString()
    {
        return "\nComedian: " + this.comedianName + "\n" +
        "Day: "+ this.dayOfTheWeek + "\n " + 
        "Time: " + this.time + "\n" + 
        "Tickets cost: "  + this.price + "\n" +
        "Tickets sold: " + this.numberOfTicketsSold + "/50";

    }   
    
    public int numberOfTicketsAvailible()
    {
        return 50 - this.numberOfTicketsSold;
    }
}

