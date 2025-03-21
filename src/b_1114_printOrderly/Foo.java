package b_1114_printOrderly;

import java.util.concurrent.CountDownLatch;

/**
 * 顺序打印：CountDownLatch 实现
 */
public class Foo {

    CountDownLatch first = new CountDownLatch(1);
    CountDownLatch second = new CountDownLatch(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        first.await();
        printSecond.run();
        second.countDown();
        // printSecond.run() outputs "second". Do not change or remove this line.
    }

    public void third(Runnable printThird) throws InterruptedException {
        second.await();
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        foo.third(() -> System.out.println("third"));

        foo.first(() -> System.out.println("first"));

        foo.second(() -> System.out.println("second"));

    }
}
