package flug.project.repository.interfaces;

import java.util.List;

public interface MainRepositoryInterface<T, S, I> {

    T save(T t, S... arr);

    List<I> getAll();
}
