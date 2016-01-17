package folk.collection;

import java.util.Random;

/**
 * Created by some Folk on 1/4/2016.
 */
abstract class Collection<T> {

    // Number of items existed in the collection.
    private int size;

    // Elements container.
    private T[] items;

    // Magic number
    private static final int DEFAULT_SIZE = 8;


    Collection(int size){
        items = (T[]) new Object[size];
        this.size = size;
    }

    Collection(){
        items = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    // Setting value to specific index.
    void set(int index, T value){
        ensureRange(index);
        items[index] = value;
    }

    // Adding value at the end of the scheme.
     void add(T value){
        if(size == items.length) resize( (int)(size * 1.25) );
        items[size++] = value;
    }

    // Adding unknown number of variables in one call.
     void addAll(T... values){
        for(T value : values)
            add(value);
    }

    // Insert value at specific index without overriding.
     void insert(int index, T value){
        ensureRange(index);
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = value;
        size++;
    }

    // Get value by index.
     T get(int index){
        ensureRange(index);
        return items[index];
    }

    // Remove and return last item.
     T pop(){
        if(size == 0) throw new IllegalStateException("collection is empty");
        T value = items[--size];
        items[size] = null;
        return value;
    }

    // Remove and return first item.
     T poll(){
        if(size == 0) throw new IllegalStateException("collection is empty");
        T value = items[0];
        remove(0);
        return value;
    }

    // Get last item.
     T peek(){
        if(size == 0) throw new IllegalStateException("collection is empty");
        return items[size - 1];
    }

    // Get first item.
     T first(){
        if(size == 0) throw new IllegalStateException("collection is empty");
        return items[0];
    }

    // Deleting all indexes of & between range.
     void trim(int start, int end){
        ensureRange(start);
        ensureRange(end);
        if(start >= end) throw new IllegalStateException("Start can't be >= end.");
        int count = (end + 1) - start;
        System.arraycopy(items, end + 1, items, start, size - (count + start));
        size -= count;
        for(int i = size; i < items.length; i++) items[i] = null;
    }

    // Remove value by index.
     void remove(int index){
        ensureRange(index);
        System.arraycopy(items, index + 1 , items, index , --size - index);
        items[size] = null;
    }

    // Removing all elements containing specific value
     void removeValue(T value){
         int index = indexOf(value);
         if( index >= 0 ) remove(index);
    }

    // Ensure index pointer is in array range
     void ensureRange(int index){
        if(index < 0 || index >= size)
            throw new IllegalStateException("Index pointer is out of range");
    }

    // changing container capacity
     void resize(int newSize){
        T[] temp = (T[]) new Object[newSize];
        System.arraycopy(items, 0, temp, 0, ((size < newSize) ? size : newSize) );
        items = temp;
    }

    // return index of value if exist
    public int indexOf(T value){
        for(int i = 0; i < size; i++){
            if(items[i] == value) return i;
        }
        return -1;
    }

    // Ditching all values while remaining structure.
    void clear(){
        for(int i = 0; i < size; i++)
            items[i] = null;
        size = 0;
    }

    // Merging two arrays into one.
    public void merge(Collection<T> arr){
        int length = arr.length();
        if(length == 0) return;
        int availability = items.length - size;
        if(length > availability) resize(items.length + (length - availability));
        for(int i = 0; i < length; i++){
            items[size++] = arr.get(i);
        }
    }

    // Starting clean
    public void reset(){
        if(size == 0) return;
        items = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    // Reverse array first<>last,
    public void reverse(){
        if(size == 0) return;
        for(int i = 0, io = size - 1, c = size / 2; i < c; i++){
            int ii = io - i;
            T temp = items[ii];
            items[ii] = items[i];
            items[i] = temp;
        }
    }

    // Swapping values of two indexes
    public void swap(int indexOne, int indexTwo){
        ensureRange(indexOne);
        ensureRange(indexTwo);
        T temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    // Shuffling random
    public void shuffle(){
        if(size == 0) return;
        java.util.Random r = new Random();
        for(int i = 0; i < size; i++){
            int ii = r.nextInt(size);
            int iii = r.nextInt(size);
            T temp = items[ii];
            items[ii] = items[iii];
            items[iii] = temp;
        }
    }

    // Release memory when necessary
    public void shrink(){
        if(size != items.length) resize(size);
    }

    // Check if such value exist
    public boolean contains(T value){
        return indexOf(value) != -1;
    }

    // Return current visible size of the array
    public int length(){
        return size;
    }


    public boolean isEmpty(){
        return size == 0? true : false;
    }

}


