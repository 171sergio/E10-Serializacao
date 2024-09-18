package Client;

import java.util.Objects;
import Account.*;
import Exception.*;
import Operation.*;
import Taxa.*;

public class ClientIndividual extends Client {
    private int age;
    private char sex;
    private String CPF;

    public ClientIndividual(String adress, String name, int age, char sex, String CPF) {
        super(adress, name);
        this.age = age;
        this.sex = sex;
        this.CPF = CPF;

    }
    @Override
    public String toString(){
       String individualStr;
       individualStr =  
       " CPF: " + this.CPF+ "\n" +
       " Nome: " + this.name+ "\n" +
       " Endereço: " + this.adress+ "\n" +
       " Idade: " + this.age+ "\n" +
       " Sexo: " + this.sex+ "\n" +
       " Data de criação: " + this.date + "\n\n";
       return individualStr;
    }

    @Override
    public boolean equals(Object obj){
        ClientIndividual pFisicaComparada = (ClientIndividual) obj;
        return pFisicaComparada.CPF.equals(this.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CPF);
    }

    @Override
    boolean autenticar(String key) { return key.equals(this.CPF); }


    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

}
