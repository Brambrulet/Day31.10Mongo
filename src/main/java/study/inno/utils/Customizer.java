package study.inno.utils;

public class Customizer {

    private Customizer() {
    }

    public static int str2IntDef(Object src, int def) {
        if (src == null) return def;
        else try {
            return Integer.parseInt(src.toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return def;
    }

    public static String obj2Str(Object obj) {
        if (obj == null) return "";
        else return obj.toString();
    }
}
