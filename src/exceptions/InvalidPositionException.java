package exceptions;

@SuppressWarnings("serial")
public class InvalidPositionException extends RuntimeException {

    public InvalidPositionException(){
        super("Invalid Position");
    }
}
