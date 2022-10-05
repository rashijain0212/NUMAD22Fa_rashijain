package edu.northeastern.numad22fa_rashijain;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    private static List<Links> linksList = new ArrayList<>();

    public static List<Links> getLinksList() {
        return linksList;
    }

    public static void setLinksList(List<Links> linksList) {
        MyApplication.linksList = linksList;
    }
}
