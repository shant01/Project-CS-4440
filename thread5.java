public class thread5 extends Thread {
    private int sum;
    private String company;

    public thread5(int sum, String company) {
        this.sum = sum;
        this.company = company;

    }

    @Override
    public void run() {
        checkIsValid(sum, company);
    }

    private void checkIsValid(int number, String company) {
        if (number % 10 == 0) {
            System.out.println("This card is valid\nThis is a(n) " + company);
        } else {
            System.out.println("The card is an invalid card number. Cannot be processed.");
        }
    }
}