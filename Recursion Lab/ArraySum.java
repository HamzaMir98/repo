
/**
 *
 * @author
 */
public class ArraySum {

    public int sumOfArray(Integer[] myArray, int index) {
        // bad case , out of bound
        if (myArray.length <= index || index < 0) {
            return 0;
        }
        // basic case
        if (index <= 0) {
            return myArray[0];
        }

        // normal case
        // reduce index by one
        return myArray[index] + sumOfArray(myArray, index - 1);
    }

    public long fibonacci(int n) {

        // F0 = 1, F1 = 1
        if (n <= 1) {
            return 1;
        }
        // Fn = Fn-1 + Fn-2
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public long fibonacci(int n, long[] value) {
        // base case 
        if (n <= 1) {
            return 1;
        }
        // this value has been calculated 
        if (value[n] != 0) {
            return value[n];
        }
        
        // update Fn-1
        if (value[n - 1] == 0) {
            value[n - 1] = fibonacci(n - 1, value);
        }
        // update Fn-2
        if (value[n - 2] == 0) {
            value[n - 2] = fibonacci(n - 2, value);
        }
        
        // update Fn
        value[n] = value[n - 1] + value[n - 2];
        return value[n];
    }

}
