package com.gig.gio.search_by_counterparty.common;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class Config {
    public static final String API_URL = "https://dadata.ru";

    // задержка при показе сплэш экрана в миллисекундах
    public static final int SHOW_SPLASH_DELAY_MILLIS = 1000;

    public static final float MAP_ZOOM = 13.0f; // величина зума камеры на экране с картой

    // имя файла для http кэша
    public static final String CACHE_FILE_NAME = "responseCache";
    // время хранения кэша в минутах
    public static final int CACHE_TIME = 1;
    // размер файла для кжша
    public static final long CACHE_FILE_SIZE = 10 * 1024 * 1024; // 10 Mb

    public static final String AUTHOR_EMAIL = "eeyyon@gmail.com";

    public static final String IS_FIRST_START = "IS_FIRST_START";

    public static final String ABOUT_FRAGMENT_TAG = "ABOUT_FRAGMENT";
    public static final String SEARCH_FRAGMENT_TAG = "SEARCH_FRAGMENT";
}
