package com.egor69.lt.finder;

import java.util.List;

public class Template {
    private String body;
    private int occurrences;
    private List<String> tokens;

    public Template(String body, int occurrences, List<String> tokens) {
        this.body = body;
        this.occurrences = occurrences;
        this.tokens = tokens;
    }

    public String getBody() {
        return body;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public List<String> getTokens() {
        return tokens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return tokens.equals(((Template) o).tokens);
    }

    @Override
    public int hashCode() {
        return tokens.hashCode();
    }
}
