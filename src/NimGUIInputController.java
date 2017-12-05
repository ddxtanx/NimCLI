
import javax.swing.*;

public class NimGUIInputController implements NimInputController{
        public String getInput(String message){
            return JOptionPane.showInputDialog(message);
        }
        public String getUsername(){
            String name = getInput("Please enter your name:");
            return name;
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
            String strChoice = getInput("There are currently " + currentTokensAmount + " tokens\n How many tokens do you want to take? [Inbetween 1 and " + (currentTokensAmount/2)+"]");
            try{
                choice = Integer.parseInt(strChoice);
            }catch(NumberFormatException n){
                strChoice = getInput("Nice try, but it'll take more to fool me!" +
                                "There are currently " + currentTokensAmount + " tokens\n" +
                        "How many tokens do you want to take? [Inbetween 1 and " + (currentTokensAmount/2)+"]");
            }
            while(!(choice>0 && choice <= currentTokensAmount/2)){
                strChoice = getInput("Invalid choice, how many tokens do you want to take? [Inbetween 1 and " + (currentTokensAmount/2)+"]");
                try{
                    choice = Integer.parseInt(strChoice);
                }catch(NumberFormatException n){
                    JOptionPane.showMessageDialog(null, "Nice try, entering a non-number. Try harder to fool me ;)");
                }
            }
            return choice;
        }

        public boolean wantsToKeepPlaying(){
            return binaryChoice("Do you want to keep playing?");
        }
}
