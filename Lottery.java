// import java.util.Random;
import java.util.Scanner;
import static java.lang.System.out;

public class Lottery {
    private int ticketType;
    public int[] userTicket = new int[6];
    public int[] winnerTicket = new int[6];
    private static int totalBuy=0;
    private static int totalWin=0;
    private static int[] countWin = new int[7];
    private final static int ticketPrice=4;
    public static final int min=1;
    public static final int max=49;
    Ticket random = new Ticket();
    Scanner input = new Scanner(System.in);
    

    public void inputTicket(){
        do {
            out.print("Enter your own 6 numbers (1 to 49): ");
            for(int i=0;i<userTicket.length;i++){
                userTicket[i]=input.nextInt();
            }
        } while (!random.checkValidTicket(userTicket));    
    }

    public int buyTicket(){
        out.println("Do you want to pick your own ticket numbers ? (1.Yes  2.No)");
        out.print("You choose: ");
        ticketType = input.nextInt();
        // ticketType=2;
        if (ticketType == 1){
            totalBuy-=ticketPrice;
            inputTicket();
        }
        else if(ticketType == 2){
            totalBuy-=ticketPrice;
            random.randomNumbers(userTicket);
        }
        else {
            out.println("Your choice is invalid !!! Choose again");
            buyTicket();
        }
        return totalBuy;
    }

    public void printTicket(){
        out.print("Your ticket is: ");
        random.printTicket(userTicket);
    }
    
    // print out the winning ticket
    public void jackpot() {
        out.print("\nThe winning ticket is: ");
        random.randomNumbers(winnerTicket);
        random.printTicket(winnerTicket);
    }


    public void checkWinner(){
        int countMatch=0;
        for(int i=0;i<6;i++){
            if(winnerTicket[i]==userTicket[i])
                countMatch++;
        }
        out.println("\nYour ticket has matched "+countMatch+" number(s)");
        switch(countMatch){
            case 0:
                out.println("Better luck next time !");
                countWin[0]++;
                break;
            case 1:
                out.println("Congratulations! You have won $10");
                countWin[1]++;
                totalWin+=10;
                break;
            case 2:
                out.println("Congratulations! You have won $10");
                countWin[2]++;
                totalWin+=10;
                break;
            case 3: 
                out.println("Congratulations! You have won $100");
                countWin[3]++;
                totalWin+=100;
                break;
            case 4:
                out.println("Congratulations! You have won $1000");
                countWin[4]++;
                totalWin+=1000;
                break;
            case 5:
                out.println("Congratulations! You have won $5000");
                countWin[5]++;
                totalWin+=5000;
                break;
            case 6:
                out.println("Congratulations! You have won $5 million");
                countWin[6]++;
                totalWin+=5000000;
                break;
        }
    }

    // print out the current profit
    public void currentProfit(){
        out.println("The total money won is: $"+totalWin);
        out.println("The total ticket cost is: $"+(0-totalBuy));
        out.println("Your current profit/loss is: $"+(totalBuy+totalWin));
    }

    // print out the final profit
    public int getFinalProfit(){
        int profit=totalBuy+totalWin;
        return profit;
    }

    // print out the number of winning turns (match at least 1 number)
    public void getNumberWin(){
        out.println("  The number of games matched 0 number is: "+countWin[0]);
        out.println("  The number of games matched 1 number is: "+countWin[1]);
        out.println("  The number of games matched 2 numbers is: "+countWin[2]);
        out.println("  The number of games matched 3 numbers is: "+countWin[3]);
        out.println("  The number of games matched 4 numbers is: "+countWin[4]);
        out.println("  The number of games matched 5 numbers is: "+countWin[5]);
        out.println("  The number of games matched all 6 numbers is: "+countWin[6]); 
    }
}