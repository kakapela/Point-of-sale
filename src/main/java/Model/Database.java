package Model;

public class Database {
    private  static Database instance =new Database();

    private Database(){}

    public static Database getInstance() {
        return instance;
    }
    public void connect(){}
    public void disconnect(){}
}
