class NimInputControllerTest {
    static NimInputController nim = new NimCLIController();
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
        if(args.length>0 && args[0].equals("-g")){
            nim = new NimGUIController();
        }
        getUsername();
        isHardMode();
        tokensChoice();
    }
}