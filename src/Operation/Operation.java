package Operation;
import java.util.Date;
import Account.*;
import Client.*;
import Exception.*;
import Taxa.*;

public abstract class Operation implements ITaxa, Comparable<Operation>{

    protected Date date;

    protected char type;

    protected double amount;

    public Operation(char type, double amount) {
        this.type = type;
        this.amount = amount;
        date = new Date();
    }

    @Override
    public String toString(){
        String opStr;

        opStr = "Data : " + getDate() + " Tipo : " + getType() + " Valor : " + getAmount() + "\n";

        return opStr;
    }

    @Override
    public int compareTo(Operation operacao) {
        if (operacao.type == 'd') {
            if (this.type == operacao.type)
                return this.date.compareTo(operacao.date);
            else
                return 1;
        } else if (operacao.type == 's') {
            if (this.type == operacao.type)
                return this.date.compareTo(operacao.date);
            else
                return -1;
        } else {
            return 0;
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        if(type=='d' || type=='s'){
            this.type = type;
        }else{
            System.err.println("Erro, valores aceitos em type: s/d");;
            System.exit(1);
        }

    }

}