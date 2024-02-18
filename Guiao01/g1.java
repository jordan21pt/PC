/*
class Counter{
    int i = 0;
}
*/

class CounterV2 {
    private int i = 0;
    void inc(){ i++; }
    int value(){ return i; }
}


class Incrementer extends Thread {
    final int I;
    final Counter c;
    public Incrementer(int I, Counter c){
        this.I = I;
        this.c = c;
    }
    public void run() {
        c = new Counter();
        for (long i = 0; i < I; i++){
            //c.i += 1;
            c.inc()
        }
    }
}

class g1 {
  
    public static void main(String[] args) throws InterruptedException {

        int N = 3; // Integer.parseInt(args[0]);
        int I = 10; // Integer.parseInt(args[1]);

        Incrementer[] a = new Incrementer[N];
        Counter c = new Counter();
        for (int i = 0; i < N; i++) {
            a[i] = new Incrementer(I, c);
            a[i].start();
        }

        for (int i = 0; i < N; i++) {
            a[i].join();
        }

        System.out.println(c.i);
    }
}