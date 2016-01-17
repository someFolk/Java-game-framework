package folk.collection;

/**
 * Created by some Folk on 1/9/2016.
 */
public class Queue<T> extends Collection<T> {

    public Queue(){
        super();
    }

    @Override
    public void add(T value) {
        super.add(value);
    }

    @Override
    public void insert(int index, T value) {
        super.insert(index, value);
    }

    @Override
    public void addAll(T... values) {
        super.addAll(values);
    }

    @Override
    public T poll() {
        return super.poll();
    }

    @Override
    public T first() {
        return super.first();
    }

    @Override
    public void removeValue(T value) {
        super.removeValue(value);
    }
}
