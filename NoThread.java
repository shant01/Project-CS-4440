//No Threads
import java.util.Scanner;
public class NoThread {
    public static void main(String[] args) {
        // Ask user for input

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a card number between 13 and 19 digits: ");
        String cardNum = input.next();

        long start = System.currentTimeMillis();

        String company = "";
        if (step1(cardNum) == true) {
            company = step2(cardNum);
        } else {
            while (step1(cardNum) == false) {
                System.out.println("Enter a card number between 13 and 19 digits: ");
                cardNum = input.next();
                step1(cardNum);
            }
            company = step2(cardNum);
        }
        input.close();
        System.out.println("Company: " + company);
        int sum;
        if (company != "") {
            // Step 5: Sum results of step 3 and 4
            sum = step3(cardNum) + step4(cardNum);

            validationStep(sum, company);
        }

        long end = System.currentTimeMillis();

        System.out.println("This program executed for " + (end - start) + "ms");
    }

    // Step 1: Obtain a credit card number
    public static boolean step1(String cardNum) {
        boolean isValid = false;
        int length = cardNum.length();
        System.out.println(length);
        if (length >= 13 && length <= 19) {
            isValid = true;
        } else {
            System.out.println("Card is invalid.");
        }

        return isValid;
    }

    // Step 2: Check if it starts with major industry identifier
    public static String step2(String cardNum) {
        String firstDigit = cardNum.substring(0, 1);
        int firstNum = Integer.parseInt(firstDigit);
        String company = "";
        System.out.println("FirstNum: " + firstNum);
        switch (firstNum) {
            // 3 for AMEX
            case 3:
                company = "AMEX";

            // Discover
            case 6:
                company = "Discover";

            // 5 for Mastercard
            case 5:
                company = "MasterCard";

            // 4 for Visa
            case 4:
                company = "Visa";

            default:
                System.out.println("This is an invalid card number.");
        }

        System.out.println(company);
        return company;
    }

    // Step 3: Double every second digit from right to left. Add all single digit
    // numbers
    public static int step3(String cardNum) {
        int sum = 0;

        for (int i = cardNum.length() - 2; i >= 0; i -= 2) {
            int digit = Integer.parseInt(cardNum.substring(i, i + 1)) * 2;
            if (digit < 10) {
                sum += digit;
            } else {
                int secondDigit = digit % 10;
                digit /= 10;
                digit += secondDigit;
                sum += digit;
            }
        }
        return sum;
    }

    // Step 4: Add all odd digits from right to left
    public static int step4(String cardNum) {
        int sum = 0;

        for (int i = cardNum.length() - 1; i >= 0; i -= 2) {
            int digit = Integer.parseInt((cardNum.substring(i, i + 1)));
            if (digit < 10) {
                sum += digit;
            } else {
                int secondDigit = digit % 10;
                digit /= 10;
                digit += secondDigit;
                sum += digit;
            }
        }

        return sum;
    }

    // Step 6: Check if result of step 5 is divisible by 10 to0 see if it is valid
    public static void validationStep(int result, String company) {
        if (result % 10 == 0) {
            System.out.println("This card is valid\nThis is a(n) " + company);
        } else {
            System.out.println("The card is an invalid card number. Cannot be processed.");
        }
    }
}