package dev.dankom.witness.util.general;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;
import java.util.function.Consumer;

public class HttpUtil {
    public static StringBuilder getStringBuilder(String urlString) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result;
    }

    public static void downloadFile(String urlString, File localFile) throws IOException {
        if (localFile.exists()) {
            localFile.delete();
        }
        localFile.createNewFile();
        URL readUrl = new URL(urlString);
        OutputStream out = new BufferedOutputStream(new FileOutputStream(localFile.getName()));
        URLConnection conn = readUrl.openConnection();
        String encoded = Base64.getEncoder().encodeToString(("username" + ":" + "password").getBytes(StandardCharsets.UTF_8));  //Java 8
        conn.setRequestProperty("Authorization", "Basic " + encoded);
        InputStream in = conn.getInputStream();
        byte[] buffer = new byte[1024];

        int numRead;
        while ((numRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, numRead);
        }
        if (in != null) {
            in.close();
        }
        if (out != null) {
            out.close();
        }
    }

    public static JSONObject getJSON(String urlString) {
        String json = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = new Scanner(inStream, "UTF-8").useDelimiter("\\Z").next(); // input stream to string
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            return (JSONObject) new JSONParser().parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void getStringBuilder(String urlString, Consumer<StringBuilder> promise) {
        try {
            promise.accept(getStringBuilder(urlString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getJSON(String urlString, Consumer<JSONObject> promise) {
        promise.accept(getJSON(urlString));
    }
}
