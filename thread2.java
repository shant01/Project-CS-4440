public class Thread2 extends Thread {
    private String cardNum;
    private String company;

    public Thread2(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCompany() {
        return this.company;
    }

    @Override
    public void run() {
        company = checkCompany(cardNum);
    }

    private String checkCompany(String number) {
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

}