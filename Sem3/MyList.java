package Sem3;


import java.util.Iterator;

public class MyList<E> implements Iterable<E> {
    Object[] initArray = {};
    private E[] array;
    private int size;

    public MyList(E[] baseArray) {
        this.array = baseArray;
        size = array.length;
    }

    public MyList() {
        this.array = (E[]) initArray;
        size = 0;
    }

    public <T extends E> void addElement(T element) {
        if (size == array.length) {
            Object[] newArray = new Object[array.length + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[array.length] = element;
            array = (E[]) newArray;
        } else {
            array[size] = element;
        }
        size++;
    }

    public void removeElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
    }

    public int getArrayLength() {
        return array.length;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        for (E element : array) {
            System.out.println(element);
        }
    }
    class MyListIterator implements Iterator<E> {
        int index;

        public MyListIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return array[index++];
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new MyListIterator();
    }
}
