package com.przybylo.BookApp.model.JsonPharser;

public class ReadingModels {
    private boolean text;
    private boolean image;

    public boolean isText() {
        return text;
    }

    public void setText(boolean text) {
        this.text = text;
    }

    public boolean isImage() {
        return image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }
}
