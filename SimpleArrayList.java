package HWFrame5;

import java.util.Iterator;

/**
 * Created by Иван on 21.06.2015.
 */
public class SimpleArrayList implements Iterable {
    private Object [] list;
    private int size;
    private int indexOfFirst;
    private SALIterator salIterator = new SALIterator();

    public SimpleArrayList() {
        list = new Object[15];
        indexOfFirst = 5;
        size = 0;
    }

    public int getSize() {
        return size;
    }

   public void updateSize(){
       size = list.length-indexOfFirst+size;
   }

    private boolean checkAvailableSpace() {
        if (indexOfFirst+size+5 > list.length){
               return true;
        }
        return false;
    }

    private void extendArray(){
        Object [] newList = new Object[list.length*3/2+1];
        int indexOfFirstNew = newList.length/3;
        System.arraycopy(list,indexOfFirst,newList,indexOfFirstNew,size);
        indexOfFirst = indexOfFirstNew;
        list = newList;
    }

    public void add (Object obj){
        if (checkAvailableSpace()) {
            extendArray();
        }
            list[indexOfFirst+size] = obj;
            size++;




    }
    public boolean contains (Object obj){
          for (Object o: list){
            if (o != null && o.equals(obj)){
                return true;
            }
        }
        return false;
    }
    public Object get(int index) {
        return list[index+indexOfFirst];
    }
    public void remove(Object obj){
        boolean isFound = false;
        for (int i = indexOfFirst; i < size; i++){
            if (list[i].equals(obj)){
                isFound = true;
                Object [] newList = new Object [list.length-1];
                System.arraycopy(list,0,newList,0,i);
                System.arraycopy(list,i+1,newList,i,size-(i+1));
                list = newList;
                size--;
            }
        }
        if (!isFound){
            System.out.println("Object " + obj + " not found");
        }
    }
    public void set(int index, Object obj) {
        if (index > size+1) {
            System.out.println("List " + this + " doesn't have enough size");
        } else if (index == size){
            add(obj);
        } else {
            Object [] newList = new Object[list.length+1];
            System.arraycopy(list,indexOfFirst,newList,indexOfFirst,index);
            newList[index+indexOfFirst] = obj;
            System.arraycopy(list,index+indexOfFirst,newList,index+indexOfFirst+1,size-index);
            list = newList;
            size++;

        }
    }
    public void printList(){
        System.out.print("{ ");
        for (int i = indexOfFirst; i < indexOfFirst+size-1 ; i++) {
            System.out.print(list[i] + ", ");
        }
        System.out.print(list[indexOfFirst+size-1]);
        System.out.println(" }");
        System.out.println(size);
    }
    public Object[] toArray(){
        Object [] newList = new Object[size];
        System.arraycopy(list,indexOfFirst,newList,0,size);
        return newList;
    }

    @Override
    public Iterator iterator() {
        return new SALIterator();
    }

    public class SALIterator implements Iterator {
        private Object cp;
        private int index = indexOfFirst;

        @Override
        public boolean hasNext() {
            return (index+1 < size+indexOfFirst);
        }

        @Override
        public Object next() {
            if (cp == null){
                cp = list[indexOfFirst];
                return cp;
            }
            if (hasNext()) {
                index++;
                cp = list[index];

                return cp;
            }
            else throw new IllegalStateException("Object " + cp + " Doesn't have any elements after");
        }
    }
}
