import java.util.ArrayDeque;


public class Block {
    private ArrayDeque<Transaction> transactionStack=new ArrayDeque<>();

    public ArrayDeque<Transaction> getTransactionStack() {
        return transactionStack;
    }

    public Block(ArrayDeque<Transaction> transactionStack) {
        this.transactionStack = transactionStack;
    }

    @Override
    public String toString() {
        StringBuilder retour = new StringBuilder();
        for (Transaction s:
             transactionStack) {
            retour.append(s.toString()).append("\n");
        }
        return "block " + retour;
    }

    public Block add(Transaction trans){
        this.transactionStack.addLast(trans);
        if(this.transactionStack.size()==10){

            for(Transaction transaction:transactionStack){
                transaction.pay();
            }
            ArrayDeque<Transaction> copieTransactionStack=new ArrayDeque<>(transactionStack);
            Main.blockChain.add(new Block(copieTransactionStack));
            transactionStack.clear();
        }
        return this;
    }

}
