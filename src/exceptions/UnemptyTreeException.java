package exceptions;

@SuppressWarnings("serial")
public class UnemptyTreeException extends RuntimeException {
    public UnemptyTreeException(){
        super("Tree is not empty");

    }
}
