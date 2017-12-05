public class NimInputController {
    public String getInputFromDialogBox(String message){
        return "";
    }
    public String getUsername(){
        return "";
    }
    public boolean binaryChoice(String question){//This handles a binary choice, like hard mode or keep playing
        return true;
    }
    public boolean isHardMode(){
        return binaryChoice("Do you want to play hard mode?");
    }

    public int tokensChoice(int currentTokensAmount){
        return 0;
    }

    public boolean wantsToKeepPlaying(){
        return true;
    }
}
