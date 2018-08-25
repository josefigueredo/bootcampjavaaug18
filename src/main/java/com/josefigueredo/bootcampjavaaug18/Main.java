package com.josefigueredo.bootcampjavaaug18;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;


public class Main {

    public static void main(String[] args) {

        get("/", (req, res) -> {
            res.type("application/json; charset=utf-8");
            return "";
            }, JsonUtil.json());

        get("/count", (req, res) -> {
            res.type("application/json; charset=utf-8");
            Map<Character, Integer> characterMap = new HashMap<>();

            if (req.queryParams("input") != null) {
                String input = req.queryParams("input").toLowerCase();
                input = input.replace("?", "");
                input = input.replace("!", "");
                input = input.replace("ä", "a");
                input = input.replace("á", "a");
                input = input.replace("ë", "e");
                input = input.replace("é", "e");
                input = input.replace("ï", "i");
                input = input.replace("í", "i");
                input = input.replace("ö", "o");
                input = input.replace("ó", "o");
                input = input.replace("ü", "u");
                input = input.replace("ú", "u");

                for (Character c : input.toCharArray()) {

                    if (characterMap.containsKey(c)) {
                        Integer value = characterMap.get(c);
                        characterMap.put(c, value + 1);
                    } else {
                        characterMap.put(c, 1);
                    }
                }
            }

            return characterMap;
        }, JsonUtil.json());
    }
}
