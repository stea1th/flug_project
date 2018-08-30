package flug.project.service;

public interface MainServiceInterface<T, S, I> {

    T create(T t, I id);

    T get(S... arr);
}
