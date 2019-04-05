import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ProductDatabase {
    private int sizeOfList=5;
    Map<Integer, Product> productsMap = new HashMap<>();
    ArrayList boughtProducts = new ArrayList();
    private float totalCost=0;
    public ProductDatabase(){
    }
    public void databaseUpdate (){
    FileReader file;
    BufferedReader reader;


        try {
            file = new FileReader("product database.txt");
            reader = new BufferedReader(file);
            //Product productTMP=new Product();
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
    public void showReceipt(){
        for (int i = 0; i <boughtProducts.size() ; i++) {
            totalCost=totalCost+productsMap.get(boughtProducts.get(i)).countProducts();
        }
        System.out.println("Total sum: "+totalCost);
    }
    public void checkProduct(int key){

        if(productsMap.containsKey(key)){
            if(productsMap.get(key).getProduct()) {
                boughtProducts.add(key);
            }
        }else{
            System.out.println("Invalid bar-code");
        }
    }

}
