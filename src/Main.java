import java.util.Scanner;

public class Main {
    /**
     * @author Dominik Popowski
     *
     *
     */
    public static void main(String[] args) {
        ProductDatabase database=new ProductDatabase();
        database.databaseUpdate();
        Scanner scan=new Scanner(System.in);
        System.out.println("Podaj zeskanowany kod:");
        String code;
        while(true) {
            code = scan.next();
            System.out.println(code);
            if(code.equals("exit")) {
                database.showReceipt();
                break;
            }else {
            database.checkProduct(Integer.parseInt(code));
            }
        }

    }
}
