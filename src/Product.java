import java.io.BufferedReader;
import java.io.IOException;
/**
 * The Product class represents single object of a product contained in the database
 */
public class Product {
    private String name;
    private int quantity;
    private float cost;

    public Product(){
        name="empty";
        quantity=0;
        cost=0;
    }
    /**
     * getData is responsible for reading the database of a single product from text file
     */
    public Product getData(BufferedReader reader){
        try {
            name=reader.readLine();
            quantity=Integer.parseInt(reader.readLine());
            cost=Float.parseFloat(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;

    }

    public void showProduct(){
        System.out.print("Product: "+name);
        System.out.println("  Price: "+cost);
    }
    /**
     * getProduct signalizes if products is available. It returns true if product you can purchase the product and false if not.
     */
    public boolean getProduct(){
        if(quantity>0){
            showProduct();
            quantity--;
            return true;
        }else {
            System.out.println("Product not found");
            return false;
        }
    }
    /**
     * countsProducts displays purchased object and returns its cost
     */
    public float countProducts() {
        showProduct();
        return cost;
    }
}
