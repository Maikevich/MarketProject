package com.example.webparser;

import com.example.webparser.util.SeleniumConnector;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Data
@Service
public class BrowserController {
    @Autowired
    public BrowserController(SeleniumConnector seleniumConnector) {
        this.seleniumConnector = seleniumConnector;
    }

    private SeleniumConnector seleniumConnector;
    @Value("${login}")
    private String login;
    @Value("${password}")
    private String password;
    @Value("${url}")
    private String url;
    @Value("${loginFieldXpath}")
    private String loginFieldXpath;
    @Value("${passwordFieldXpath}")
    private String passwordFieldXpath;
    @Value("${signInXpath}")
    private String signInXpath;
    @Value("${loginXpath}")
    private String loginXpath;



    @EventListener({ContextRefreshedEvent.class})
    void start() {
        WebDriver webDriver = seleniumConnector.connect();
        webDriver.get(url);
        signIn(webDriver);
        webDriver.manage().window().maximize();

    }

    private void signIn(WebDriver webDriver) {
        WebElement startSignIn = webDriver.findElement(By.xpath(loginXpath));
        startSignIn.click();
        WebElement loginField = webDriver.findElement(By.xpath(loginFieldXpath));
        WebElement passwordField = webDriver.findElement(By.xpath(passwordFieldXpath));
        WebElement signIn = webDriver.findElement(By.xpath(signInXpath));

        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        signIn.click();

    }

}
