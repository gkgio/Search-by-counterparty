package com.gig.gio.search_by_counterparty.common;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class Config {
    public static final String API_URL = "https://dadata.ru";

    // задержка при показе сплэш экрана в миллисекундах
    public static final int SHOW_SPLASH_DELAY_MILLIS = 1000;

    // имя файла для http кэша
    public static final String CACHE_FILE_NAME = "responseCache";
    // время хранения кэша в минутах
    public static final int CACHE_TIME = 1;
    // размер файла для кжша
    public static final long CACHE_FILE_SIZE = 10 * 1024 * 1024; // 10 Mb

    public static final String AUTHOR_EMAIL = "eeyyon@gmail.com";
}
