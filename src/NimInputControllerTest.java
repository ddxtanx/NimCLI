class NimInputControllerTest {
    static NimCLIInputController nim = new NimCLIInputController();
    static void getUsername() {
        System.out.println(nim.getUsername());
    }

    static void isHardMode() {
        System.out.println(nim.isHardMode());
    }

    static void tokensChoice() {
        System.out.println(nim.tokensChoice(50));
    }

    public static void main(String[] args) {
        getUsername();
        isHardMode();
        tokensChoice();
    }
}