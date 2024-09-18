package Exception;
import Account.*;
import Client.*;
import Exception.*;
import Operation.*;
import Taxa.*;

public class LimitExceededException extends IllegalArgumentException{
    public LimitExceededException(){
        super();
    }

    public LimitExceededException(String msg){
        super(msg);
    }

}