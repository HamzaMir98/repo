
public class ArraySumDriver {

    private final static int ARRAY_SIZE = 6;

    /**
     * @param args
     */
    public static void main(String[] args) {
        int index = 0;

        Integer[] myArray = new Integer[ARRAY_SIZE];
        ArraySum arraySum = new ArraySum();

        myArray[index++] = 3;
        myArray[index++] = 5;
        myArray[index++] = 2;
        myArray[index++] = 6;

        int sum = arraySum.sumOfArray(myArray, 3);
        System.out.println(sum);

        myArray[index++] = 7;
        myArray[index++] = 1;

        sum = arraySum.sumOfArray(myArray, 5);
        System.out.println(sum);
        
        
        System.out.println("Fibonancci: ");
        System.out.println("F(6) = " + arraySum.fibonacci(6) );
        
        long [] value = new long[10];
        
        System.out.println("F(6) = " + arraySum.fibonacci(6, value) );
        
    }

}
