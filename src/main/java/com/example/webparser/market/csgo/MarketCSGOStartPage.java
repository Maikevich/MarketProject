package com.example.webparser.market.csgo;

import com.example.webparser.interfaces.pages.StartPage;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class MarketCSGOStartPage  {

    @Value("${url}")
    private  static String url;
    @Value("${loginXpath}")
    private static String loginXpath;


    public static void openStartPage(WebDriver webDriver) {
        webDriver.get(url);
        startAuthentication(webDriver);
    }


    private static void startAuthentication(WebDriver webDriver) {
        webDriver.findElement(By.xpath(loginXpath)).click();
    }

}
