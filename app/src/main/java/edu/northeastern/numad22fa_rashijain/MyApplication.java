package edu.northeastern.numad22fa_rashijain;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static List<Links> linksList = new ArrayList<>();

    public MyApplication() {
//        filllinksList();
    }

    private void filllinksList() {
        Links l1 = new Links("rrrr", "jjj");
        Links l2 = new Links("dd", "jjj");
        Links l3 = new Links("ss", "jjj");
        Links l4 = new Links("ss", "jjj");
        linksList.addAll(Arrays.asList(l1, l2, l3, l4));
    }

    public static List<Links> getLinksList() {
        return linksList;
    }

    public static void setLinksList(List<Links> linksList) {
        MyApplication.linksList = linksList;
    }
}
