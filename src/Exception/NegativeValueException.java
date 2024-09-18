package Exception;
import Account.*;
import Client.*;
import Exception.*;
import Operation.*;
import Taxa.*;

public class NegativeValueException extends Exception {

    public NegativeValueException(String message) {
        super(message);
    }
}

