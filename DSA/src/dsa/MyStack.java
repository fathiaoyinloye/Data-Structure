package dsa;

public class MyStack {
    private String[] elements;
    private int count = 0;
    public MyStack(){
        elements = new String[5];
    }
    private int getSize(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;

    }
    public void push(String element){
        if(getSize() == elements.length) throw new IllegalArgumentException();
        elements[count] = element;
        count++;
    }

    public String pop(){
        if(getSize() == 0) throw new IllegalArgumentException();
        count--;
        return elements[count];
    }


    public String peek() {
        return elements[count - 1];
    }
}
