package br.com.casadocodigo.utils;

import java.text.Normalizer;
import java.time.LocalDate;

public class Utils {

    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static boolean isValid(String data) {

        LocalDate hoje = LocalDate.now();
        if (data.compareTo(String.valueOf(hoje)) == 1) {
            return true;
        }
        return false;
    }
}
