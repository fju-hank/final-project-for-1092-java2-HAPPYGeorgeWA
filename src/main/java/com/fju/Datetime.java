package com.fju;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datetime {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date current = new Date();

    public void printdate() {
        System.out.println(sdf.format(current));
    }
}
