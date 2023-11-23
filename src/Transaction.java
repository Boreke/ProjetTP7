public class Transaction {
    private final Wallet originWallet;
    private final Wallet destinationWallet;
    private final int isepCoins;
    private boolean paid;

    public Wallet getOriginWallet() {
        return originWallet;
    }

    public Wallet getDestinationWallet() {
        return destinationWallet;
    }


    public int getIsepCoins() {
        return isepCoins;
    }


    public boolean isPaid() {
        return paid;
    }

    public Transaction(Wallet originWallet, Wallet destinationWallet, int isepCoins) {
        this.originWallet = originWallet;
        this.destinationWallet = destinationWallet;
        this.isepCoins = isepCoins;
    }

    @Override
    public String toString() {
        return "transaction de "+originWallet.getOwner()+" vers "+destinationWallet.getOwner()+" de" + isepCoins;
    }

    protected void pay(){
        if (!originWallet.equals(destinationWallet)&&originWallet.getIsepCoins()>=this.isepCoins){
            originWallet.setIsepCoins(originWallet.getIsepCoins()-isepCoins);
            destinationWallet.setIsepCoins(destinationWallet.getIsepCoins()+isepCoins);
            this.paid=true;
        } else if (originWallet.equals(destinationWallet)) {
            System.out.println("transaction invalide");
        } else if (originWallet.getIsepCoins()<this.isepCoins) {
            System.out.println("solde insuffisant");
        }
    }
}
