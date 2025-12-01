package dsa;
import java.util.Arrays;

public class MySet {
    private int count = 0;
    private String[] elements;
    private int setSize = 10;
    public MySet(int setSize){}
    public MySet() {
        elements = new String[setSize];
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public boolean add(String element){
        boolean notThere = true;
        count++;
        changeSize();
        if (count == 1) elements[count - 1] = element;
        else{
          for (int counter = 0; counter < count; counter++) {
              if (element.equals(elements[counter])) {
                  count--;
                  notThere = false;
              }
          }
        }
        if(notThere) elements[count - 1] = element;

        return notThere;
    }

    public int size(){
        return count;
    }
    public boolean remove(String element) {
        boolean isThere = false;
        for(int counter = 0; counter < count; counter++){
            if(element.equals(elements[counter])){
                isThere = true;
                removeElementFromArray(counter);
                count--;
                break;

            }

        }
        return isThere;
    }
    private void removeElementFromArray(int check){
            for(int index = check + 1; index < count ; index++){
                elements[check] = elements[index];
                check++;
            }
       elements[count- 1] = null;
    }
    public boolean contains(String element) {
        for (int counter = 0; counter < count; counter++) {
            if (element.equals(elements[counter])) return true;
        }
        return false;
    }
    public void clear(){
        for(int counter = 0; counter < count; counter++){
            elements[counter] = null;
        }
        count = 0;
    }
    private void changeSize() {
        if (count == setSize/2) {
            setSize += setSize;
            String[] newElements = new String[setSize];
            for(int counter = 0; counter <  count; counter++){
                newElements[counter] = elements[counter];
            }
            elements = newElements;
        }

    }
}
