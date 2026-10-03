import java.util.Scanner;

public class WaterBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter water consumption in litres: ");
        double consumption = sc.nextDouble();

        double bill;

        if (consumption <= 500) {
            bill = 150;
        } else {
            bill = 300;
        }

        System.out.println("Water Bill: Rs." + bill);

        sc.close();
    }
}
