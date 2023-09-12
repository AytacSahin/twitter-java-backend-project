package com.backendproject.twitterclone.helpers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeDateFn {
    public static LocalDateTime TimeCalculator() {
        ZoneId turkishZone = ZoneId.of("Europe/Istanbul");
        ZonedDateTime nowInTurkey = ZonedDateTime.now(turkishZone);
        LocalDateTime customDateTime = nowInTurkey.toLocalDateTime();
    return customDateTime;
    }
}
