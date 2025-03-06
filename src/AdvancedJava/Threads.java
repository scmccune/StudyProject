package AdvancedJava;

import CoreJava.Util;

public class Threads {
     class Counter {
         int counter;

         public synchronized void increment() {
             counter++;
         }
     }
    Counter c = new Counter();

    class A extends Thread {
        String message;

        public A(String s) {
            message = s;
        }

        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(message);
                    sleep(20);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class B implements Runnable {
        @Override
        public void run() {
            System.out.println("In runnable class B");
        }
    }

    public Threads() {
        simpleThreading();
        runnable();
        raceConditions();
        
    }

    private void raceConditions() {
        Util.printHeader("Race Conditions");

        System.out.println("""
                Initial use of threading:
                class Counter {
                         int counter;
                
                         public void increment() {
                             counter++;
                         }
                     }
                
                Counter c = new Counter();
                        Runnable r1 = () ->{
                            {
                                for (int j = 0; j < 1000; j++) {
                                    c.increment();
                                }
                            }
                        };
                        Thread thread1 = new Thread(r1);
                        Thread thread2 = new Thread(r1);
                        thread1.start();
                        thread2.start();""");

        System.out.println("Initial result: 0  - This is getting to the end of the method before the threads kick in");
        Counter c = new Counter();
        Runnable r1 = () ->{
            {
                for (int j = 0; j < 1000; j++) {
                    c.increment();
                }
            }
        };
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r1);
        thread1.start();
        thread2.start();
        System.out.println("""
                Solution: Join the thread, this means it waits for them to finish
                try {
                    thread1.join();
                    thread2.join();
                } catch (InterruptedException e) {
                    System.out.println("Caught in interrupted exception");
                }""");
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Caught in interrupted exception");
        }
        System.out.println("Result is random - 2000, 1964, etc etc\n This is because the variable could be updated by 2 threads at the same and one disappears");
        System.out.println("""
                Third fix: Make the increment thread synchronized. This means only one thread can use it at a time
                         public synchronized void increment() {
                             counter++;
                         }""");
        System.out.println(c.counter); // random. 2000, 1964, ... ...

    }

    private void runnable() {
        Util.printHeader("Runnable");
        System.out.println("Thread extends runnable. For the same as above we could do");
        System.out.println("""
                    class B implements Runnable {
                        @Override
                        public void run() {
                            System.out.println("In runnable class B");
                        }
                    }\
               ...
                 B runnableThread = new B();
                 Thread t = new Thread(runnableThread);
                 t.start();""");
        B runnableThread = new B();
        Thread t = new Thread(runnableThread);
        t.start();

        System.out.println("Anonymous runnable");
        System.out.println("""
                        Runnable c = new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("I'm in anonymous runnable C");
                            }
                        };
                        Thread u = new Thread(c);
                        u.start();\
                """);
        Runnable c = new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm in anonymous runnable C");
            }
        };
        Thread u = new Thread(c);
        u.start();
        System.out.println("""
                Lambda thread:\s
                Runnable d = () -> System.out.println("I'm in anonymous runnable C");
                Thread v = new Thread(d);""");
        Runnable d = () -> System.out.println("I'm in anonymous runnable C");
        Thread v = new Thread(d);

        try {
            v.join();
            u.join();
        } catch (InterruptedException e) {
            System.out.println("Hit interrupted exception");
        }

    }

    private void simpleThreading() {
        Util.printHeader("Simple threading");

        System.out.println("""
                    class A extends Thread {
                        String message;
                
                        public A(String s) {
                            message = s; }
                
                        public void run() {
                            try {
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(message);
                                    sleep(20); }
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            } } }
                            ...
                            A threadOne = new A("Oh no we're in sheffield in the 80s");
                            A threadTwo = new A("They have dropped it! YAY!");
                            threadOne.start();
                            threadTwo.start();
                            try {
                                    threadOne.join();
                                    threadTwo.join();
                                } catch...\s
                            """);
        A threadOne = new A("Oh no we're in sheffield in the 80s");
        A threadTwo = new A("They have dropped it! YAY!");
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            System.out.println("Hit interrupted exception");
        }
    }
}
