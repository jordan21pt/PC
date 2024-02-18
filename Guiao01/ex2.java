// Ex2/EX3 - Esta solução resolve o problema do "data race" 
// criado no exercicio 3, usando synchronized do java. 
// Esta solução aborda apenas a versão que invoca 
// um método "increment"... 

class Counter {
    private int limit;
    private int contador = 0;

    public Counter(int limit) {
        this.limit = limit;
    }

    public synchronized void increment() {
        for (int i = 1; i <= limit; i++) {
            contador++;
        }
    }

    public int getContador() {
        return contador;
    }

}

public class ex2 {
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]); // Numero de threads
        int I = Integer.parseInt(args[1]); // Numero de iteracoes

        Counter counter = new Counter(I);

        Thread[] a = new Thread[N];

        for (int i = 0; i < N; i++) {
            a[i] = new Thread(() -> {
                counter.increment();
            });
            a[i].start();
        }

        try {
            for (int i = 0; i < N; i++) {
                a[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println(counter.getContador());
    }
}
