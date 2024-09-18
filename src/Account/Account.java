package Account;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import Client.*;
import Exception.*;
import Operation.*;
import Taxa.*;

public abstract class Account implements ITaxa, Serializable {

    private static final long serialVersionUID = 1L;
    protected Client owner;
    private double balance;
    private int ID;
    protected double accountlimit, withdrawlimit;
    private String agency;


    protected ArrayList<Operation> operations = new ArrayList<Operation>();

    public static int totAccounts=0;

    public Account(Client owner, double balance, int ID, double accountlimit, double withdrawlimit, String agency) {
        this.owner = owner;
        this.balance = balance;
        this.ID = ID;
        this.accountlimit = accountlimit;
        this.withdrawlimit = withdrawlimit;
        this.agency = agency;
        totAccounts++;
    }

    public void saveAccountToFile() {
        String filename = agency + "-" + ID + ".ser";  // Nome do arquivo: AGENCIA-CONTA.ser
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(filename))) {
            write.writeObject(this);  // Serializa o objeto 'Account' e salva no arquivo
            System.out.println("Conta salva com sucesso no arquivo: " + filename);
        } catch (IOException e) {
            System.err.println("Erro ao salvar a conta: " + e.getMessage());
        }
    }

    // Método para carregar uma conta de um arquivo baseado na agência e número da conta
    public static Account loadAccountFromFile(String agency, int accountNumber) {
        String filename = agency + "-" + accountNumber + ".ser";  // Formato do arquivo: AGENCIA-CONTA.ser
        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(filename))) {
            return (Account) read.readObject();  // Desserializa o arquivo e retorna a conta
        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo não encontrado (" + filename + ")");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar a conta: " + e.getMessage());
        }
        return null;  // Retorna null se ocorrer um erro
    }


    boolean deposit(float value) throws NegativeValueException, AccountLimitException {

            if(value<0.0){ throw new NegativeValueException("ERRO: Depósito com valor negativo.");}
            if(value + this.balance > this.accountlimit){ throw new AccountLimitException("ERRO: Com o depósito deste o limite da conta ser excedido"); }
            this.balance += value;
            operations.add(new OperationDeposit(value));
            return true;

    }


    boolean withdraw(float value) throws NegativeValueException, WithDrawLimitException, AccountLimitException {
            if (value < 0.0){ throw new NegativeValueException("ERRO: Saque com valor negativo."); }
            if(value > this.accountlimit){ throw new AccountLimitException("ERRO: Valor desejado é maior que o saldo."); }
            if(value > this.withdrawlimit){ throw new WithDrawLimitException("ERRO: O valor desejado é maior que o limite de saque da conta."); }
            this.balance -= value;
            operations.add(new OperationWithdraw(value));
            return true;
    }


    boolean transfer(Account destineAccount, float value) throws NegativeValueException, WithDrawLimitException, AccountLimitException {
        boolean withdrawMade = this.withdraw(value);
        if (withdrawMade) {
            boolean deposit = destineAccount.deposit(value);
            return deposit;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
		String accountStr = " Nome do dono da conta: " + this.owner.getName() + "\n" +
     " Número da conta: " + this.ID+ "\n" +
     " Saldo atual: " + this.balance+ "\n" +
     " Limite: " + this.accountlimit + "\n\n" ;

		return accountStr;
	}
    @Override
    public boolean equals(Object obj){
        Account actcomp = (Account) obj;
        return actcomp.ID == this.ID;
    }

    void printStatemant(int order) {
            ArrayList<Operation> operacoes = new ArrayList<Operation>(this.operations);
            switch (order) {
                case 0: break;
                case 1: Collections.sort(operacoes); break;
                default: System.out.println("\nERRO! Algum Número deve ser digitado.\n"); return;
            }

            for (Operation operacao : operacoes) { System.out.print(operacao.toString()); }
    }

    public void printFeeStatement(){
        double totalFee = this.calculateTax();
        System.out.printf("=== Extrato de Taxas ===\nManutenção da conta: %.2f\n\n", this.calculateTax() );
        System.out.println("Operações:\n");
        for(int i = 0; i < operations.size(); i++){
            totalFee += this.operations.get(i).calculateTax();
            if(operations.get(i).getType() == 's' && operations.get(i).calculateTax() != 0){
                System.out.printf("Saque: %.2f\n", operations.get(i).calculateTax());
            }
        }
        System.out.printf("\nTotal: %.2f\n", totalFee);
    }


    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) { this.owner = owner; }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getBalance() {
        return balance;
    }

    public double getAccountlimit() {
        return accountlimit;
    }

    public void setAccountLimit(double limit) {
        this.accountlimit = limit;
    }

    public abstract void setLimit(double newlimit);

    public ArrayList<Operation> getOperations() { return operations; }
}