package main.java.com.currencyconverter.utils;

import java.util.Scanner;
import main.java.com.currencyconverter.menu.MainMenu;

public class SelectCurrency {
    private static Scanner scanner = new Scanner(System.in);

    public static String selectCurrencys(){
        String[] monedas = {"ARS", "USD", "EUR", "JPY", "GBP", "AUD", "CAD", "CHF"};
        String[] monedasStr = {"Peso Argentino", "Dolar EEUU", "Peso Europeo", "Yen Japonés", "Libra esterlina", "Dolar Australiano", "Dolar Canadiense", "Franco Suizo"};

        for (int i = 0; i < monedas.length; i++) {
            System.out.println((i + 1) + ". " + monedas[i] + " - " + monedasStr[i]);
        }

        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion < 1 || opcion > monedas.length) {
            System.out.println(MainMenu.hr);
            System.out.println("⛔ ¡Opción inválida! ⛔. Intenta de nuevo");
            System.out.println(MainMenu.hr);
            return selectCurrencys();
        }

        return monedas[opcion - 1];
    }
}
