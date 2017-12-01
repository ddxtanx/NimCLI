import java.util.Scanner;
public class NimInputController {
    private Scanner scan = new Scanner(System.in);
    public String getUsername(){
        System.out.println("Please enter your name: ");
        String name = scan.nextLine();
        return name;
    }
    public boolean binaryChoice(String question){//This handles a binary choice, like hard mode or keep playing
        String choice = "";
        while(!(choice.toLowerCase().equals("yes") || choice.toLowerCase().equals("no"))) {
            System.out.println(question + " (Please input Yes or No)");
            choice = scan.nextLine();
        }
        return choice.toLowerCase().equals("yes"); //If the user inputs yes, the user affirms the binary choice, return true. Else return false
    }
    public boolean isHardMode(){
        return binaryChoice("Do you want to play hard mode?");
    }

    public int tokensChoice(int currentTokensAmount){
        int choice = 0;
        System.out.println("How many tokens do you want to take? [Inbetween 1 and " + (currentTokensAmount/2)+"]");
        String strChoice = scan.nextLine();
        try{
            choice = Integer.parseInt(strChoice);
        }catch(NumberFormatException n){
            System.out.println("Nice try, entering a non-number. Try harder to fool me ;)");
        }
        while(!(choice>0 && choice <= currentTokensAmount/2)){
            System.out.println("Invalid choice, how many tokens do you want to take? [Inbetween 1 and " + (currentTokensAmount/2)+"]");
            strChoice = scan.nextLine();
            try{
                choice = Integer.parseInt(strChoice);
            }catch(NumberFormatException n){
                System.out.println("Nice try, entering a non-number. Try harder to fool me ;)");
            }
        }
        return choice;
    }

    public boolean wantsToKeepPlaying(){
        return binaryChoice("Do you want to keep playing?");
    }
}
