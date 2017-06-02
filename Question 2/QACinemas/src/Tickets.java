import java.util.*;

/**
 * Created by Matthew on 30/05/2017.
 */
public class Tickets {
    private Map<ticketTypes, Integer> allTickets = new HashMap<>();
    private final int DISCOUNT_DAY = Calendar.WEDNESDAY;
    private final double DISCOUNT_VALUE = 2.0;
    private int showingDay;

    /**
     * Add a ticket to the current list
     * @param ticket    ticketTypes    Ticket to add
     */
    public void addTicket(ticketTypes ticket){
        if(allTickets.keySet().contains(ticket)) allTickets.put(ticket, allTickets.get(ticket) + 1);
        else allTickets.put(ticket, 1);
    }

    /**
     * Returns the total for the current order
     * @return  double  Total ticket prices
     */
    public double getTotal(){
        double finalVal = 0.0;
        double discount = 0.0;
        if(checkDiscountDay(showingDay)) discount = DISCOUNT_VALUE;
        for(ticketTypes t:allTickets.keySet()){
            finalVal += (t.getValue() * allTickets.get(t) - (discount * allTickets.get(t)));
        }
        return finalVal;
    }

    /**
     * Checks if the movie chosen is shown on a discounted day
     * @param dayOfShowing
     * @return  boolean discounted day?
     */
    private boolean checkDiscountDay(int dayOfShowing){
        if(dayOfShowing == DISCOUNT_DAY) return true;
        return false;
    }

    /**
     * Returns the showind day of the chosen movie
     * @return  int Calendar.Day_of_week showing day
     */
    public int getShowingDay() {
        return showingDay;
    }

    /**
     * Sets the showing day based from a movie
     * @param showingDay    DayOfWeek integer value
     */
    public void setShowingDay(int showingDay) {
        this.showingDay = showingDay;
    }

    /**
     * Runs an interface in a command prompt to let the user select what tickets they want
     */
    public void askForTicketsCMD(){
        String input = "";
        String regex = "[0-9]+";
        Scanner readInput = new Scanner(System.in);
        while(!input.matches(regex)){
            int count = 1;
            for(ticketTypes t:ticketTypes.values()){
                System.out.println("(" + count + ") " + t);
                count++;
            }
            System.out.println("(0) Exit");
            System.out.println("Select a ticket");
            input = readInput.nextLine();
        }
        if(input.equals("0")) return;
        if(Integer.parseInt(input) < ticketTypes.values().length) {
            ticketTypes chosenTicket = ticketTypes.values()[Integer.parseInt(input) - 1];
            addTicket(chosenTicket);
        }
        askForTicketsCMD();
    }

    /**
     * Prints to total price of the tickets and any discounted values
     */
    public void printTotal(){
        System.out.println("All tickets:");
        for(ticketTypes t:allTickets.keySet()){
            if(checkDiscountDay(showingDay)) System.out.println(allTickets.get(t) + " " + t + " - £" + DISCOUNT_VALUE + " (Discount Day)");
            else System.out.println(allTickets.get(t) + " " + t + " * " + allTickets.get(t));
        }
        System.out.println("Your total is: £" + getTotal());
    }
}
