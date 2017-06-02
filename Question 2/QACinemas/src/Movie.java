import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Matthew on 30/05/2017.
 */
public class Movie {
    private String name;
    private Calendar showingDate;

    public Movie(String name, Calendar showingDate) {
        this.name = name;
        this.showingDate = showingDate;
    }

    /**
     * Returns the name of a movie
     * @return  String  movie name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of a movie
     * @param name  String  movie name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the showing date of the movie
     * @return  Calendar    Date of the movie
     */
    public Calendar getShowingDate() {
        return showingDate;
    }

    /**
     * Returns the integer value for the day of the week that the movie is shown
     * @return
     */
    public int getShowingDayOfWeek(){ return showingDate.DAY_OF_WEEK;}

    /**
     * Sets te date of the movie
     * @param showingDate
     */
    public void setShowingDate(Calendar showingDate) {
        this.showingDate = showingDate;
    }

    @Override
    public String toString(){

        SimpleDateFormat format = new SimpleDateFormat("EEE-dd-MMM");
        return getName() + " - " + format.format(showingDate.getTime());
    }
}
