package main.java.com.currencyconverter.service;

import java.util.List;
import java.util.Map;

import main.java.com.currencyconverter.model.ExchangeRate;
import main.java.com.currencyconverter.exception.InvalidCurrencyException;
import main.java.com.currencyconverter.repository.ConversionHistoryRepository;

public class CurrencyConverterService {

    private static ExchangeRateService exchangeRateService;
    private static ConversionHistoryRepository conversionHistoryRepository;

    public CurrencyConverterService() {
        this.exchangeRateService = new ExchangeRateService();
        this.conversionHistoryRepository = new ConversionHistoryRepository();
    }

    public static double convert(String fromCurrency, String toCurrency, double amount) throws InvalidCurrencyException {
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRates(fromCurrency);
        Map<String, Double> rates = exchangeRate.getConversionRates();

        if (!rates.containsKey(toCurrency)) {
            throw new InvalidCurrencyException("⛔ Moneda inválida: " + toCurrency);
        }

        double result = amount * rates.get(toCurrency);
        conversionHistoryRepository.saveConversion(fromCurrency, toCurrency, amount, result);
        return result;
    }

    public static List<String> getConversionHistory() {
        return conversionHistoryRepository.getHistory();
    }
}