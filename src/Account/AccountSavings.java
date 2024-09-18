package Account;
import Client.*;
import Exception.*;
import Operation.*;
import Taxa.*;


public class AccountSavings extends Account {

    public AccountSavings(Client owner, double balance, int ID, double accountlimit, double withdraw, String agency) {
        super(owner, balance, ID, accountlimit, withdraw, agency);
    }

    public void setLimit(double newlimit){

        if(newlimit>1000){ throw new IllegalArgumentException("ERROR! O limite máximo é de R$1000"); }
        if(newlimit < 100){ throw new IllegalArgumentException("ERROR! O limite mínimo é de R$100"); }
        accountlimit = newlimit;

    }

    @Override
    public double calculateTax() {
        return 0;
    }
}