package campus02;

import java.util.Date;
import java.util.Scanner;

public class ClockApp {

    private static boolean running = true;

    public static void main(String[] args) {
         // Start the background thread
        Thread clockThread = new Thread(() -> {
            while (running) {
                Date now = new Date();
                System.out.println(now);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Ignore
                }
            }
        });
        clockThread.start();

        // Wait for the user to press Enter
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        // Stop the background thread
        running = false;
        try {
            clockThread.join();
        } catch (InterruptedException e) {
            // Ignore
        }


    }
}