package converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class update_checker {
    public static void update() throws IOException {
        String current_version = "v1.0.1";
        char first_char = current_version.charAt(1);
        char second_char = current_version.charAt(3);
        char third_char = current_version.charAt(5);

        int first_int = Character.getNumericValue(first_char);
        int second_int = Character.getNumericValue(second_char);
        int third_int = Character.getNumericValue(third_char);

        int first_int_modified =  first_int + 1;
        int second_int_modified =  second_int + 1;
        int third_int_modified =  third_int + 1;

        String first_str_modified = String.valueOf(first_int_modified);
        String second_str_modified = String.valueOf(second_int_modified);
        String third_str_modified = String.valueOf(third_int_modified);

        String first_possible_patch = "v" + first_str_modified + "." + second_char + "." + third_char;
        String second_possible_patch = "v" + first_char + "." + second_str_modified + "." + third_char;
        String third_possible_patch = "v" + first_char + "." + second_char + "." + third_str_modified;

        latest_version(first_possible_patch);
        latest_version(second_possible_patch);
        latest_version(third_possible_patch);
    }
    public static void latest_version(String tag) throws IOException {
        String latestVersion = null;
        URL url = new URL("https://api.github.com/repos/Hav1ck/currency-converter/releases/tags/" + tag);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("You can download new version https://github.com/Hav1ck/currency-converter");
        }
        else if (responseCode == 404) {
        }
        else {
            System.out.println("Failed to check latest release information. Response code: " + responseCode);
        }

        connection.disconnect();

    }
 }
