import java.util.*;

// Quelle structure de données est adaptée pour représenter les transactions au sein d’un
//bloc de la blockchain ? deques (ArrayDeck)

//Quelle structure de données est adaptée pour stocker les portefeuilles des membres de la
//blockchain ? Dictionnaires (Hashmap)

//Quelle structure de données est adaptée pour stocker les blocs de la blockchain ?
//listes (arraylist)
public class Main {
    private static String[] eleves={"Theo","JD","Marco","Hippo","Guilhem"};
    public static ArrayList<Block> blockChain=new ArrayList<>();
    private static HashMap<Integer,Wallet> wallets=new HashMap<>();

    public static void main(String[] args) {
        createHashMap(wallets);
        simulation();
        System.out.println(wallets);
    }
    private static void createHashMap(HashMap<Integer,Wallet> hash){

        Wallet tempWallet;
        for (String name : eleves) {
            tempWallet = new Wallet(name, 10);
            hash.put(tempWallet.getToken(), tempWallet);

        }


    }
    private static void simulation(){
        List<Integer> clefs=wallets.keySet().stream().toList();
        Random random=new Random();
        ArrayDeque<Transaction> transactions=new ArrayDeque<>();
        Block block=new Block(transactions);
        for (int i = 0; i < 21; i++) {
            int randInt1=random.nextInt(0, clefs.size());
            int randInt2;
            int prix=random.nextInt(0, 10);
            do{
                randInt2=random.nextInt(0, clefs.size());
            }while(randInt1==randInt2);
            Transaction transaction=new Transaction(wallets.get(clefs.get(randInt1)),
                    wallets.get(clefs.get(randInt2)),
                    prix);
            block.add(transaction);
        }
    }
    private static void printChain(){

    }
}