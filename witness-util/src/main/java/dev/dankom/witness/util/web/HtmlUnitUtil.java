package dev.dankom.witness.util.web;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class HtmlUnitUtil {
    public static HtmlPage getPage(WebClient webClient, String url) {
        try {
            return webClient.getPage(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void executeJavaScript(WebClient webClient, String url, String javascript) {
        getPage(webClient, url).executeJavaScript(javascript);
    }

    public static WebClient newWebClient() {
        return new WebClient();
    }
}
