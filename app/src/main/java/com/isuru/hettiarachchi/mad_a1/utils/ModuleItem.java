package com.isuru.hettiarachchi.mad_a1.utils;

public class ModuleItem {
    private String month;
    private String date;
    private String year;
    private String moduleDetails;

    public ModuleItem(String month, String date, String year, String moduleDetails) {
        this.month = month;
        this.date = date;
        this.year = year;
        this.moduleDetails = moduleDetails;
    }

    public String getMonth() {
        return month;
    }

    public String getDate() {
        return date;
    }

    public String getYear() {
        return year;
    }

    public String getModuleDetails() {
        return moduleDetails;
    }
}
