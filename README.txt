For this game, I tried to encapsulate as much as possible. I also made a small test for the NimInputControllers,
just to make sure that they were returning the correct values. I used an Interface for NimInputController because I
wanted Nim to run in either CLI or GUI mode, and that distinction is made by passing a command line argument
when running Main.java ("-g" for graphics mode). I also tried to encapsulate functions as much as possible,
and I tried to create a hierarchy where the Games function calls the Game function which calls the Round function, etc etc.
