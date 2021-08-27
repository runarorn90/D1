package Base;
import edu.princeton.cs.algs4.*;

public class CouponCollectorStats {
    private double[] times;
    private int coupons;

    public CouponCollectorStats(int N, int T) {
        times = new double[T];
        for (int i = 0; i < T; i++) {
            Stopwatch timer = new Stopwatch();
            coupons = CouponCollectorStats.couponCollectorTest(N);
            times[i] = timer.elapsedTime();
        }
    }

    public double mean() {
        return StdStats.mean(times);
    }

    public double stddev() {
        return StdStats.stddev(times);
    }


    public static int couponCollectorTest(int N) {
        //perform experiment
        //returns: number of random tries
        boolean[] coupon = new boolean[N];
        int count = 0;
        int tries = 0;
        while (count < N) {// counter under max number
            int x = StdRandom.uniform(N);
            if (!coupon[x]) {
                coupon[x] = true;
                count++;
            }
            tries++;
        }
        return tries;
    }

    public static void main(String[] args) {
        // Testing in part a
        Stopwatch timer = new Stopwatch();
        int coupons = CouponCollectorStats.couponCollectorTest(100000);
        double time = timer.elapsedTime();
        StdOut.println(time);
        StdOut.println(coupons);

        // Testing in part b
        for (int try_num = 10;try_num <= 1000;try_num = try_num*10) {
            int coupon_num = 100000;
            Stopwatch timerB = new Stopwatch();
            CouponCollectorStats test = new CouponCollectorStats(coupon_num, try_num);
            double timeB = timerB.elapsedTime();
            StdOut.println("Testing N=" + coupon_num + ", T=" + try_num);
            StdOut.println("Total timer: " + timeB);
            StdOut.println("Mean time: " + test.mean());
            StdOut.println("StdDev time: " + test.stddev());
            StdOut.println();
        }
    }
}
