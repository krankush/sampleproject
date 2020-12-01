package com.ankush.sampleproject.service;

public class NameProcessor {
    public String getLastName(String name) {
        if (name.equals("Ankit"))
            return "Kumar";
        else if (name.equals("Ankush"))
            return "Kumar";
        else if (name.equals("Asmita"))
            return "Allah hu";
        return "xyz";
    }
}
