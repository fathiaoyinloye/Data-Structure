package dsa;

public class MyQueue {
  private  int count = 0;
    private String[] elements = new String[5];


    public boolean isEmpty() {
        return count == 0;
    }

   public  boolean myOffer(String element){
        if(count < 5) {
            elements[count] = element;
            count++;
        }
        return  count < 5;
   }

    public  boolean myAdd(String element){
        if(count == 5) throw new IllegalArgumentException("Queue is full");
        if(count < 5) {
            elements[count] = element;
            count++;
        }
        return  count < 5;
    }



   public String myPoll(){
        for(int counter = 0; counter < count - 1; counter++){
            for(int index = 1; index < count - 1; index++){
                elements[counter] = elements[index];
            }
        }
       elements[count] = null;
       count--;
       return elements[0];

   }
    public String remove(){
        if (count == 0) throw new IllegalArgumentException("Queue is empty");
        for(int counter = 0; counter < count - 1; counter++){
            for(int index = 1; index < count - 1; index++){
                elements[counter] = elements[index];
            }
        }
        elements[count] = null;
        count--;
        return elements[0];

    }
    public String element(){
        if(count == 0) throw new IllegalArgumentException("Queue is empty");
        return elements[0];
    }
    public String peek(){
        if(count == 0) return null;
        return elements[0];
    }


}
