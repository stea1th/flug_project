package flug.project.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class CountUtil {

    private static final AtomicInteger COUNT = new AtomicInteger(4);
    public static int getNewId(){
        return COUNT.incrementAndGet();
    }
}
