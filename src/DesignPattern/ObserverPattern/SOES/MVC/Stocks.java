package DesignPattern.ObserverPattern.SOES.MVC;

/**
 * Created by piyush.bajaj on 12/02/17.
 */
public class Stocks {
    private int stockId;
    private String side;
    private String company;
    private int quantity;
    private int leftQuantity;
    private String status;

    public int getStockid() {
        return stockId;
    }

    public void setStockid(int newStockId) {
        this.stockId = newStockId;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String newSide) {
        this.side = newSide;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String newCompany) {
        this.company = newCompany;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }


    public void calculateStocks(int stockId, String side, String company, int quantity) {
        if (side.equalsIgnoreCase("buy")) {
            if (this.company.equalsIgnoreCase(company)) {

            }
        }
    }

}
