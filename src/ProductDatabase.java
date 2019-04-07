import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
/**
 * The size of database is set by me. If you would like to add products to database you need to
 * increase variable sizeOfList and add correct lines in "products database.txt"
 */
public class ProductDatabase {
    private int sizeOfList=5;
    Map<Integer, Product> productsMap = new HashMap<>();
    ArrayList boughtProducts = new ArrayList();
    private float totalCost=0;
    public ProductDatabase(){
    }
    /**
     * databaseUpdate reads barcode and information about products from file and connect them together in a map
     */
    public void databaseUpdate (){
    FileReader file;
    BufferedReader reader;
        try {
            file = new FileReader("product database.txt");
            reader = new BufferedReader(file);

            for (int i = 0; i <sizeOfList ; i++) {
                int codeTMP;
                Product productTMP=new Product();
                codeTMP=Integer.parseInt(reader.readLine());
                productTMP.getData(reader);
                productsMap.put(codeTMP,productTMP);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * checkProduct is checking the given barcode. If it is in the database and it's available,
     * we are purchasing the product. Purchased products are put in boughtProducts list.
     */
    public void checkProduct(int key){

        if(productsMap.containsKey(key)){
            if(productsMap.get(key).getProduct()) {
                boughtProducts.add(key);
            }
        }else{
            System.out.println("Invalid bar-code");
        }
    }
    /**
     * showReceipt is preparing the receipt basing on boughtProducts list. The products contained in this
     * list are displayed and the totalCost is calculated.
     */
    public void showReceipt(){
        for (int i = 0; i <boughtProducts.size() ; i++) {
            totalCost=totalCost+productsMap.get(boughtProducts.get(i)).countProducts();
        }
        System.out.println("Total sum: "+totalCost);
    }

}
