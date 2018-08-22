package flug.project.service.interfaces;

import java.util.Map;

public interface InterfaceWithMap<T, S, I> {

    Map<S, I> getAll();

    T create(T t, I id);
}
