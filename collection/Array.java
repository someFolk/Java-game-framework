package folk.collection;

/**
 * Created by some Folk on 1/9/2016.
 */
public class Array<T> extends Collection<T> {

    public Array(int capacity){
        super(capacity);
    }

    public Array(T[] arr){
        this(arr.length);

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
    public void clear(){
        super.clear();
    }

    @Override
    public void resize(int newSize){
        super.resize(newSize);
    }
}
