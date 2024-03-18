package converter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class update_checker {
    public static void main(String[] args) {
        String latestVersion = getLatestVersionFromGitHub("Hav1ck", "currency-converter");
        System.out.println("Latest version: " + latestVersion);
    }

    private static String getLatestVersionFromGitHub(String owner, String repo) {
        String latestVersion = null;
        try {
            URL url = new URL("https://api.github.com/repos/" + owner + "/" + repo + "/releases/latest");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                latestVersion = response.toString();
            } else {
                System.out.println("Failed to fetch latest release information. Response code: " + responseCode);
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latestVersion;
    }
}
