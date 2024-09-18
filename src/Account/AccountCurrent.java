package Account;
import Client.*;
import Exception.*;
import Operation.*;
import Taxa.*;

public class  AccountCurrent extends Account {

    public AccountCurrent(Client owner, double balance, int ID, double accountlimit, double withdraw, String agency) {
        super(owner, balance, ID, accountlimit, withdraw, agency);
    }

    public void setLimit(double newlimit){

        if(newlimit<-100){ throw new IllegalArgumentException("ERRO!  O limite minimo é de R$ -100,00"); }
            accountlimit = newlimit;
    }

    @Override
    public double calculateTax() {
        if(this.owner instanceof ClientIndividual){
            return 10;
        }
        else{
            return 20;
        }
    }



}

