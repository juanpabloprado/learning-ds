package com.juanpabloprado.ds.queue;


public class App {
    public static void main(String[] args) {
        IntArrayQueue myIntArrayQueue = new IntArrayQueue(5);
        myIntArrayQueue.add(100);
        myIntArrayQueue.add(1000);
        myIntArrayQueue.add(14);
        myIntArrayQueue.add(12);
        myIntArrayQueue.add(14);
        System.out.println(myIntArrayQueue.peek()); // 100
        System.out.println(myIntArrayQueue);
        System.out.println(myIntArrayQueue.remove()); // 100
        System.out.println(myIntArrayQueue.peek()); // 1000

        System.out.println(myIntArrayQueue.remove()); // 1000
        System.out.println(myIntArrayQueue.remove()); // 14
        System.out.println(myIntArrayQueue.remove()); // 12
        System.out.println(myIntArrayQueue.remove()); // 14

        System.out.println(myIntArrayQueue.isEmpty()); // true

        benchMarkTest();
    }

    // BenchMark IntQueue vs ArrayDeque.
    private static void benchMarkTest() {

        int n = 10000000;
        IntArrayQueue intQ = new IntArrayQueue(n);

        // IntQueue times at around 0.0328 seconds
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) intQ.add(i);
        for (int i = 0; i < n; i++) intQ.remove();
        long end = System.nanoTime();
        System.out.println("IntQueue Time: " + (end - start) / 1e9);

        // ArrayDeque times at around 0.676 seconds
        java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();
//        java.util.ArrayDeque <Integer> arrayDeque = new java.util.ArrayDeque<>(n);
        start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayDeque.offer(i);
        for (int i = 0; i < n; i++) arrayDeque.poll();
        end = System.nanoTime();
        System.out.println("ArrayDeque Time: " + (end - start) / 1e9);
    }
}
