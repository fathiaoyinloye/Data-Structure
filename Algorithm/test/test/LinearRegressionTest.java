package test;

import algorithms.LinearRegression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinearRegressionTest {
    LinearRegression linearRegression;

    @BeforeEach
    public void setUp() {
        int[] y = {40,55,65,80};
        int[] x = {1,2,3,4};
        linearRegression = new LinearRegression(4, y, x);
    }

    @Test
    public void testThatNumberOfDataPointIsKnown(){
        assertEquals(4, linearRegression.getNumberOfDataPoint());
    }
    @Test
    public void testThatValuesOfYCanBeSet(){
        int[] y = {40,55,65,80};
        assertArrayEquals(y,linearRegression.getValuesOfY());

    }
    @Test
    public void testThatValuesOfXCanBeSet(){
        int[] x = {1,2,3,4};
        assertArrayEquals(x,linearRegression.getValuesOfX());

    }

    @Test
    public void calculateProductOfXAndY_resultIsProductOfXAndY(){
        int[] productOfXAndY = {40,110,195,320};
        assertArrayEquals(productOfXAndY,linearRegression.calculateProductOfXAndY());

    }

    @Test
    public void calculateproductOfXandX_resultIsProductOfXAndX(){
        int[] productOfXandX = {1, 4, 9, 16};
        assertArrayEquals(productOfXandX,linearRegression.calculateProductOfXandX());

    }

    @Test
    public  void calculateSumOfX_resultIsSumOfX(){
        int [] numbers = linearRegression.getValuesOfX();
        assertEquals(10, linearRegression.getSumOfNumbers(numbers));
    }
    @Test
    public  void calculateSumOfXY_resultIsSumOfXY(){
        int [] numbers = linearRegression.calculateProductOfXAndY();
        assertEquals(665, linearRegression.getSumOfNumbers(numbers));
    }
    @Test
    public  void calculateSumOfXandX_resultIsSumOfXandX(){
        int [] numbers = linearRegression.calculateProductOfXandX();
        assertEquals(30, linearRegression.getSumOfNumbers(numbers));
    }
    @Test
    public void testThatSlopeOfTheRegressionCanBeCalculated(){
        assertEquals(13.00, linearRegression.calculateSlope());

    }
    @Test
    public void testThatPointOfInterceptionCanBeCalculated(){
       assertEquals(27.5, linearRegression.pointOfIntercept());
    }
    @Test
    public void checkLineOfBestFit(){
        System.out.print(linearRegression.printTable());
        assertEquals(40.5, linearRegression.checkLineOfIntercept(1));

    }

}