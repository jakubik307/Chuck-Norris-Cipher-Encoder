package chucknorris;

import java.util.Scanner;

public class Main {

    public static String code() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        StringBuilder output = new StringBuilder();

        System.out.println("Input string:");

        input.append(scanner.nextLine());

        System.out.println("Encoded string:");

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
        System.out.println();
    }

    public static void decode() {
        System.out.println("Input encoded string:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] array = input.split(" ");
        StringBuilder binary = new StringBuilder();
        StringBuilder output = new StringBuilder();
        String digit = "a";
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                if (array[i].equals("00")) {
                    digit = "0";
                } else if (array[i].equals("0")) {
                    digit = "1";
                } else {
                    System.out.println("Encoded string is not valid.");
                    return;
                }
            } else {
                for (int j = 0; j < array[i].length(); j++) {
                    binary.append(digit);
                    counter++;
                }
            }
        }

        if (counter % 7 != 0) {
            System.out.println("Encoded string is not valid.");
            return;
        }

        for (int i = 0; i < binary.length(); i += 7) {
            int charCode = (Integer.parseInt(binary.substring(i, Math.min(binary.length(), i + 7)), 2));
            output.append((char) charCode);
        }

        System.out.println("Decoded string:");
        System.out.println(output);
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        String option;

        do {
            System.out.println("Please input operation (encode/decode/exit):");
            option = scanner.nextLine();

            switch (option) {
                case "encode" -> unaryCode(code());
                case "decode" -> decode();
                case "exit" -> System.out.println("Bye!");
                default -> System.out.printf("There is no '%s' operation\n", option);
            }

        } while (!option.equals("exit"));
    }

    public static void main(String[] args) {
        menu();
    }
}