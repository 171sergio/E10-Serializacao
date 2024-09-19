import Account.*;
import Client.*;
import Exception.*;
import Operation.*;
import Taxa.*;

public class Main {

    public static void main(String[] args) {

        Client client = new ClientIndividual("Rua Exemplo, 123", "Ana", 21, 'F', "12345678901");
        Account account = new AccountUniversity(client, 1000.0, 1, 500.0, 300.0, "Agencia123");


        account.saveAccountToFile();


        Account loadedAccount = Account.LoadAccountFromFile("Agencia123", 1);


        if (loadedAccount != null) {
            System.out.println("Conta carregada: \n" + loadedAccount);
        } else {
            System.out.println("Não foi possível carregar a conta.");
        }

    }
}
