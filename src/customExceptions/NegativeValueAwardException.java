package customExceptions;

public class NegativeValueAwardException extends Exception {

    // Parameter less Constructor
    public NegativeValueAwardException() {
    }

    public String toString(){
        return "Impossible to send your award as it has negative value. Please, change award value and try again.";
    }
}
