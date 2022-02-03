import java.util.Arrays;
import  java.util.StringJoiner;
import java.util.Iterator;
public class MyArrayList<E> implements MyArray<E> {

public class MyArrayList<T> {
    private Object[] devices;
    private int index;
    private final int pointer = 0;
    private final int INIT_SIZE = 16;
    // private final int CUT_RATE = 4;
    private E[] values;

    public MyArrayList(){
        int INIT_SIZE = 8;
        devices = new Object[INIT_SIZE];
    }

    public void add(T device){
        devices[index]= device;
        index++;
        values = (E[]) new Object[0];
    }

    private void resizeIfNeed(){
        if(index == devices.length){
            int newSize = devices.length * 2;
            Object[] newDevices = new Object[newSize];
            System.arraycopy(devices, 0, newDevices, 0 , devices.length);
            devices = newDevices;
        }
    @Override
    public boolean add(E e) {
      try {
          E[] temp = values;
          values =(E[]) new Object[temp.length+1];
          System.arraycopy(temp,0, values, 0, temp.length);
          values[values.length -1] = e;
          return true;
      }catch (ClassCastException ex){
          ex.printStackTrace();
      }
      return false;
    }

    public String remove(int index){
        if(index < 0 || index >= size()){
            System.out.println("Нельзя удалить элемент по индексу");
        }
        Object[] removeDevice = new Object[size() -1];
        for(int i = 0; i < index; i++){
            removeDevice[i] = devices[i];
        }
        for(int i = index + 1; i < size();i++){
            removeDevice[i - 1] = devices[i];
    @Override
    public void remove(int index) {
        try {
            E[] temp = values;
            values =(E[]) new Object[temp.length-1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElementsAfterIndex = temp.length - index -1;
            System.arraycopy(temp, index+1, values, index, amountElementsAfterIndex);
        }catch (ClassCastException ex){
            ex.printStackTrace();
        }
        return Arrays.toString(removeDevice);
    }
    Object clear(){
        Object[]  clearDevice = new Object[devices.length];
        for(int i = 0; i < devices.length; i++){
            clearDevice[i] = null;
        }

        return Arrays.toString(clearDevice);
    @Override
    public E get(int index) {
        return values[index];
    }






    public T get(int i){
        return (T) devices[i];
    @Override
    public int size() {
        return values.length;
    }

    public int size(){
        return index;
    @Override
    public void clear() {
        E[] temp = values;
        values = (E[]) new Object[temp.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = null;
        }
    }





    //TODO clear


    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < index; i++){
            result.add((CharSequence) devices[i]);
        }
        return "[" + result + "]";
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }
}