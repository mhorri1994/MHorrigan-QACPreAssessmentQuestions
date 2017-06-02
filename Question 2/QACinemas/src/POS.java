import java.util.Calendar;

/**
 * Created by Matthew on 30/05/2017.
 */
public class POS {
    public POS(){
        MenuHandler menuHandler = new MenuHandler();
        Movie chosen = menuHandler.runCMDMenu();
        Tickets ticketHandler = new Tickets();
        //assign the date of the movie
        ticketHandler.setShowingDay(chosen.getShowingDayOfWeek());
        ticketHandler.setShowingDay(chosen.getShowingDate().get(Calendar.DAY_OF_WEEK));
        ticketHandler.askForTicketsCMD();
        ticketHandler.printTotal();
    }
}
