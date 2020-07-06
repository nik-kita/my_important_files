import java.util.PriorityQueue;

public class Bid implements Line {
    //всё тоже, что и в Ask
    //но компаратор отнимает цены наоборот и очередь получаеися от большего к меньшему
    static PriorityQueue<Bid> bids = new PriorityQueue<>(2, (first, second) -> second.price - first.price);

    int price;
    int count;

    public Bid(String group_1, String group_2) {
        price = Integer.parseInt(group_1);
        count = Integer.parseInt(group_2);
        bids.add(this);
    }

    public static Line getBest() {
        return bids.peek();
    }

    public static void sell(int size) {
        Bid best = bids.peek();
        best.count -= size;
        bids.add(best);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getSize() {
        return count;
    }

    @Override
    public String toString() {
        return price + "," + count + "\n";
    }
}
