// Write a Java program to create five
// threads with different priorities.
// Send two threads of the highest priority
// to sleep state. Check the aliveness of the threads and
// mark which thread is long lasting.

class MyThread implements Runnable{
    static String last;
    String name;
    Thread t;

    MyThread(String a, int b) {
        name = a;
        t = new Thread(this, name);
        t.setPriority(b);
        System.out.println(name + " started");
        System.out.println("New Thread: " + t);
        t.start();
    }

    public void run() {
        try {
            if(t.getPriority() == 9 || t.getPriority() == 10) {
                Thread.sleep(1000);
                System.out.println(t.getName() + " is going to sleep");
            }

            for(int i = 0; i < 5; i++) {
                System.out.println(name + ": " + i);
                Thread.sleep(500);
            }
        }

        catch(InterruptedException e) {
            System.out.println(name + " thread interrupted");
        }
        last = name;
        System.out.println(name + " existing");
    }
}

class Multithreading {
    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        MyThread m1 = new MyThread("One", Thread.NORM_PRIORITY - 1);
        MyThread m2 = new MyThread("Two", Thread.MAX_PRIORITY);
        MyThread m3 = new MyThread("Three", Thread.NORM_PRIORITY + 2);
        MyThread m4 = new MyThread("Four", Thread.NORM_PRIORITY + 4);
        MyThread m5 = new MyThread("Five", Thread.MIN_PRIORITY + 1);

        try {
            Thread.sleep(500);
        } catch(InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Is thread 1 alive? " + m1.t.isAlive());
        System.out.println("Is thread 2 alive? " + m2.t.isAlive());
        System.out.println("Is thread 3 alive? " + m3.t.isAlive());
        System.out.println("Is thread 4 alive? " + m4.t.isAlive());
        System.out.println("Is thread 5 alive? " + m5.t.isAlive());

        try {
            System.out.println("Waiting for threads to finish");
            m1.t.join();
            m2.t.join();
            m3.t.join();
            m4.t.join();
            m5.t.join();
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted");
        }

        System.out.println("Is thread 1 alive? " + m1.t.isAlive());
        System.out.println("Is thread 2 alive? " + m2.t.isAlive());
        System.out.println("Is thread 3 alive? " + m3.t.isAlive());
        System.out.println("Is thread 4 alive? " + m4.t.isAlive());
        System.out.println("Is thread 5 alive? " + m5.t.isAlive());
        System.out.println();

        System.out.println("Priority of 1: " + m1.t.getPriority());
        System.out.println("Priority of 2: " + m2.t.getPriority());
        System.out.println("Priority of 3: " + m3.t.getPriority());
        System.out.println("Priority of 4: " + m4.t.getPriority());
        System.out.println("Priority of 5: " + m5.t.getPriority());
        System.out.println();

        System.out.println(MyThread.last + " is the longest lasting thread");
    }
}
