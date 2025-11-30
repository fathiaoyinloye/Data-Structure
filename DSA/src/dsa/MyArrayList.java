package dsa;

public class MyArrayList {
    private int count =  0;
    private String[] elements;
    private int myArrayListSize = 30;

    public MyArrayList() {
        elements = new String[myArrayListSize];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean add(String element) {
        elements[count] = element;
        count++;
        changeSize();
        return true;
    }
    public int lastElementIndex() {
        return count - 1;
    }
    public boolean myRemove(String element) {
        boolean isThere = false;
        for(int counter = 0; counter < count; counter++){
            if(elements[counter].equals(element)){
                isThere = true;
                count--;
                break;

            }

        }
        return isThere;
    }
    private void changeSize() {
        if (count == myArrayListSize/2) {
            myArrayListSize += myArrayListSize;
            String[] newElements = new String[myArrayListSize];
            elements = newElements;
            for(int counter = 0; counter < myArrayListSize; counter++){
                newElements[counter] = elements[counter];
            }

        }

    }
    public String get(int index){
        if(count == 0) throw new IllegalArgumentException("Empty ArrayList");

        return elements[index];
    }
    public int size(){
        return count;
    }
    public void myRemove(int index){
        for(int counter = 1; counter < count; counter++){
          for(int check = 0; check < count; check++) {
              if (elements[check].equals(elements[index])) {
                  elements[check] = elements[counter];
              }
          }
        }
        elements[lastElementIndex()] = null;
        count --;
    }
    public void add(int index, String element) {
        count++;
        for(int check = index; check < count; check++) {
            for (int counter = check + 1; counter < count; counter++) {
                String temp = elements[check];
                elements[check] = element;
                elements[counter] = temp;
            }
        }
    }

    public boolean contains(String element){
        boolean result = false;
        for(int counter = 0; counter < count; counter++) {
            if (elements[counter].equals(element)) {
                result = true;
                break;
            }
        }
        return result;
    }







}
