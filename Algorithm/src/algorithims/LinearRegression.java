package algorithims;
import java.util.Arrays;

public class LinearRegression {
    int numberOfDatapoint;
    int [] valuesOfY;
    int [] valuesOfX;



    public LinearRegression(int datapoint, int [] valuesOfY, int [] valuesOfX) {
        /*if(valuesOfY.length  != numberOfDatapoint || valuesOfX.length != numberOfDatapoint )
            throw new IllegalArgumentException();*/
        this.numberOfDatapoint = datapoint;
        this.valuesOfX = valuesOfX;
        this. valuesOfY = valuesOfY;
    }
    public int getNumberOfDataPoint(){return numberOfDatapoint;}


    public int[] getValuesOfY() {
        return valuesOfY;
    }

    public void setValuesOfY(int[] valuesOfY) {
        this.valuesOfY = valuesOfY;
    }

    public int[] getValuesOfX() {
        return valuesOfX;
    }

    public void setValuesOfX(int[] valuesOfX){
        this.valuesOfX = valuesOfX;
    }

    public int[] calculateProductOfXAndY() {
        int[] productOfXAndY = new int[numberOfDatapoint];
        for (int count = 0; count < numberOfDatapoint; count++) {
            productOfXAndY[count] = valuesOfX[count] * valuesOfY[count];

        }
        return productOfXAndY;
    }
    public int[] calculateProductOfXandX(){
        int[] productOfXandX = new int[numberOfDatapoint];
        for (int count = 0; count < numberOfDatapoint; count++) {
            productOfXandX[count] = valuesOfX[count] * valuesOfX[count];
        }
        return productOfXandX;
    }
    public int getSumOfNumbers(int[] numbers){
        int sum = 0;
        for(int number : numbers){
            sum += number;
        }
        return sum;
    }

    public double calculateSlope(){
        int [] XY = calculateProductOfXAndY();
        int[] sumOfXandX = calculateProductOfXandX();
        int[] XandX =  calculateProductOfXandX();


        int upperCalculation = numberOfDatapoint * getSumOfNumbers(XY) - getSumOfNumbers(valuesOfY) * getSumOfNumbers(valuesOfX);
        int lowerCalculation = numberOfDatapoint * getSumOfNumbers(XandX) - getSumOfNumbers(valuesOfX) * getSumOfNumbers(valuesOfX);
        double slope = (double) upperCalculation / lowerCalculation;
        String formatedSlope = String.format("%.2f", slope);
        return Double.parseDouble(formatedSlope);

    }
    public double pointOfIntercept(){
        double slope = calculateSlope();
        double  intercept = (getSumOfNumbers(valuesOfY) - slope * getSumOfNumbers(valuesOfX)) / numberOfDatapoint;
        String formatedIntercept = String.format("%.2f", intercept);
        return Double.parseDouble(formatedIntercept);
    }
    public double checkLineOfIntercept(int x){

        return Double.parseDouble(String.format("%.2f", calculateSlope() * x +  pointOfIntercept()));


    }

    public String printTable(){
        int[] xy = calculateProductOfXAndY();
        int[] xx = calculateProductOfXandX();
        StringBuilder table = new StringBuilder();
        table.append("x\ty\txy\tx^2\tYn\n");
        double sum = 0;
        for(int count = 0; count < numberOfDatapoint; count++){
            table.append(valuesOfX[count]+ "\t" + valuesOfY[count] + " \t" + calculateProductOfXAndY()[count] + "\t" + calculateProductOfXandX()[count] + "\t" + checkLineOfIntercept(valuesOfX[count]) + "\n");
            sum += checkLineOfIntercept(valuesOfX[count]+ 1);
        }
        table.append("========================\n");
        table.append(getSumOfNumbers(valuesOfX) + "\t" + getSumOfNumbers(valuesOfY) + "\t"  + getSumOfNumbers(xy) + "\t" + getSumOfNumbers(xx) + "\t" + sum);
        return table.toString();
    }

}
