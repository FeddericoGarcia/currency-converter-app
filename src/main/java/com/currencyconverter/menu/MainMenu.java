package main.java.com.currencyconverter.menu;

import java.util.Scanner;

import main.java.com.currencyconverter.service.CurrencyConverterService;
import main.java.com.currencyconverter.utils.ShowHistory;
import main.java.com.currencyconverter.utils.MakeConversion;

public class MainMenu {

    private final CurrencyConverterService currencyConverter;
    private final Scanner scanner;
    private final String linea = "**********************************";
    public static String hr = "----------------------------------";

    public MainMenu() {
        this.currencyConverter = new CurrencyConverterService();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println(linea);
        System.out.println("€$¥£   CONVERSOR DE DIVISAS   £¥$€");
        System.out.println(linea);
        System.out.println("- Bienvenido/a 👋 seleccioná una opción ");

        while (true) {
            System.out.println("------ MENU ------");

            System.out.println("1. Realizar una conversión");
            System.out.println("2. Ver historial de conversiones");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            System.out.println(hr);

            switch (opcion) {
                case 1:
                    MakeConversion.makeConversions();
                    break;
                case 2:
                    ShowHistory.showHistory();
                    break;
                case 3:
                    System.out.println(hr);
                    System.out.println("🔄 Saliendo...");
                    System.out.println("¡Esperamos verte pronto!");
                    return;
                default:
                    System.out.println(hr);
                    System.out.println("⛔ Opción inválida ⛔, intenta de nuevo.");
                    System.out.println(hr);
            }
        }

    }
}
