import java.util.*;

public class SetTest {
    public static void test1(){
        int N=1000000;
        Set<Double> treeset = new TreeSet<Double>();
        Set<Double> hashset = new HashSet<Double>();
        Long start, end;

        start = System.nanoTime();
        for(int i=0; i<N; i++) {
            treeset.add(Math.random());
        }
        end = System.nanoTime();
        System.out.println("TreeSet set: " + (end - start));


        start = System.nanoTime();
        for(int i=0; i<N; i++) {
            hashset.add(Math.random());
        }
        end = System.nanoTime();
        System.out.println("HashSet set: " + (end - start));

        start = System.nanoTime();
        for(int i=0; i<N; i++) {
            treeset.contains(Math.random());
        }
        end = System.nanoTime();
        System.out.println("TreeSet get: " + (end - start));

        start = System.nanoTime();
        for(int i=0; i<N; i++) {
            hashset.contains(Math.random());
        }
        end = System.nanoTime();
        System.out.println("HashSet get: " + (end - start));
    }

    public static void main(String[] args) {
    }
}
