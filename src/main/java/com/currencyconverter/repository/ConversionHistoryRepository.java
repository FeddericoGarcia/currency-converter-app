package main.java.com.currencyconverter.repository;

import java.util.ArrayList;
import java.util.List;

public class ConversionHistoryRepository {
    private static List<String> history;

    public ConversionHistoryRepository() {
        this.history = new ArrayList<>();
    }

    public static void saveConversion(String fromCurrency, String toCurrency, double amount, double result) {
        String record = "$"+ amount + " " + fromCurrency + " → $" + result + " " + toCurrency;
        history.add(record);
    }

    public List<String> getHistory() {
        return history;
    }
}
