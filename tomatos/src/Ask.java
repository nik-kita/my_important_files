import java.util.Comparator;
import java.util.PriorityQueue;

public class Ask implements Line {
    //при создании каждый обьект добавляется в PriorityQueue, где сразу занимает соответсивующее место, исходя из цены
    //от меньшего к большему
    static PriorityQueue<Ask> asks = new PriorityQueue<>(2, Comparator.comparingInt(ask -> ask.price));

    int price;
    int count;
    //в паттерне указаны позиции, по которым следует искать цену и кол-во
    public Ask(String group_1, String group_2) {
        price = Integer.parseInt(group_1);
        count = Integer.parseInt(group_2);
        asks.add(this);//cразу добавляем в очередь
    }

    public static Line getBest() {
        return asks.peek();
    }
    //берём с найменьшей ценой и меняем кол-во, а потом обратно добаляем, чтоб если что, поменялась позиция в очереди
    public static void buy(int size) {
        Ask best = asks.poll();
        best.count -= size;
        asks.add(best);
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
