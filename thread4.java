public class Thread4 extends Thread {
    private String cardNum;
    private int sum;

    public Thread4(String cardNum) {
        this.cardNum = cardNum;
    }

    public int getSum() {
        return this.sum;
    }

    @Override
    public void run() {
        this.sum = getSum(cardNum);
    }

    private int getSum(String number) {
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
}