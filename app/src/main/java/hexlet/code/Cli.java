package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String greet() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = in.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }
}
