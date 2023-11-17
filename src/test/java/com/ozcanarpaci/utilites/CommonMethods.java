package com.ozcanarpaci.utilites;

import com.google.gson.*;
import io.restassured.response.Response;

import java.io.*;

import static com.ozcanarpaci.base.BaseConstant.MOVIES_FILE_PATH;


public class CommonMethods {


    public static String getMovieInfoFromMovieJson(String path1, String path2) {
        String imdbIDSearchValue = null;
        try {
            // JSON dosyasını oku
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(new FileReader(MOVIES_FILE_PATH)).getAsJsonObject();

            imdbIDSearchValue = jsonObject.getAsJsonObject(path1).get(path2).getAsString();

            // Değeri kullan
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imdbIDSearchValue;
    }

    public static void verifyStatusCode(Response response, int statusCode) {
        response
                .then()
                .assertThat()
                .statusCode(statusCode);
    }

    public static String compareString(double value1, double value2) {
        int comparisonResult = Double.compare(value1, value2);
        if (comparisonResult < 0) {
            return value1 + " küçüktür " + value2;
        } else if (comparisonResult > 0) {
            return value1 + " büyüktür " + value2;
        } else {
            return value1 + " ve " + value2 + " eşittir";
        }
    }

    public static StringBuilder containsControl(String first, String second) {
        String[] firstValue = first.split(", ");
        StringBuilder cont = new StringBuilder();

        for (String count : firstValue) {
            // Eğer ikinci string içinde bulunmuyorsa false döndür
            if (second.contains(cont)) {
                cont.append(cont).append(", ");
            }
        }
        return cont;
    }

}
