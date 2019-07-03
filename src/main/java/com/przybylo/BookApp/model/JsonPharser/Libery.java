package com.przybylo.BookApp.model.JsonPharser;

import java.util.List;

public class Libery {
    private String kind;
    private int totalItems;
    private List<BookJSON> items;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<BookJSON> getItems() {
        return items;
    }

    public void setItems(List<BookJSON> items) {
        this.items = items;
    }
}
