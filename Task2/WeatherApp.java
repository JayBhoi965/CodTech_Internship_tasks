package Task2;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApp {

    private static String extractJsonObject(String json, String key) {
        String search = "\"" + key + "\":";
        int idx = json.indexOf(search);
        if (idx < 0) {
            return null;
        }

        idx += search.length();
        while (idx < json.length() && Character.isWhitespace(json.charAt(idx))) {
            idx++;
        }

        if (idx >= json.length() || json.charAt(idx) != '{') {
            return null;
        }

        int braceCount = 0;
        int start = idx;

        for (int i = start; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '{') {
                braceCount++;
            } else if (c == '}') {
                braceCount--;
                if (braceCount == 0) {
                    return json.substring(start, i + 1);
                }
            }
        }

        return null;
    }

    private static String extractJsonValue(String json, String key) {
        String search = "\"" + key + "\":";
        int idx = json.indexOf(search);
        if (idx < 0) {
            return null;
        }

        idx += search.length();
        while (idx < json.length() && Character.isWhitespace(json.charAt(idx))) {
            idx++;
        }

        if (idx >= json.length()) {
            return null;
        }

        char firstChar = json.charAt(idx);
        if (firstChar == '"') {
            idx++;
            int end = json.indexOf('"', idx);
            return end > idx ? json.substring(idx, end) : "";
        }

        int end = idx;
        while (end < json.length() && ",}]\n\r\t ".indexOf(json.charAt(end)) == -1) {
            end++;
        }

        return json.substring(idx, end);
    }

    public static void main(String[] args) {

        // Coordinates of Vadodara
        double latitude = 22.3072;
        double longitude = 73.1812;

        String url =
                "https://api.open-meteo.com/v1/forecast?"
                + "latitude=" + latitude
                + "&longitude=" + longitude
                + "&current_weather=true";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

        try {

            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );

            String jsonResponse = response.body();

            String weatherJson = extractJsonObject(jsonResponse, "current_weather");
            if (weatherJson == null) {
                throw new IllegalStateException("Unable to parse current_weather from API response");
            }

            double temperature =
                    Double.parseDouble(
                            extractJsonValue(weatherJson, "temperature")
                    );

            double windSpeed =
                    Double.parseDouble(
                            extractJsonValue(weatherJson, "windspeed")
                    );

            double windDirection =
                    Double.parseDouble(
                            extractJsonValue(weatherJson, "winddirection")
                    );

            int weatherCode =
                    Integer.parseInt(
                            extractJsonValue(weatherJson, "weathercode")
                    );

            String time =
                    extractJsonValue(weatherJson, "time");

            System.out.println("\n========== WEATHER REPORT ==========");

            System.out.println("Location: Vadodara");

            System.out.println(
                    "Temperature: "
                    + temperature
                    + " °C"
            );

            System.out.println(
                    "Wind Speed: "
                    + windSpeed
                    + " km/h"
            );

            System.out.println(
                    "Wind Direction: "
                    + windDirection
                    + "°"
            );

            System.out.println(
                    "Weather Code: "
                    + weatherCode
            );

            System.out.println(
                    "Time: "
                    + time
            );

            System.out.println("====================================");

        }

        catch (Exception e) {

            System.out.println(
                    "Error fetching weather data"
            );

            e.printStackTrace();
        }
    }
}