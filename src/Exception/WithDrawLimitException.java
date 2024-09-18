package Exception;
import Account.*;
import Client.*;
import Exception.*;
import Operation.*;
import Taxa.*;

public class WithDrawLimitException extends Exception {

    public WithDrawLimitException(String message) {
        super(message);
    }
}