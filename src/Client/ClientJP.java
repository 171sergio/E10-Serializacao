package Client;
import java.util.Objects;
import Account.*;
import Exception.*;
import Operation.*;
import Taxa.*;

public class ClientJP extends Client {

    private String sector;
    private int numFuncionarios;
    private String CNPJ;


    public ClientJP(String adress, String name, String sector, int numFuncionarios, String CNPJ) {
        super(adress, name);
        this.sector = sector;
        this.numFuncionarios = numFuncionarios;
        this.CNPJ = CNPJ;
    }
    @Override
    public String toString(){
        String jdStr;
        jdStr = " CNPJ: " + this.CNPJ +
        " Nome: " + this.name +
        " Endereço: " + this.adress+
        " Número de funcionários: " + this.numFuncionarios+
        " Setor: " + this.sector+
        " Data de criação: " + this.date;
        return jdStr;
    }
    @Override
    public boolean equals(Object obj){
        ClientJP pJcomp = (ClientJP) obj;
        return pJcomp.CNPJ.equals(this.CNPJ);
    }

    @Override
    boolean autenticar(String key) {
        return key.equals(this.CNPJ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CNPJ);
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public int getNumFuncionarios() {
        return numFuncionarios;
    }

    public void setNumFuncionarios(int numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        sector = sector;
    }
}
