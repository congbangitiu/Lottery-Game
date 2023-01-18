import java.util.Scanner;
import static java.lang.System.out;

public class Entry {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int gameQuantity;
        Lottery lot = new Lottery();
        out.println("How many turns do you want to play ?");
        gameQuantity = input.nextInt();
        for(int i=1;i<=gameQuantity;i++){
            out.println("\nTURN "+i);
            lot.buyTicket();
            lot.printTicket();
            lot.jackpot();
            lot.checkWinner(); 
            lot.currentProfit();
        }
        out.println("\nAFTER "+gameQuantity+" TURNS:");
        lot.getNumberWin();
        if(lot.getFinalProfit()>0)
            out.println("-> You profit $"+lot.getFinalProfit());
        if(lot.getFinalProfit()<0)
            out.println("-> You lose $"+(0-lot.getFinalProfit()));
        if(lot.getFinalProfit()==0)
            out.println("-> You break even");
        input.close();
    }
}

