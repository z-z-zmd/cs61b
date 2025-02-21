package timingtest;
import afu.org.checkerframework.checker.igj.qual.I;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void addN(AList<Integer> Ns,AList<Double> times,AList<Integer> opCounts,int n) {
        AList<Integer> tmp = new AList<>();

        Ns.addLast(n);
        opCounts.addLast(n);

        Stopwatch sw = new Stopwatch();

        for(int i = 0;i<n;i++){
            tmp.addLast(i);
        }

        double timeinsecond = sw.elapsedTime();
        times.addLast(timeinsecond);

    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE\
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int[] N = new int[]{1000,2000,4000,8000,16000,32000,64000,128000,100000000};
        for (int n : N) {
            addN(Ns, times, opCounts, n);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
