package designPattern.ObserverPattern;

import java.text.DecimalFormat;

/**
 * Created by piyush.bajaj on 12/02/17.
 * How to use threads in Observer pattern?
 */
public class GetTheStock implements Runnable {

    private int startTime;
    private String stock;
    private double price;

    private Subject stockGrabber;

    public GetTheStock(Subject stockGrabber, int newStartTime, String newStock, double newPrice) {
        this.stockGrabber = stockGrabber;
        this.startTime = newStartTime;
        this.stock = newStock;
        this.price = newPrice;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            double randNum = (Math.random() * 0.06) - 0.03;
            DecimalFormat df = new DecimalFormat("#.##");
            price = Double.valueOf(df.format(price + randNum));

            if (stock == "IBM") {
                ((StockGrabber) stockGrabber).setIbmPrice(price);
            }

            if (stock == "Apple") {
                ((StockGrabber) stockGrabber).setApplPrice(price);
            }

            if (stock == "Google") {
                ((StockGrabber) stockGrabber).setGoogPrice(price);
            }

            System.out.println(stock + ": " + df.format(price + randNum) + " " + df.format(randNum));

            System.out.println();
        }
    }
}
