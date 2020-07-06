public class Size implements Line {
    //этот класс иммитирует поведение Ask и Bid и нужен для генерации правильной строки при команде size
    int price;
    int size;
    //он создаётся из первого подходящего  Ask или Bid
    public Size(Line line) {
        price = line.getPrice();
        size = line.getSize();
    }
    //метод для перебора уже записанных данных и нохождения подходящего обьекта, на основе которого и создастся this
    static Line findSize(int price) {
        for(Line line : in_lines) {
            if(line.getPrice() == price) {
                return line;
            }
        }
        return null;//программа не имеет никаких страховок, если будут введены некоррекиные данные, напримнер тут она урадёт
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return size + "\n";
    }
}
