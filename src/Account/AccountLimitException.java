package Account;
import Client.*;
import Exception.*;
import Operation.*;
import Taxa.*;


public class AccountLimitException extends Exception {
    public AccountLimitException(String message) {
        super(message);
    }
}
