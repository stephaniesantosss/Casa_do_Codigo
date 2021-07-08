package br.com.casadocodigo.utils;

import java.text.Normalizer;

public class Utils {

    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
