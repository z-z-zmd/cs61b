package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void getN(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts,int n){
        opCounts.addLast(10000);
        Ns.addLast(n);


        AList<Integer> tmp = new AList<>();

        for(int i = 0; i<n;i++){
            tmp.addLast(i);
        }

        Stopwatch sw = new Stopwatch();

        int[] a = new int[10000];
        for(int i = 0;i<10000;i++){
            a[i] = tmp.getLast();
        }

        double time = sw.elapsedTime();


        times.addLast(time);

    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Integer> opCounts = new AList<>();
        AList<Double> times = new AList<>();

        int[] N = new int[]{1000,2000,4000,8000,16000,32000,64000,128000};
        for(int n : N){
            getN(Ns, times, opCounts,n);
        }


        printTimingTable(Ns, times, opCounts);

    }

}
