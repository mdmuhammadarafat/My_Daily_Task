
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.net.HttpURLConnection;
    import java.net.URL;

    public class location {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the phone number (with country code): ");
            String phoneNumber = reader.readLine();

            String locationInfo = getPhoneLocation(phoneNumber);
            System.out.println(locationInfo);
        }

        public static String getPhoneLocation(String phoneNumber) throws IOException {
            try {
                URL url = new URL("https://api.hostip.info/country_json.php?ip=" + phoneNumber);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                String countryInfo = response.toString();
                // Parse the JSON response to extract the country information
                String countryName = countryInfo.split(":")[1].split("\"")[1];

                return "Phone number is likely from: " + countryName;

            } catch (Exception e) {
                return "Error: " + e.getMessage();
            }
        }
    }

