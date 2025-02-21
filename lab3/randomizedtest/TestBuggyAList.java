package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void TestThreeAddMove(){
        AListNoResizing<Integer> list = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        list.addLast(3); buggyAList.addLast(3);
        list.addLast(4); buggyAList.addLast(4);
        list.addLast(5); buggyAList.addLast(5);

        int a = list.removeLast();int b = buggyAList.removeLast();
        assertTrue(a == b);
        a = list.removeLast();b = buggyAList.removeLast();
        assertTrue(a == b);
        a = list.removeLast();b = buggyAList.removeLast();
        assertTrue(a == b);
    }


    @Test
    public void RandomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();


        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                //L.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            }
            else if (operationNumber == 1) {
                // size
                //int size = L.size();
                //System.out.println("size: " + size);
                int size = B.size();
                System.out.println("size: " + size);

            }
            else if(operationNumber == 2 && L.size() >= 1) {
                //int r = L.removeLast();
                //System.out.println("removeLast(" + r + ")");
                int r = B.removeLast();
                System.out.println("removeLast(" + r + ")");
            }
        }
    }
}
