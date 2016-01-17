package folk.collection;

/**
 * Created by some Folk on 1/9/2016.
 */
public class List<T> extends Collection<T> {

    public List(){
        super();
    }

    public List(int capacity){
        super(capacity);
    }

    @Override
    public void set(int index, T value){
        super.set(index, value);
    }

    @Override
    public T get(int index){
        return super.get(index);
    }

    @Override
    public void insert(int index, T value){
        super.insert(index, value);
    }

    @Override
    public void add(T value){
        super.add(value);
    }

    @Override
    public void addAll(T... values) {
        super.addAll(values);
    }

    @Override
    public void trim(int start, int end) {
        super.trim(start, end);
    }

    @Override
    public void remove(int index) {
        super.remove(index);
    }

    @Override
    public void removeValue(T value) {
        super.removeValue(value);
    }

    @Override
    public void resize(int newSize) {
        super.resize(newSize);
    }

    @Override
    public void clear() {
        super.clear();
    }
}
