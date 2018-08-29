package flug.project.service;

import java.util.List;
import java.util.Map;

public interface MainServiceInterface<T, S, I> {

    T create(T t, I id);

    T get(S... arr);
}
