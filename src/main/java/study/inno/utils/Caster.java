package study.inno.utils;

import org.apache.log4j.Logger;

public class Caster {

    private Caster() {
    }

    public static int str2IntDef(Object src, int def) {
        if (src == null) return def;
        else try {
            return Integer.parseInt(src.toString());
        } catch (NumberFormatException e) {
            Logger.getLogger(Caster.class).error(e.getMessage(), e);
        }
        return def;
    }

    public static String obj2Str(Object obj) {
        if (obj == null) return "";
        else return obj.toString();
    }
}
