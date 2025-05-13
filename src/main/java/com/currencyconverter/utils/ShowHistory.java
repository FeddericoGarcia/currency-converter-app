package main.java.com.currencyconverter.utils;

import java.util.List;
import main.java.com.currencyconverter.service.CurrencyConverterService;
import main.java.com.currencyconverter.menu.MainMenu;

public class ShowHistory {

    public static void showHistory(){
        List<String> historial = CurrencyConverterService.getConversionHistory();

        if (historial.isEmpty()) {
            System.out.println("❌ No hay conversiones registradas.");
        } else {
            System.out.println("📑 Historial de conversiones:");
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + " - " + historial.get(i));
            }
            System.out.println(MainMenu.hr);
        }
    }
}
