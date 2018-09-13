package flug.project.service;


@SuppressWarnings("unchecked")
public interface MainServiceInterface<T, S> {
    T saveIt(S... arr);
    T saveIt(T[] t, S...arr);
}


