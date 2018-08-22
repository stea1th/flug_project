package flug.project.service.interfaces;

import java.util.Map;

public interface MainServiceInterface<T, S, I> {

    Map<S, I> getAll();

    T create(T t, I id);
}
