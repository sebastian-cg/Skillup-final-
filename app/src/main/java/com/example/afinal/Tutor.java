package com.example.afinal;

public class Tutor {
    private String name;
    private String jobTitle;
    private String description;

    public Tutor(String name, String jobTitle, String description) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.description = description;
    }

    public String getName() {
        return name;

    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDescription() {
        return description;
    }
}
