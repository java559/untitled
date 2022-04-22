package Java8新特性.StreamAPI;

import Java8新特性.方法引用与构造器引用.Employee;
import Java8新特性.方法引用与构造器引用.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.*;

public class StreamAPITest {
    //通过集合
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    //通过数组
    @Test
    public void test2() {
        //调用Arrays类的static <T> Stream<T> stream(T[] array) : 返回一个流

        /**
         * Returns a sequential {@link Stream} with the specified array as its
         * source.
         *
         * @param <T> The type of the array elements
         * @param array The array, assumed to be unmodified during use
         * @return a {@code Stream} for the array
         * @since 1.8
         */
//        public static <T> Stream<T> stream(T[] array) {
//            return stream(array, 0, array.length);
//        }


        int[] arr = {1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "tom");
        Employee e2 = new Employee(1002, "jerry");
        Employee[] employees = {e1, e2};
        Stream<Employee> stream1 = Arrays.stream(employees);
    }

    //通过Stream的of()
    @Test
    public void test3() {
        //public static<T> Stream<T> of(T... values) : 返回一个流

        /**
         * Returns a sequential ordered stream whose elements are the specified values.
         *
         * @param <T> the type of stream elements
         * @param values the elements of the new stream
         * @return the new stream
         */
//        @SafeVarargs
//        @SuppressWarnings("varargs") // Creating a stream from an array is safe
//        public static<T> Stream<T> of(T... values) {
//            return Arrays.stream(values);
//        }

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    //创建无限流
    @Test
    public void test4() {
        //迭代
        /**
         * Returns an infinite sequential ordered {@code Stream} produced by iterative
         * application of a function {@code f} to an initial element {@code seed},
         * producing a {@code Stream} consisting of {@code seed}, {@code f(seed)},
         * {@code f(f(seed))}, etc.
         *
         * <p>The first element (position {@code 0}) in the {@code Stream} will be
         * the provided {@code seed}.  For {@code n > 0}, the element at position
         * {@code n}, will be the result of applying the function {@code f} to the
         * element at position {@code n - 1}.
         *
         * @param <T> the type of stream elements
         * @param seed the initial element
         * @param f a function to be applied to to the previous element to produce
         *          a new element
         * @return a new sequential {@code Stream}
         */
//        public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f) {
//            Objects.requireNonNull(f);
//            final Iterator<T> iterator = new Iterator<T>() {
//                @SuppressWarnings("unchecked")
//                T t = (T) Streams.NONE;
//
//                @Override
//                public boolean hasNext() {
//                    return true;
//                }
//
//                @Override
//                public T next() {
//                    return t = (t == Streams.NONE) ? seed : f.apply(t);
//                }
//            };
//            return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
//                    iterator,
//                    Spliterator.ORDERED | Spliterator.IMMUTABLE), false);
//        }
        //遍历前十个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);


        //生成
        /**
         * Returns an infinite sequential unordered stream where each element is
         * generated by the provided {@code Supplier}.  This is suitable for
         * generating constant streams, streams of random elements, etc.
         *
         * @param <T> the type of stream elements
         * @param s the {@code Supplier} of generated elements
         * @return a new infinite sequential unordered {@code Stream}
         */
//        public static<T> Stream<T> generate(Supplier<T> s) {
//            Objects.requireNonNull(s);
//            return StreamSupport.stream(
//                    new StreamSpliterators.InfiniteSupplyingSpliterator.OfRef<>(Long.MAX_VALUE, s), false);
//        }
        //生成十个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}
