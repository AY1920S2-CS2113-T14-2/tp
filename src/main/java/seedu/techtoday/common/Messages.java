package seedu.techtoday.common;

import org.jetbrains.annotations.NotNull;

public class Messages {
    public static String SPLIT_LINE = "______________________________________________________________";


    public static String LINE = "     ______________________________________________" +
            "____________________________________";

      /** Let the statement be printed in center. **/
    public static void printInCenter(@NotNull String str) {
        int left = (83 - str.length()) / 2;
        int right = 83 - left - str.length();
        String repeatedChar = " ";
        String buff = "\t∣"
                + repeatedChar.repeat(Math.max(0, left))
                + str
                + repeatedChar.repeat(Math.max(0, right - 1))
                + "∣";
        System.out.println(buff);
    }

    /** Show a ASCII code message to user. **/
    public static void greet() {
        System.out.println(LINE);
        printInCenter("");
        printInCenter("Hello! Here's TechToday.");
        printInCenter("Let me show you some technology news to refresh your mind!");
        printInCenter(SPLIT_LINE);
        printInCenter("Your queries can be of the following forms:");
        printInCenter("1. view [article / job]");
        printInCenter("2. list [article / job / note]");
        printInCenter("3. save [article / job / note] [index number (optional)]");
        printInCenter("4. delete [article / job / note] [index number]");
        printInCenter("5. addinfo [article / job / note] [index number] [extract]");
        printInCenter("6. create [article / job / note]");
        printInCenter("7. exit");
        printInCenter("");
        System.out.println(LINE);
        System.out.println("     What can I do for you?");
        System.out.println();
    }
}
