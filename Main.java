package chucknorris;

import java.util.Scanner;

public class Main {

    public static void addSpace() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        input.append(scanner.nextLine());

        for (int i = 0; i < input.length(); i++) {
            System.out.print(input.charAt(i));
            if (i != input.length() - 1) System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Input string: ");
        addSpace();
    }
}