package com.zang.api.configuration;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ZangConstants {
    public static final String BASE_URL = "https://api.zang.io/v2";

    public static final SimpleDateFormat queryDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat jsonDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);

}
