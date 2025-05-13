package main.java.com.currencyconverter.service;

import main.java.com.currencyconverter.model.ExchangeRate;
import main.java.com.currencyconverter.exception.ApiConnectionException;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ExchangeRateService {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/09f28899078a440d05d01a15/latest/";

    public static ExchangeRate getExchangeRates(String baseCurrency) throws ApiConnectionException {
        try {
            URL url = new URL(API_URL + baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new ApiConnectionException("\n⛔ Error al conectar con la API ⛔ - ERROR:" + responseCode);
            }

            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder jsonResponse = new StringBuilder();
            while (scanner.hasNext()) {
                jsonResponse.append(scanner.nextLine());
            }
            scanner.close();

            Gson gson = new Gson();
            return gson.fromJson(jsonResponse.toString(), ExchangeRate.class);

        } catch (IOException e) {
            throw new ApiConnectionException("\n⛔ Error de conexión con la API ⛔: " + e.getMessage());
        }
    }
}
