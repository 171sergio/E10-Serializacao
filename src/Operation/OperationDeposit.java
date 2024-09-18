package Operation;
import Account.*;
import Client.*;
import Exception.*;
import Taxa.*;


public class OperationDeposit extends Operation {
    public OperationDeposit(float amount) {
        super('d', amount);
    }

    @Override
    public double calculateTax() {
        return 0;
    }
}
