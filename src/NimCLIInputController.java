import java.util.Scanner;
public class NimCLIInputController implements NimInputController{
    private Scanner scan = new Scanner(System.in);
    public String getInput(String message){
        System.out.println(message);
        return scan.nextLine();
    }
    public String getUsername(){
        return getInput("Please enter your name: ");
    }
    public boolean binaryChoice(String question){//This handles a binary choice, like hard mode or keep playing
        String choice = "";
        while(!(choice.toLowerCase().equals("yes") || choice.toLowerCase().equals("no"))) {
            choice = getInput(question + " (Please input Yes or No)");
        }
        return choice.toLowerCase().equals("yes"); //If the user inputs yes, the user affirms the binary choice, return true. Else return false
    }
    public boolean isHardMode(){
        return binaryChoice("Do you want to play hard mode?");
    }

    public int tokensChoice(int currentTokensAmount){
        int choice = 0;
        String strChoice = getInput("How many tokens do you want to take? [Inbetween 1 and " + (currentTokensAmount/2)+"]");
        try{
            choice = Integer.parseInt(strChoice);
        }catch(NumberFormatException n){
            System.out.println("Nice try, entering a non-number. Try harder to fool me ;)");
        }
        while(( currentTokensAmount!= 1 && !(choice>0 && choice <= currentTokensAmount/2)) || (currentTokensAmount == 1 && choice!=1)){
            strChoice = getInput("Invalid choice, how many tokens do you want to take? [Inbetween 1 and " + (currentTokensAmount/2)+"]");
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
