package flug.project.repository.interfaces;

import java.util.List;

public interface MainIterface<T> {

    T save(T t);

    List<T> getAll();
}
