package flug.project.repository.interfaces;


import java.util.List;

public interface MainInterfaceWithArg<T, S> {


    T save(T t, S... arr);

    List<T> getAll();
}
