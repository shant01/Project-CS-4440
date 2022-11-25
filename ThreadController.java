public class ThreadController {

    public static void main(String[] args) throws InterruptedException {
        // Start Timer
        long start = System.currentTimeMillis();
        for (int i = 0; i < args.length; i++) {
            
            String cardNum = (args[i]);
            // Create Threads
            // Thread 1
            Thread1 t1 = new Thread1(cardNum);
            t1.start();
            t1.join();
            // Thread 2
            Thread2 t2 = new Thread2(cardNum);
            t2.start();
            t2.join();
            // Thread 3
            Thread3 t3 = new Thread3(cardNum);
            t3.start();
            t3.join();
            Thread4 t4 = new Thread4(cardNum);
            t4.start();
            t4.join();

            // Start checks
            if (!t1.getIsValid()) {
                System.out.println("The number of digits provided for this card is invalid.");
            } else {
                // Results from step 3 and 4
                int result = t3.getSum() + t4.getSum();
                String company = t2.getCompany();
                // Start thread 5 for final output
                Thread5 t5 = new Thread5(result, company);
                t5.start();
                t5.join();

            }

            System.out.println("----------------------------------------------------------\n\n");
        }

        long end = System.currentTimeMillis();
        System.out.println("This program executed for " + (end - start) + "ms\n\n");

    }
}