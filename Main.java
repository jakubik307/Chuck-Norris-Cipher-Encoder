package chucknorris;

import java.util.Scanner;

public class Main {

    public static void decode() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        input.append(scanner.nextLine());

        System.out.println("The result:\n");

        for (int i = 0; i < input.length(); i++) {
            System.out.printf("%c = %s", input.charAt(i), String.format("%7s", Integer.toBinaryString(input.charAt(i))).replace(" ", "0"));
            if (i != input.length() - 1) System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Input string: ");
        decode();
    }
}