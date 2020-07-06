import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public interface Line {
    //каждая сторока после "индефикации"(что это? запрос на удоление/добавление/вывод на экран...) добавляется как соответствующий обьект в список in_lines
    static List<Line> in_lines = new ArrayList<>();     //все обьекты, созданные строкой "обьединены" общим интерфейсом
    static List<String> out_lines = new ArrayList<>();  //каждый класс имеет переопределённый toString() и out_lines -- это уже те строки, которые
                                                        //будут записаны в выходной файл
    static void indefication(String str) {
        Matcher matcher;//каждая строка проверяется на совпадения с соответствующим паттерном из класса Regex
        if ((matcher = Regex.bid.matcher(str)).find()) {
            in_lines.add(new Bid(matcher.group(1), matcher.group(2)));
        } else if ((matcher = Regex.ask.matcher(str)).find()) {
            in_lines.add(new Ask(matcher.group(1), matcher.group(2)));
        } else if (Regex.best_bid.matcher(str).find()) {
            out_lines.add(Bid.getBest().toString());
        } else if (Regex.best_ask.matcher(str).find()) {
            out_lines.add(Ask.getBest().toString());
        } else if ((matcher = Regex.size.matcher(str)).find()) {
            out_lines.add(new Size(Size.findSize(Integer.parseInt(matcher.group(1)))).toString());
        } else if ((matcher = Regex.buy.matcher(str)).find()) {
            Ask.buy(Integer.parseInt(matcher.group(1)));
        } else if ((matcher = Regex.sell.matcher(str)).find()) {
            Bid.sell(Integer.parseInt(matcher.group(1)));
        }
    }

    int getPrice();
    int getSize();
}
