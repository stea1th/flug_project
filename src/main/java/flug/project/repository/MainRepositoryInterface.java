package flug.project.repository;

import java.util.List;

public interface MainRepositoryInterface<T, S, I> {

    T save(T t, S... arr);

    List<T> get(I... arr);

    T getById(I... arr);
}
