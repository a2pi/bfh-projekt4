package exceptions;

import org.w3c.dom.ls.LSOutput;

@SuppressWarnings("serial")
public class EmptyTreeException extends RuntimeException {

        public EmptyTreeException(){
            super("Tree is empty");
        }

}
