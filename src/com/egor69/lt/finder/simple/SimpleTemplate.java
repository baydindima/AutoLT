package com.egor69.lt.finder.simple;

public class SimpleTemplate {
    private int occurrencesNumber;
    private String body;

    public SimpleTemplate(int occurrencesNumber, String body) {
        this.occurrencesNumber = occurrencesNumber;
        this.body = body;
    }

    public int getOccurrencesNumber() {
        return occurrencesNumber;
    }

    public String getBody() {
        return body;
    }

    @Override
    public int hashCode() {
        return body.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SimpleTemplate
                && body.equals(((SimpleTemplate) obj).body);
    }
}
