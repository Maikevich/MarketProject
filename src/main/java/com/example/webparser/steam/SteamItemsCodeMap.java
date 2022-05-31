package com.example.webparser.steam;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Data
@Getter
public class SteamItemsCodeMap {

    private static Map<String, String> codeMap = new HashMap<>();

    static {
        codeMap.put("AK-47 | Frontside Misty Battle-Scarred", "67061050");
        codeMap.put("AK-47 | Legion of Anubis Battle-Scarred", "176185962");
        codeMap.put("AK-47 | Neon Revolution Battle-Scarred", "165027696");
        codeMap.put("AK-47 | Redline Battle-Scarred", "7179463");
        codeMap.put("AK-47 | Safety Net Field-Tested", "176012489");
        codeMap.put("AK-47 | Slate Well-worn", "176240977");
        codeMap.put("AK-47 | Slate Battle-Scarred", "176241006");
        codeMap.put("AK-47 | Slate Field-Tested", "176241017");
        codeMap.put("AK-47 | Point Disarray Battle-Scarred", "84444501");
        codeMap.put("AK-47 | Phantom Disruptor Battle-Scarred", "176118362");
        codeMap.put("AK-47 | Phantom Disruptor Field-Tested", "176118358");
        codeMap.put("AWP | Fever Dream Battle-Scarred", "175880411");
        codeMap.put("FAMAS | Roll Cage Battle-Scarred", "165031030");
        codeMap.put("MAC-10 | Neon Rider Field-Tested", "40092037");
        codeMap.put("M4A4 | Buzz Kill Battle-Scarred", "175854326");
        codeMap.put("M4A4 | Desolate Space Well-worn", "156113488");
        codeMap.put("M4A1-S | Leaded Glass Battle-Scarred", "175917337");
        codeMap.put("M4A4 | Living Color Battle-Scarred", "176241109");
        codeMap.put("M4A4 | Living Color Field-Tested", "176240966");
        codeMap.put("M4A4 | The Emperor Battle-Scarred", "176043542");
        codeMap.put("M4A4 | Desolate Space Battle-Scarred", "156117092");
        codeMap.put("M4A4 | Neo-Noir Battle-Scarred", "175966923");
        codeMap.put("M4A4 | 龍王 Battle-Scarred", "29209310");
        codeMap.put("Glock-18 | Bullet Queen Battle-Scarred", "176118388");
        codeMap.put("Glock-18 | Bullet Queen Well-worn", "176118319");
        codeMap.put("Glock-18 | Neo-Noi Battle-Scarred", "176209415");
        codeMap.put("Glock-18 | Nuclear Garden Battle-Scarred", "176012498");
        codeMap.put("Glock-18 | Vogue Battle-Scarred", "176186063");
        codeMap.put("Glock-18 | Wasteland Rebel Field-Tested", "156113511");
        codeMap.put("Glock-18 | Water Elemental Battle-Scarred", "14962988");
        codeMap.put("Glock-18 | Water Elemental Field-Tested", "14962951");
        codeMap.put("USP-S | Whiteout Battle-Scarred", "176262591");
        codeMap.put("USP-S | Cortex Minimal Wear", "175966772");
        codeMap.put("USP-S | Neo-Noir Battle-Scarred", "175880400");
        codeMap.put("USP-S | The Traitor Battle-Scarred", "176241084");
        codeMap.put("UMP-45 | Primal Saber Battle-Scarred", "14986903");
        codeMap.put("M4A1-S | Night Terror Field-Tested", "176288520");
        codeMap.put("M4A1-S | Leaded Glass Field-Tested", "175917297");
        codeMap.put("M4A1-S | Night Terror Minimal Wear", "176288478");
        codeMap.put("M4A1-S | Nightmare Battle-Scarred", "176000021");
        codeMap.put("M4A1-S | Player Two Battle-Scarred", "176118446");
        codeMap.put("MP7 | Bloodsport Well-worn", "175967102");
        codeMap.put("Desert Eagle | Ocean Drive Battle-Scarred", "176262873");
        codeMap.put("Desert Eagle | Code Red Battle-Scarred", "176000078");
        codeMap.put("Desert Eagle | Conspiracy Field-Tested", "14963005");
        codeMap.put("Desert Eagle | Mecha Industries Field-Tested", "176024814");
        codeMap.put("Desert Eagle | Mecha Industries Battle-Scarred", "176024857");
        codeMap.put("Dual Berettas | Twin Turbo Battle-Scarred", "176012640");
        codeMap.put("Five-SeveN | Angry Mob Battle-Scarred", "176042598");
        codeMap.put("P250 | See Ya Later Battle-Scarred", "175917382");
        codeMap.put("P250 | Asiimov Field-Tested", "149869019");
        codeMap.put("P250 | Asiimov Well-worn", "149877362");
        codeMap.put("P90 | Asiimov Battle-Scarred", "14962982");
        codeMap.put("SSG 08 | Турбовыпад Field-Tested", "14953176");
        codeMap.put("SSG 08 | Dragonfire Battle-Scarred", "175854387");
        codeMap.put("SSG 08 | Dragonfire Field-Tested", "175854291");
        codeMap.put("StatTrak™ USP-S | Cortex Battle-Scarred", "175967178");
        codeMap.put("StatTrak™ USP-S | Cortex Well-worn", "175966932");
    }

    public static Map<String, String> getMap() {
        return codeMap;
    }

}
