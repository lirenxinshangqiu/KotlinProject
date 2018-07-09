package test;

/**
 * Created by ls on 18/7/2.
 */
public class SingletonTest {

    /**
     * 单例，懒汉，线程安全
     */
    public static class Singleton {
        private final static Singleton INSTANCE = new Singleton();

        private Singleton() {
        }

        public static Singleton getInstance() {
            return INSTANCE;
        }
    }

    /**
     * 单例，饿汉，线程不安全
     */
    public static class Singleton1 {
        private static Singleton1 INSTANCE = null;

        private Singleton1() {
        }

        public static Singleton1 getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new Singleton1();
            }
            return INSTANCE;
        }
    }

    /**
     * 单例，饿汉，线程安全，多线程效率不高
     */
    public static class Singleton2 {
        private static Singleton2 INSTANCE = null;

        private Singleton2() {
        }

        public static synchronized Singleton2 getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new Singleton2();
            }
            return INSTANCE;
        }
    }

    /**
     * 懒汉，变种，线程安全
     */
    public static class Singleton3 {
        private static Singleton3 INSTANCE = null;

        static {
            INSTANCE = new Singleton3();
        }

        private Singleton3() {
        }

        public static Singleton3 getInstance() {
            return INSTANCE;
        }
    }

    /**
     * 单例，静态内部类线程安全
     */

    public static class Singleton4 {
        private static class SingletonHolder {
            private static final Singleton4 INSTANCE = new Singleton4();
        }

        public static Singleton4 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 使用枚举，线程安全
     */
    public enum Singleton5 {
        INSTANCE;

        public void whateverMethod() {

        }
    }

    /**
     * 静态内部类，使用双重校验锁，线程安全
     */
    public static class Singleton6 {
        private volatile static Singleton6 instance = null;

        private Singleton6() {
        }

        public static Singleton6 getInstance() {
            if (instance == null) {
                synchronized (Singleton6.class) {
                    if (instance == null) instance = new Singleton6();
                }
            }
            return instance;
        }

    }
}
