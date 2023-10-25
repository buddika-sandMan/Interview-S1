import java.util.Scanner;

public class Example {
    public static void main(String[] args) {

        //data array
        String[] itemCode = {"Item001","Item002","Item003"};
        String[] itemName = {"Coca-Cola","Pepsi","Sprite"};
        double[] unitPrice = {25,35,45};
        int[] availableUnits = {30,10,20};

        Scanner input = new Scanner(System.in);

        //view item list
        System.out.println("Item Code\tTitem Name\tAvailable Units\tUnit Price");
        for (int i=0; i<itemCode.length; i++){
            System.out.println(itemCode[i] + "\t" + itemName[i] + "\t" + availableUnits[i] + "\t" + unitPrice[i]);
        }

        //input an item and number of units
        System.out.println("Enter Item Code");
        String selectItem = input.nextLine();
        int selectNo = -1;

        for (int i=0; i<itemCode.length;i++){
            if(itemCode[i].equals(selectItem)){
                selectNo=i;
                break;
            }
        }

        if (selectNo==-1){
            System.out.println("Invalid Item, please enter correct Item...");
            return;
        }

        System.out.println("Enter the unit count");
        int unitQty = input.nextInt();

        if (unitQty>availableUnits[selectNo]){
            System.out.println("Error, No stocks");
            return;
        }

        //find totla price
        double totalPrice= unitQty * unitPrice[selectNo];
        System.out.println("Total price : Rs." + totalPrice + "/=" );

        //user confirmation
        System.out.println("Confirm your order(Y/N)");
        String confirmation = input.next();

        if(confirmation.equalsIgnoreCase("Y")){
            System.out.println("Enter payment amount");
            double payAmount = input.nextInt();

            //check amount
            if(payAmount < totalPrice){
                System.out.println("Please enter correct amount");
            } else {
                double balance = payAmount - totalPrice;
                System.out.println("Payment completed");
                System.out.println("Balance is Rs" + balance + "/=");
            }
        } else {
            System.out.println("Order is cancled");
        }

        input.close();

    }
}