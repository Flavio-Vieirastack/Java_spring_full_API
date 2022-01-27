package com.spring_full_api.spring_api.Resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;


public class Url {
    public static List<Integer> decodeIntList(String list) {
        String[] vet = list.split(",");
        List<Integer> listInteger = new ArrayList<Integer>();
        for (int i = 0; i < vet.length; i++) {
            listInteger.add(Integer.parseInt(vet[i]));

        }

        return listInteger;
    }

    public static String decodeParam (String param) {
        try {
            return URLDecoder.decode(param, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}