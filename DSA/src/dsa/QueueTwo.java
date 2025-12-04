package dsa;

public class QueueTwo {

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
    /*public String remove(){
        System.out.println(count);
        String result = null;
        if (count == 0) throw new IllegalArgumentException("Queue is empty");
        int check = 0;
        for(int counter = 0; counter < count ; counter++){
            if (elements[counter] != null) {check = counter;
            break;}
        }

        if(count == 5){
            count--;
            result = elements[count];
            for(int counter = 0; counter < count - 1; counter++){
                elements[counter] = elements[check];check++;
            }
        }


        else if (count < 5){count--;result = elements[check];elements[check] = null;}
       // System.out.(check);
        return result;

    }*/
    public String element(){
        if(count == 0) throw new IllegalArgumentException("Queue is empty");
        return elements[0];
    }
    public String peek(){
        if(count == 0) return null;
        return elements[0];
    }
    public String[] getElements(){
        return elements;
    }


    public String remove(){
        String result = null;
        int check = 0;
        if(count == 0) throw new IllegalArgumentException("Queue is empty");
        else if(count > 0 && count < 5){
            for(int counter = 0; counter < count ; counter++){
                if (elements[counter] != null) {check = counter;
                    break;}
            }
            result =  elements[check];
        }
        elements[check] = null;

        count--;
        return result;
    }


}

