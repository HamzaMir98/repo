import java.util.*;

interface  QueueInterface <T> {

  /** new entry is added to the back of the queue.
  * @param newEntry */
  public void  enqueue (T newEntry);

  /** eleminates and return back the entry at the queue front.
  * @return either the element at the queue front or, if the
  * queue is empty, then null */
  public T dequeue ();
 
  /** Retrieves the entry at the queue front.
  * @return either the element at the queue front or, if the
  * queue is empty, then null */
  public T getFront ();
 
  /** identifies empty queue.
  * @return if the queue is empty then return true, otherwise false */
  public boolean isEmpty ();
 
  /** eliminates all entries from the queue. */
  public void  clear ();
}

class LinkedQueue < T > implements QueueInterface < T > , java.io.Serializable
{
    private Node firstNode;
    private Node lastNode;  

    public LinkedQueue ()
    {
        firstNode = null;
        lastNode = null;
    }


    public void enqueue (T newEntry)
    {
        Node newNode = new Node (newEntry, null);
        if (isEmpty ())
            firstNode = newNode;
        else
            lastNode.setNextNode (newNode);
        lastNode = newNode;
    } // end enqueue


    public T getFront ()
    {
        T front = null;
        if (!isEmpty ())
            front = firstNode.getData ();
        return front;
    } // end getFront


    public T dequeue ()
    {
        T front = null;
        if (!isEmpty ())
        {
            front = firstNode.getData ();
            firstNode = firstNode.getNextNode ();
            if (firstNode == null)
                lastNode = null;
        } // end if
        return front;
    } // end dequeue


    public boolean isEmpty ()
    {
        return (firstNode == null) && (lastNode == null);
    } // end isEmpty


    public void clear ()
    {
        firstNode = null;
        lastNode = null;
    } // end clear

    private class Node implements java.io.Serializable
    {
        private T data; // entry in queue
        private Node next; // link to next node

       // Constructors
        public Node(T inData,Node inNext) {
                setData(inData);
                setNextNode(inNext);
        }

        public T getData() { return data; }
        public void setData(T inData) { data = inData; }
        public Node getNextNode() { return next; }
        public void setNextNode(Node inNext) { next = inNext; }
    } // end Node
} // end LinkedQueue

public class WaitLine {

    // class instance variables
    private QueueInterface < Customer > line;
    private int numberOfArrivals;
    private int numberServed;
    private int totalTimeWaited;
    
    // constructor
    public WaitLine () {
        line = new LinkedQueue<Customer>();
        reset ();
    }

    /** waiting line simulation with single serving customer.
    * duration : simulated minutes
    * arrivalProbability : the cutomer arrival probability at a given time
    * maxTransactionTime :the maximum transaction time for a specific customer */

    // main business logic
    public void simulate (int duration, double arrivalProbability,int maxTransactionTime) {

      int transactionTimeLeft = 0;
      for(int clock=0; clock<duration; clock++){

        if (Math.random()<arrivalProbability) {

          numberOfArrivals++;
          int transactionTime = (int)(Math.random() * maxTransactionTime + 1);
          Customer nextArrival = new Customer(clock,transactionTime,numberOfArrivals);
          line.enqueue (nextArrival);
          System.out.println("Customer " + numberOfArrivals+ " enters line at time " + clock
                            + ". Transaction time is " + transactionTime);
        } // end if

        if (transactionTimeLeft > 0){

          transactionTimeLeft--;

        }else if(!line.isEmpty ()){
          Customer nextCustomer = line.dequeue ();
          transactionTimeLeft = nextCustomer.getTransactionTime () - 1;
          int timeWaited = clock - nextCustomer.getArrivalTime ();
          totalTimeWaited = totalTimeWaited + timeWaited;
          numberServed++;
          System.out.println ("Customer " + nextCustomer.getCustomerNumber()
                        + " begins service at time " + clock+ ". Time waited is " + timeWaited);
         } // end if
      } // end for
    } // end simulate


    /* Displays summary results of the simulation. */
    public void displayResults() {

      System.out.println ();
      System.out.println ("Number served = " + numberServed);
      System.out.println ("Total time waited = " + totalTimeWaited);
      double averageTimeWaited = ((double) totalTimeWaited) / numberServed;
      System.out.println ("Average time waited = " + averageTimeWaited);
      int leftInLine = numberOfArrivals - numberServed;
      System.out.println ("Number left in line = " + leftInLine);

    } // end displayResults


    /* Initializes the simulation. */
    public final void reset() {

      line.clear ();
      numberOfArrivals = 0;
      numberServed = 0;
      totalTimeWaited = 0;

    } // end reset

    public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      WaitLine wl = new WaitLine();

      System.out.print("Enter the total duration of Customers: ");
      int duration = sc.nextInt();
      System.out.print("Enter the arrival probability of Customers: ");
      double probability = sc.nextDouble();
      System.out.print("Enter the maximum transaction time for each customer: ");
      int maxTime = sc.nextInt();
      wl.simulate(duration,probability,maxTime);
      wl.displayResults();
    }
} // end WaitLine

// customer class
class Customer {

  // clas instance variables
  private int arrivalTime;
  private int transactionTime;
  private int customerNumber;

  // constructor
  public Customer (int clockTime,int transTime,int custNumber) {
        arrivalTime = clockTime;
        transactionTime = transTime;
        customerNumber = custNumber;
  }
 
  // getters
  public int getArrivalTime() {
    return arrivalTime;
  }

  public int getTransactionTime() {
    return transactionTime;
  }

  public int getCustomerNumber() {
    return customerNumber;
  }
}
