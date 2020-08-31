package com.example.product_microservice.model;

enum StockStatus {
    IN_STOCK,
    OUT_OF_STOCK
}

public class Stock {

    private int productId;
    private int stock;
    private StockStatus stockStatus;

    public Stock(int productId, int stock) {
        this.productId = productId;
        this.stock = stock;

        if (stock == 0) {
            this.stockStatus = StockStatus.OUT_OF_STOCK;
        }
        else {
            this.stockStatus = StockStatus.IN_STOCK;
        }
    }

    public int getProductId() {
        return productId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;

        if (this.stock == 0) {
            this.stockStatus = StockStatus.OUT_OF_STOCK;
        }
        else {
            this.stockStatus = StockStatus.IN_STOCK;
        }
    }

//    public void clearStock(){
//        this.stockStatus = StockStatus.OUT_OF_STOCK;
//    }
//
//    public void inStock() {
//        this.stockStatus = StockStatus.IN_STOCK;
//    }

    public StockStatus getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }
}
