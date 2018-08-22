package flug.project.repository.interfaces;

import java.util.List;

public interface InterfaceForList<T, S, I> {

    T save(T t, S... arr);

    List<I> getAllIds();
}
