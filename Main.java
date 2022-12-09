package chucknorris;

import java.util.Scanner;

public class Main {

    public static String decode() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        StringBuilder output = new StringBuilder();

        input.append(scanner.nextLine());

        System.out.println("The result:");

        for (int i = 0; i < input.length(); i++) {
            output.append(String.format("%7s", Integer.toBinaryString(input.charAt(i))).replace(" ", "0"));
        }
        return output.toString();
    }

    public static void unaryCode(String s) {
        int digit;
        int counter = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                counter++;
            } else {
                digit = s.charAt(i);
                if (digit == '0') {
                    System.out.print("00 ");
                } else if (digit == '1') {
                    System.out.print("0 ");
                }

                for (int j = 0; j < counter + 1; j++) {
                    System.out.print("0");
                }
                System.out.print(" ");
                counter = 0;
            }
        }
        if (s.charAt(s.length() - 1) == '0') {
            System.out.print("00 ");
        } else if (s.charAt(s.length() - 1) == '1') {
            System.out.print("0 ");
        }
        for (int j = 0; j < counter + 1; j++) {
            System.out.print("0");
        }
    }

    public static void main(String[] args) {
        System.out.println("Input string: ");

        unaryCode(decode());
    }
}