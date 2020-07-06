import java.io.*;
/**
 * Moiseienko Nikita
 * volsknik@gmail.com
 * +38 063 117 20 88
 */
public class Main {
    //для чтения и записи файлов
    static BufferedReader reader;
    static BufferedWriter writer;

    public static void main(String[] args) throws IOException {
        //входной файл с информацией -- первый аргумент командной строки
        reader = new BufferedReader(new FileReader(args[0]));
        //cчитываем каждую строку и обрабатываем методом indefication(вся работа происходит там)
        while(reader.ready()) {
            String line = reader.readLine();
            Line.indefication(line);
        }

        reader.close();
        //записываем результаты в файл, указанный вторым аргументом командной строки
        writer = new BufferedWriter(new FileWriter(args[1], true));

        for(String line : Line.out_lines) {
            writer.write(line);
            writer.flush();
        }

        writer.close();
    }
}
