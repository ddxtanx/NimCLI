import java.util.Random;
public class Nim {
    private String username;
    private int tokens;
    private boolean hardMode;
    private NimInputController nimController;
    private boolean humanWin;
    private boolean currentPlayerIsHuman;
    private int totalGames = 0;
    private int humanWins = 0;
    private boolean isGUI;

    public Nim(String args[]){
        if(args.length>0){
            if(args[0].equals("-g")){
                nimController = new NimGUIController();
                isGUI = true;
            }else{
                nimController = new NimCLIController();
                isGUI = false;
            }
        } else{
            nimController = new NimCLIController();
            isGUI = false;
        }
        this.username = nimController.getUsername();
        init();
    }
    //Initializes the game with whoever is supposed to move first
    private void init(){
        Random rand = new Random();
        int randTokens = rand.nextInt(100)+1; //Gets token amount
        this.tokens = randTokens; //Sets the tokenAmount

        nimController.messageUser("The game starts with " + tokens + " tokens.");
        boolean playingHardMode = nimController.isHardMode();
        this.hardMode = playingHardMode; //Determines and sets hardMode

        boolean firstPlayerIsHuman = rand.nextBoolean();
        currentPlayerIsHuman = firstPlayerIsHuman; //Sets first player

        if(!firstPlayerIsHuman){
            nimController.messageUser("The computer has the first move.");
            botRound(); //If the first move is for the bot, give it a special move at the start

        } else{
            nimController.messageUser("You have the first move!");
            playRound(); //If the first move is for the human, play a round normally
        }
    }
    //These bot rounds return the amount of tokens the bot chose
    private int botRoundEasy(){
        Random rand = new Random();
        int choice = rand.nextInt(tokens/2)+1;//Bot chooses a number of tokens in between 1 and tokens/2[inclusive]
        return choice;
    }

    private int botRoundHard(){
        //The bot needs to get to a value of 2^n - 1 to be guaranteed a win
        //But if the value of tokens is already one less than a power of 2, it won't work
        //This code will find if tokens is one less than a power of 2 by
        //Examining log_2(tokens+1) and determining if it is an integer (with an epsilon of precision)
        //It is tokens+1 because tokens + 1 = (2^n - 1) + 1 = 2^n is a power of 2, so log_2(2^n) will
        //Be (will some epsilon of floating point error) an integer

        double epsilon = 1E-12; //Just a randomly chosen epsilon value
        double log2OfTokens = Math.log10(tokens + 1)/Math.log10(2); //This gets log2(tokens) by logarithm base change
        double decimalPart = log2OfTokens - Math.floor(log2OfTokens); //This gets the decimal part of log2OfTokens
        //For log2OfTokens to be an integer, it's decimalPart must be (within an epsilon of error) 0

        boolean unableToDoOptimalMove = Math.abs(decimalPart)<epsilon;
        if(unableToDoOptimalMove){
            return botRoundEasy();
        } else{
            int choice = tokens - (int)(Math.pow(2, (int)log2OfTokens) - 1); //Take enough tokens to get to a power of 2 minus 1
            if(choice < 1 || choice > tokens/2){
                System.out.println("Bot chose badly!");
                return 0;
            }
            return choice;
        }
    }

    private void botRound(){
        int botChoice;
        if(tokens == 1){
            botChoice = 1;
        } else if(hardMode){
            botChoice = botRoundHard();
        } else{
            botChoice = botRoundEasy();
        }
        tokens -= botChoice;
        currentPlayerIsHuman = true; //Human plays now
        nimController.messageUser("Bot takes " + botChoice + " tokens. \n" + "There are now " + tokens + " tokens.");
    }
    private void humanRound(){
        int choice = nimController.tokensChoice(tokens);
        tokens -= choice;
        currentPlayerIsHuman = false; //Bot plays now
        nimController.messageUser("There are now " + tokens + " tokens.");
    }

    private void playRound(){
        humanRound();

        if(tokens>0){
            botRound(); //Ensures bot doesn't get to play if the tokens are gone
        }
    }

    private void playGame(){ //This plays a single game of Nim
        while(tokens>0){
            playRound();
        }
        humanWin = currentPlayerIsHuman; //If the game ends on a human turn, meaning the previous turn the bot took the last token, the human won
        if(humanWin){
            nimController.messageUser("Congrats, " + username + "! You won this round!");
        } else{
            nimController.messageUser("Oof, " + username + ", you lost. Better luck next time!");
        }
    }

    public void playGames(){
        boolean stillPlaying = true;
        while(stillPlaying){
            playGame();
            if(humanWin) humanWins++;
            totalGames++;

            nimController.messageUser("The current record is\n" +
                         "\t Human: " + humanWins + "\n" +
                         "\t Computer: " + (totalGames-humanWins) + "\n");
            stillPlaying = nimController.wantsToKeepPlaying();
            if(stillPlaying) init();
        }
    }
}