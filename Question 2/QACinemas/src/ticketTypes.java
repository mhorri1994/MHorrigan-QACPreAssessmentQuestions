/**
 * Created by Matthew on 30/05/2017.
 */
public enum ticketTypes {
    STANDARD (8.0),
    OAP (6.0),
    STUDENT (6.0),
    CHILD (4.0);

    private final double value;

    /**
     * Sets the basic variables for a ticket
     * @param value value of the ticket
     */
    ticketTypes(double value){
        this.value = value;
    }

    /**
     * Returns the value of this ticket
     * @return  double  ticket value
     */
    public double getValue() {
        return value;
    }

    /**
     * Overriide the toString method
     * @return  String  Constructed string explaining what the ticket is
     */
    @Override
    public String toString(){
        return this.name() + " @ £" + getValue();
    }
}
