package Repo;

public class MotelRepo {
    public static MotelRepo getInstance() {
        return new MotelRepo();
    }

    public String addMotel(String address){
        return "Done: " + address;
    }
}
