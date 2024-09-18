package Account;
import Client.*;
import Exception.*;
import Operation.*;
import Taxa.*;


public class AccountUniversity extends Account {

    public AccountUniversity(Client owner, double balance, int ID, double accountlimit, double withdraw, String agency) {
        super(owner, balance, ID, accountlimit, withdraw, agency);
    }

    public void setLimit(double newlimit) throws IllegalArgumentException{

            if(newlimit>500){ throw new IllegalArgumentException("ERROR! O limite máximo é de R$500"); }
            else if(newlimit < 0){ throw new IllegalArgumentException("ERROR! O limite mínimo é de R$0"); }
            accountlimit = newlimit;

    }

    @Override
    public double calculateTax() {
        return 0;
    }

}


