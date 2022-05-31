import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int row,col;
        Scanner sc = new Scanner(System.in);
        System.out.println("Mayın tarlası için alan giriniz.");
        System.out.print("Row : ");
        row = sc.nextInt();
        System.out.print("Col : ");
        col = sc.nextInt();
        MineSwipper mineSwipper = new MineSwipper(row,col);
        mineSwipper.run();
    }
}
