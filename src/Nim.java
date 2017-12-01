import java.util.Random;
public class Nim {
    private String username;
    private int tokens;
    private boolean hardMode;
    private NimInputController nimInput;
    private boolean humanWin;
    private boolean currentPlayerIsHuman;
    private int totalGames = 1;

    public Nim(String username, boolean hardMode){
        this.hardMode = hardMode;
        //Get Hardmode from the user

        Random rand = new Random();
        int randTokens = rand.nextInt(100)+1;
        this.tokens = randTokens;
        this.username = username;
        init();
    }

    //Initializes the game with whoever is supposed to move first
    private void init(){
        Random rand = new Random();
        boolean firstPlayerIsHuman = rand.nextBoolean();
        currentPlayerIsHuman = firstPlayerIsHuman;
        if(!firstPlayerIsHuman){
            botRound(); //If the first move is for the bot, give it a special move at the start
        } else{
            playRound(); //If the first move is for the human, play a round normally
        }
    }

    private void botRoundEasy(){

    }

    private void botRoundHard(){

    }

    private void botRound(){
        if(hardMode){
            botRoundHard();
        } else{
            botRoundEasy();
        }
    }
    private void humanRound(){
        int choice = nimInput.tokensChoice(tokens);
        tokens -= choice;
    }

    private void playRound(){
        currentPlayerIsHuman = true;
        humanRound();
        if(tokens>0){
            botRound(); //Ensures bot doesn't get to play if the tokens are gone
            currentPlayerIsHuman = false; //Current player is bot
        }
    }

    private void playGame(){ //This plays a single game of Nim
        while(tokens>0){
            playRound();
        }
    }

    private void playGames(){

    }
}
