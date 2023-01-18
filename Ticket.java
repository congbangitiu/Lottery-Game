import java.util.Random;
import java.util.Arrays;
import static java.lang.System.out;


public class Ticket {
    Random random = new Random();
    //check if the user enters a number between 1 and 49
    public boolean checkValidTicket(int[] ticket){
        for(int i=0;i<ticket.length;i++){
            if(ticket[i]<Lottery.min || ticket[i]>Lottery.max){
                out.println("Number in the "+(i+1)+" position is not valid !!! Please input again !");
                // break;
                return false;
            }
        }
        return true;
    }

    public void printTicket(int[] ticket){
        Arrays.sort(ticket);
        for(int i=0;i<ticket.length;i++)
            out.print(ticket[i]+" ");
    }

    // random 6 numbers do not coincide
    public void randomNumbers(int[] ticket) {
        int cur = 0;
        int remaining = Lottery.max;
        int count = 6;
        for (int i = Lottery.min; i <= Lottery.max; i++) {
            double probability = random.nextDouble();
            if (probability < ((double) count) / (double) remaining) {
                count--;
                ticket[cur++] = i;
            }
            remaining--;
        }          
    }
    
}