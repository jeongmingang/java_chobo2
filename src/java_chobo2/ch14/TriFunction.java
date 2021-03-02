package java_chobo2.ch14;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
	R appliy(T t, U u, V v);
}
