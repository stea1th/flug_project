package flug.project.service;

public interface MainServiceInterface<T, S> {

    T saveIt(S... arr);

    T saveIt(T[] t, S...arr);
}
