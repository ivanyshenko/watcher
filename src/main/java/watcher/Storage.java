package watcher;

/**
 * Created by alex on 28.09.2016.
 */
public interface Storage {
    public void append(Vacation vacation) throws Exception;

    public void closeConnection();
}
