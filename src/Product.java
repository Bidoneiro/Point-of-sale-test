import java.io.BufferedReader;
import java.io.IOException;

public class Product {
    private String name;
    private int quantity;
    private float cost;

    public Product(){
        name="empty";
        quantity=0;
        cost=0;
    }
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
    public float countProducts() {
        System.out.print("Product: " + name);
        System.out.println("  Price: " + cost);
        return cost;
    }
    public void showProduct(){
        System.out.print("Product: "+name);
        System.out.println("  Price: "+cost);
    }
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
}
