package com.przybylo.BookApp.model.JsonPharser;

import java.util.List;

public class LiberyFromFile {
    private String requestedUrl;
    private List<BookJSON> items;

    public String getRequestedUrl() {
        return requestedUrl;
    }

    public void setRequestedUrl(String requestedUrl) {
        this.requestedUrl = requestedUrl;
    }

    public List<BookJSON> getItems() {
        return items;
    }

    public void setItems(List<BookJSON> items) {
        this.items = items;
    }
}
