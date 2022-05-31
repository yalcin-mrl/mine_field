import java.util.Random;
import java.util.Scanner;

public class MineSwipper {
    int row;
    int col;
    MineSwipper(int row, int col){
        this.row = row;
        this.col = col;
    }
    void run(){
        Scanner input = new Scanner(System.in);
        int rowSelected = 0,colSelected = 0,count =0,sumMine = 0;
        int countWin = 0;
        Random random = new Random();
        int mine[][] = new int[this.row][this.col];
        int mineCord[][] = new int[this.row][this.col];

        System.out.println("Mayın Tarlası oyununa hoşggeldiniz! ");
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                int rnd = random.nextInt(2);
                System.out.print("-\t");
                mine[i][j] = 0;
                if(rnd != 0){
                    if(count <(row*col/4)){
                        mine[i][j] = 1;
                        count++;
                    }else{
                        mine[i][j] = 0;

                    }
                }
                else{
                    mine[i][j] = 0;
                }
            }
            System.out.println(" ");
        }
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                System.out.print(mine[i][j] + "\t");
            }
            System.out.println(" ");
        }

        boolean isTrue =true,isFind = false;

        while(!isFind){

            sumMine = 0;
            while(isTrue){
                System.out.print("Satır giriniz: ");
                rowSelected = input.nextInt();
                System.out.print("Sütun giriniz: ");
                colSelected = input.nextInt();
                if(rowSelected <= row && colSelected <= col && rowSelected >= 0 && colSelected >= 0){
                    isTrue = false;
                }
             }
            if(mine[rowSelected][colSelected] != 0){
                isFind = true;
                System.out.println("Game Over!!");
                System.out.println("Bilme sayısı : "+ countWin);
            }else{
                for(int i = rowSelected-1; i<=rowSelected+1;i++){
                    for(int j = colSelected -1;j<=colSelected +1;j++){
                        if(i<0 || j <0 || i>=row || j>=col)
                            continue;
                            if(mine[i][j] == 1){
                                sumMine++;
                            }
                    }
                }
                for(int i = 0;i<row;i++){
                    for(int j = 0;j<col;j++){
                        if(i == rowSelected && j == colSelected){
                            System.out.print(sumMine + "\t");
                            continue;
                        }
                        System.out.print("-\t");
                    }
                    System.out.println(" ");
                }
                isTrue = true;
            }
            countWin++;
        }
    }
}
