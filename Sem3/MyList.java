package Sem3;

public class MyList<E> {
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private E[] array;
    private int size;

    public MyList(E[] baseArray) {
        this.array = baseArray;
        size = array.length;
    }

    public <T extends E> void addElement(T element) {
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray,0, array.length);
            newArray[array.length] = element;
            array = (E[]) newArray;
        } else {
            array[size] = element;
        }
        size++;
    }
    public void printList(){
        for(E element: array) {
            System.out.println(element);
        }
    }
}
