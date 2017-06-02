import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Matthew on 30/05/2017.
 */
public class MenuHandler {
    private List<Movie> movieList = new ArrayList<>();

    public MenuHandler(){
        //temporary movies added to the list
        Calendar date;
        for(int i = 0; i < 6; i++){
            date = Calendar.getInstance();
            date.add(Calendar.DATE, i);
            movieList.add(new Movie("Movie " + i, date));
        }
    }

    /**
     * Displays the menu for what movies are available
     */
    public void displayMenu(){
        System.out.println("Movies Available:");
        int count = 1;
        for(Movie movie:getMovieList()){
            System.out.println("(" + count + ") " + movie);
            count++;
        }
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    /**
     * Runs the menu for movies in a command prompt
     * @return  Movie   Movie that the user has chosen
     */
    public Movie runCMDMenu(){
        String input = "";
        String regex = "[0-9]+";
        Scanner readInput = new Scanner(System.in);
        while(!input.matches(regex)){
            displayMenu();
            System.out.println("What movie do you want to watch?");
            input = readInput.nextLine();
        }
        //if(Integer.parseInt(input) >= movieList.size()) return runMenu();
        try{
            return movieList.get(Integer.parseInt(input) - 1);
        }   catch (Exception e){
            return runCMDMenu();
        }
    }
}
