public interface NimInputController {
    public String getInput(String message);
    public String getUsername();
    public boolean binaryChoice(String question);
    public boolean isHardMode();

    public int tokensChoice(int currentTokensAmount);

    public boolean wantsToKeepPlaying();

    public void messageUser(String message);
}
