package mains03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Value: ");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        ErrorOrResult eor = parseIntOrFail(s);
        if (eor.failed()) {
            System.out.println("Failed to read integer value!");
            System.out.println("error: " + eor.error());
        } else {
            System.out.println("Successfully read " + eor.result());
        }
    }

    static ErrorOrResult parseIntOrFail(String input) {
        try {
            int x = Integer.parseInt(input);
            return ErrorOrResult.success(x);
        } catch (Exception e) {
            return ErrorOrResult.failed(e.getMessage());
        }
    }
}
