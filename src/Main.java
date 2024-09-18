import Account.*;
import Client.*;
import Exception.*;
import Operation.*;
import Taxa.*;

public class Main {

    public static void main(String[] args) {

        Client client = new ClientIndividual("Rua Exemplo, 123", "Ana", 21, 'F', "12345678901");

        // Criação de uma conta universitária
        Account account = new AccountUniversity(client, 1000.0, 1, 200.0, 100.0, "Agência 123");

        account.setLimit(1000);
        System.out.println("lalala");

    }
}
