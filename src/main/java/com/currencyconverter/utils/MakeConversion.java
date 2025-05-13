package main.java.com.currencyconverter.utils;

import main.java.com.currencyconverter.exception.InvalidCurrencyException;
import main.java.com.currencyconverter.service.CurrencyConverterService;
import main.java.com.currencyconverter.menu.MainMenu;

public class MakeConversion {

    public static void makeConversions() {
        GetAmount getAmount = new GetAmount();
        System.out.println("- Selecciona la moneda de origen:");
        String fromCurrency = String.valueOf(SelectCurrency.selectCurrencys());
        System.out.println(MainMenu.hr);
        System.out.println("- Ingresa el monto:");
        double amount = getAmount.getAmounts();
        System.out.println(MainMenu.hr);
        System.out.println("- Selecciona la moneda de destino:");
        String toCurrency = String.valueOf(SelectCurrency.selectCurrencys());
        System.out.println(MainMenu.hr);
        System.out.println("⏳ Espere, por favor... ⏳");

        try {
            double resultado = CurrencyConverterService.convert(fromCurrency, toCurrency, amount);
            System.out.println(MainMenu.hr);
            System.out.printf("✔ Resultado: $%.2f %s → $%.2f %s \n", amount, fromCurrency, resultado, toCurrency);
            System.out.println(MainMenu.hr);
        } catch (InvalidCurrencyException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
