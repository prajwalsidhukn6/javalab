// Write a multi threaded Java program
// to implement producer-consumer problem.

class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while(!valueSet) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println("InterruptedException Caught");
            }
        }

        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while(valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException Caught");
            }
        }

        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}

class Producer implements Runnable {
    Q q;

    Thread t;
    Producer(Q q) {
        this.q = q;
        t = new Thread(this, "Producer");
        t.start();
    }

    public void run() {
        int i = 0;
        while(true) {
            q.put(i++);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException Caught");
            }
        }
    }
}

class Consumer implements Runnable {
    Q q;

    Thread t;
    Consumer(Q q) {
        this.q = q;
        t = new Thread(this, "Consumer");
        t.start();
    }

    public void run() {
        while(true) {
            q.get();

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException Caught");
            }
        }
    }
}

class PandC {
    public static void main(String[] args) {
        System.out.println("Press ctrl + c to stop yhe program");
        Q q = new Q();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);
    }
}
