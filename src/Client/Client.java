package Client;
import Account.*;
import Exception.*;
import Operation.*;
import Taxa.*;


import java.io.Serializable;
import java.util.Date;

public abstract class Client implements Serializable {
    protected String name;
    protected String adress;
    protected Date date;


    public Client(String adress, String name) {

        this.adress = adress;
        this.name = name;
        this.date = new Date();

    }

    abstract boolean autenticar(String key);

    public void print(){
        System.out.println("Cliente inválido");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


    public Date getDate() {
        return date;
    }
}