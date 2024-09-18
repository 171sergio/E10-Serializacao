package Operation;
import Account.*;
import Client.*;
import Exception.*;
import Taxa.*;

public class OperationWithdraw extends Operation implements ITaxa {
    public OperationWithdraw(float amount) {
        super('s', amount);
    }

    @Override
    public double calculateTax() {
        return 0.05;
    }
}
