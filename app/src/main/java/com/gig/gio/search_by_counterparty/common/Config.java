package com.gig.gio.search_by_counterparty.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class Config {
    public static final String API_URL = "https://dadata.ru";

    // задержка при показе сплэш экрана в миллисекундах
    public static final int SHOW_SPLASH_DELAY_MILLIS = 1000;

    public static final float MAP_ZOOM = 13.0f; // величина зума камеры на экране с картой

    public static final String AUTHOR_EMAIL = "eeyyon@gmail.com";

    public static final String CURRENT_FRAGMENT_TAG = "CURRENT_FRAGMENT_TAG";

    public static final String ABOUT_FRAGMENT_TAG = "ABOUT_FRAGMENT";
    public static final String SEARCH_FRAGMENT_TAG = "SEARCH_FRAGMENT";

    public static final List<String> EMPTY = new ArrayList<>();
}
