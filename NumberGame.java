import java.util.Scanner;
import java.util.Random;

public class NumberGame 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        Random random=new Random();
        int maxAttempts=6;
        int roundswon=0;
        boolean playagain=true;

        while(playagain)
        {
            System.out.println("Select the number between 1 to 100");
            int randomNum=random.nextInt(100)+1;
            int attempts=0;

            while(attempts < maxAttempts)
            {
                System.out.print("Enter user guess: ");
                int userNum=sc.nextInt();
                attempts++;
                if (userNum < randomNum) 
                    System.out.println("Too low!");
                else if(userNum > randomNum)
                    System.out.println("Too high!");
                else
                {
                    System.out.println("You have guessed right in " + attempts + " attempts!!" );
                    roundswon++;
                    break;
                }
            }

            if(attempts == maxAttempts)
                System.out.println("You have reached maximum no. of attempts!! Generated no. is " + randomNum);

            System.out.println("Do you want to play again (yes/no)? ");
            String input=sc.next().toLowerCase();
            playagain=input.equals("yes");
        }
        System.out.println("Rounds won: " + roundswon);
    }
}
