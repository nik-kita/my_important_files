import java.util.regex.*;

public class Regex {
    public static Pattern bid = Pattern.compile("(?m)u,(\\d+),(\\d+),bid$");
    public static Pattern ask = Pattern.compile("(?m)u,(\\d+),(\\d+),ask$");
    public static Pattern best_bid = Pattern.compile("(?m)q,best_bid$");
    public static Pattern best_ask = Pattern.compile("(?m)q,best_ask$");
    public static Pattern size = Pattern.compile("(?m)q,size,(\\d+)$");
    public static Pattern buy = Pattern.compile("(?m)o,buy,(\\d+)$");
    public static Pattern sell = Pattern.compile("(?m)o,sell,(\\d+)$");
}
