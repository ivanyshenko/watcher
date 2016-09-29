package watcher;

/**
 * Created by alex on 28.09.2016.
 */
public class StorageFactory {
    private static StorageFactory ourInstance = new StorageFactory();

    public static StorageFactory getInstance() {
        return ourInstance;
    }

    private StorageFactory() {
        System.out.println("create StorageFactory");
    }

    public Storage getStorage(int storageCode, String storagePath) {
        switch (storageCode) {
            case 0: {
                System.out.println("storageFactory gave database manager with path" + storagePath);
                return new DatabaseManager(storagePath);
            }
            case 1: {
                System.out.println("storageFactory gave CSVmanager with file" + storagePath);
                return new CSVManager(storagePath);
            }
            default: {
                return null;
            }
        }

    }
}
