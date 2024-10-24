package com.abdullah.BrowsingHistory;

public class Main {
    public static void main(String[] args) {
        BrowsingHistory history = new BrowsingHistory();

        // Step 1: Add websites
        history.visit("google.com");
        history.visit("facebook.com");
        history.visit("twitter.com");
        history.display();


        history.goBack();
        history.goBack();
        history.visit("youtube.com");
        history.display();
        history.goForward();
        history.goBack();
    }
}
