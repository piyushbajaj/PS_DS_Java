package OnlineTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by piyush.bajaj on 13/02/17.
 */
public class StocksExecution {
    public Stocks stocksList[];

    HashMap<String, Stocks> hash = new HashMap<>();

    private int stocksCount;
    private int stkCount;

    public StocksExecution(int numOfStocks) {
        stkCount = numOfStocks + 1;
        stocksList = new Stocks[stkCount];

        stocksCount = 1;
    }

    public static void main(String[] args) {
        //Please specify the number of Stock_Id's here
        int noOfStockIds = 5;
        StocksExecution SE = new StocksExecution(noOfStockIds);

        String csvFile = "/Users/piyush.bajaj/Documents/SOES/input.csv";
        String line = "";
        String cvsSplitBy = ",";

        int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }

                String[] stocks = line.split(cvsSplitBy);


                SE.addStocks((Integer.valueOf(stocks[0])), stocks[1], stocks[2], (Integer.valueOf(stocks[3])));

            }
            SE.printList();
            SE.hash.clear();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStocks(int stockId, String side, String company, int quantity) {

        if (hash.containsKey(company)) {
            if (!side.equals(hash.get(company).side)) {
                int diff = quantity - hash.get(company).leftQuantity;
                if (diff >= 0) {
                    stocksList[hash.get(company).stockId] =
                        new Stocks(hash.get(company).stockId, hash.get(company).side,
                            hash.get(company).company_name, hash.get(company).quantity, 0, "CLOSED");
                    stocksList[stocksCount++] = new Stocks(stockId, side, company, quantity, diff, "OPEN");
                    hash.put(company, new Stocks(stockId, side, company, quantity, diff, "OPEN"));
                } else {
                    stocksList[hash.get(company).stockId] =
                        new Stocks(hash.get(company).stockId, hash.get(company).side,
                            hash.get(company).company_name, hash.get(company).quantity, Math.abs(diff), "OPEN");
                    stocksList[stocksCount++] = new Stocks(stockId, side, company, quantity, 0, "CLOSED");
                    hash.put(company,
                        new Stocks(hash.get(company).stockId, hash.get(company).side, hash.get(company).company_name,
                            hash.get(company).quantity, Math.abs(diff), "OPEN"));
                }
            } else {
                stocksList[hash.get(company).stockId] = new Stocks(hash.get(company).stockId, hash.get(company).side,
                    hash.get(company).company_name, hash.get(company).quantity, 0, "CLOSED");
                stocksList[stocksCount++] = new Stocks(stockId, side, company, quantity, quantity +
                    hash.get(company).leftQuantity,
                    "OPEN");
                hash.put(company, new Stocks(stockId, side, company, quantity, quantity +
                    hash.get(company).leftQuantity, "OPEN"));
            }
        } else {
            hash.put(company, new Stocks(stockId, side, company, quantity, quantity, "OPEN"));
            stocksList[stocksCount++] = new Stocks(stockId, side, company, quantity, quantity, "OPEN");
        }
    }

    public void printList() {
        for (int i = 1; i < stocksCount; i++) {
            System.out.println("Stock Id: " + stocksList[i].stockId + ", Side: " + stocksList[i].side + ", Company: " +
                stocksList[i].company_name + ", Quantity: " + stocksList[i].quantity + ", Remaining Quantity: " +
                stocksList[i].leftQuantity + ", Status: " + stocksList[i].status);
        }
    }

    public class Stocks {
        public int stockId;
        public String side;

        public String company_name;
        public int quantity;
        public int leftQuantity;
        public String status;


        public Stocks(int stockId, String side, String name, int quantity, int leftQuantity, String status) {
            this.stockId = stockId;
            this.side = side;
            this.company_name = name;
            this.quantity = quantity;
            this.leftQuantity = leftQuantity;
            this.status = status;
        }
    }
}

//        SE.addStocks(1, "Buy", "ABC", 10);
//        SE.addStocks(2, "Sell", "XYZ", 15);
//        SE.addStocks(3, "Sell", "ABC", 13);
//        SE.addStocks(4, "Buy", "XYZ", 10);
//        SE.addStocks(5, "Buy", "XYZ", 8);


//SE.printList();