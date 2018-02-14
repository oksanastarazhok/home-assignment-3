package customExceptions;

public class NegativeValueAwardException extends Exception {

    public String toString(){
        return "Impossible to send your award as it has negative value. Please, change award value and try again.";
    }
}
