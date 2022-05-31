package com.example.webparser.service;

import java.util.HashMap;
import java.util.Map;

public class FromCSGOMarketToSteamNameConverter {

    public static Map<String, String> namesMap = new HashMap<>();
    public static Map<String, String> conditionsMap = new HashMap<>();

    static {
        namesMap.put("Побелка", "Whiteout");
        namesMap.put("Сланец", "Slate");
        namesMap.put("Королева пуль", "Bullet Queen");
        namesMap.put("Дух воды", "Water Elemental");
        namesMap.put("В живом цвете", "Living Color");
        namesMap.put("Механо-пушка", "Mecha Industries");
        namesMap.put("Океанское побережье", "Ocean Drive");
        namesMap.put("Прощальный оскал", "See Ya Later");
        namesMap.put("Неонуар", "Neo-Noi");
        namesMap.put("Император", "The Emperor");
        namesMap.put("Азимов", "Asiimov");
        namesMap.put("Хрусталь", "Leaded Glass");
        namesMap.put("Фантомный вредитель", "Phantom Disruptor");
        namesMap.put("Первобытный саблезуб", "Primal Saber");
        namesMap.put("Снежный вихрь", "Frontside Misty");
        namesMap.put("Ядерный сад", "Nuclear Garden");
        namesMap.put("Предатель", "The Traitor");
        namesMap.put("Пламя дракона", "Dragonfire");
        namesMap.put("Защитная сетка", "Safety Net");
        namesMap.put("Турбодвойники", "Twin Turbo");
        namesMap.put("Заговор", "Conspiracy");
        namesMap.put("Неоновый гонщик", "Neon Rider");
        namesMap.put("Второй игрок", "Player Two");
        namesMap.put("Покойник", "Muertos");
        namesMap.put("Извилины", "Cortex");
        namesMap.put("Разъярённая толпа", "Angry Mob");
        namesMap.put("Красная линия", "Redline");
        namesMap.put("Дискотехника", "Disco Tech");
        conditionsMap.put("После полевых испытаний", "Field-Tested");
        conditionsMap.put("Закаленное в боях", "Battle-Scarred");
        conditionsMap.put("Поношенное", "Well-worn");
        conditionsMap.put("Немного поношенное", "Minimal Wear");
        conditionsMap.put("Прямо с завода", "Factory new");
        conditionsMap.put("Закалённое в боях", "Battle-Scarred");
    }


    public static String convertNickName(String fullName) {
        if (namesMap.containsKey(fullName)) {
            return namesMap.get(fullName);
        }
        return fullName;

    }

    public static String convertCondition(String condition) {
        if (conditionsMap.containsKey(condition)) {
            return conditionsMap.get(condition);
        }
        return condition;
    }


}




