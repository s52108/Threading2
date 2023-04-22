package campus02;

import java.io.IOException;

public class ClockDemo {
    public static void main(String[] args) {
        DateTimePrinterBackgroundWorker backgroundWorker = new DateTimePrinterBackgroundWorker();

        Thread th = new Thread(backgroundWorker);
        th.start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //th.run() Achtung - startet keinen Thread

        backgroundWorker.setShouldRun(false);

        try {
            th.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
