
import javax.swing.*;

public class NimGUIController implements NimInputController{
        public String getInput(String message){
            return JOptionPane.showInputDialog(null,message, "Game of Nim", JOptionPane.QUESTION_MESSAGE);
        }
        public String getUsername(){
            String name = getInput("Please enter your name:");
            return name;
        }
        public boolean binaryChoice(String question){//This handles a binary choice, like hard mode or keep playing
            String choice = "";
            Object[] options = {"Yes", "No"};
            int choiceInt = JOptionPane.showOptionDialog(null, question, "Game of Nim", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "Yes" );
            return choiceInt==0;
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
                strChoice = getInput("Nice try, but it'll take more to fool me!\n" +
                                "There are currently " + currentTokensAmount + " tokens\n" +
                        "How many tokens do you want to take? [Inbetween 1 and " + (currentTokensAmount/2)+"]\n");
            }
            while(( currentTokensAmount!= 1 && !(choice>0 && choice <= currentTokensAmount/2)) || (currentTokensAmount == 1 && choice!=1)){
                strChoice = getInput("There are currently " + currentTokensAmount + " tokens\n" +
                                "Invalid choice, how many tokens do you want to take? [Inbetween 1 and " + (currentTokensAmount/2)+"]");
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

    public void messageUser(String message){
            JOptionPane.showMessageDialog(null, message);
    }
}
