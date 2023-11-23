import java.util.ArrayList;
import java.util.Random;

public class Wallet {
    private final String owner;
    private final int token;
    private int isepCoins=0;
    private static ArrayList<Integer> lastTok=new ArrayList<>();

    public String getOwner() {
        return owner;
    }


    public int getToken() {
        return token;
    }

    public int getIsepCoins() {
        return isepCoins;
    }

    public void setIsepCoins(int isepCoins) {
        this.isepCoins = isepCoins;
    }

    public Wallet(String name,int coins) {
        this.owner = name;
        this.token=generateToken();
        this.isepCoins=coins;
    }
    private int generateToken(){
         Random random=new Random() ;
         int randInt;
         do{
             randInt=random.nextInt();
         }while(lastTok.contains(randInt)|| randInt<0);
         lastTok.add(randInt);
         return randInt;
    }

    @Override
    public String toString() {
        return token+" "+owner+" "+isepCoins;
    }
}
