package problem1;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {

    public boolean isAnagram(String s1, String s2){

        if (s1.length() != s2.length()){
            return false;
        }

        char[] a1 = s1.toLowerCase().toCharArray();
        char[] a2 = s2.toLowerCase().toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);

        return Arrays.equals(a1, a2);
    }

    private void startCheck(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please provide two strings to compare and check if it's an anagram.");
        System.out.print("First string: ");
        String input1 = scan.nextLine().trim();
        System.out.print("second string: ");
        String input2 = scan.nextLine().trim();

        if(isAnagram(input1, input2)){
            System.out.println("The strings: " + "\"" + input1 + "\""
                    + " and " + "\"" + input2 + "\""
                    + " was an anagram.");
        } else {
            System.out.println("The string: " + "\"" + input1 + "\""
                    + " and " + "\"" + input2 + "\""
                    + " was not an anagram.");
        }
        scan.close();
    }

    public static void main(String[] args) {
        AnagramCheck annCheck = new AnagramCheck();
        annCheck.startCheck();
    }

}
