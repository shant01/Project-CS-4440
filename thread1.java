public class thread1 extends Thread {

    private String cardNum;
    private boolean isValid;

    public thread1(String cardNum) {
        this.cardNum = cardNum;
    }

    public boolean getIsValid() {
        return isValid;
    }

    @Override
    public void run() {
        this.isValid = isValidNum(cardNum);
    }

    private boolean isValidNum(String cardNum) {
        boolean isValid = false;
        int length = cardNum.length();
        if (length >= 13 && length <= 19) {
            isValid = true;
        } else {
            System.out.println("Card is invalid.");
        }
        return isValid;
    }

}