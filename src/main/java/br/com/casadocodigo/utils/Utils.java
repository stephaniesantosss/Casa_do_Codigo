package br.com.casadocodigo.utils;

import java.time.LocalDate;

public class Utils {

    public static boolean isValid(String data) {

        LocalDate hoje = LocalDate.now();
        if (data.compareTo(String.valueOf(hoje)) == 1) {
            return true;
        }
        return false;
    }
}
