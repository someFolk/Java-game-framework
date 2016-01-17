package folk.collection;

/**
 * Created by some Folk on 1/9/2016.
 */
public class Stack<T> extends Collection<T> {

    public Stack(){
        super();
    }

    public void push(T value){
        super.add(value);
    }

    @Override
    public T pop(){
        return super.pop();
    }

    @Override
    public T peek(){
        return super.peek();
    }
}
