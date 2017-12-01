class NimInputControllerTest {
    static NimInputController nim = new NimInputController();
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