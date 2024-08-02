package Controller;


import Repo.MotelRepo;

public class MotelController {
    public static MotelController getInstance() {
        return new MotelController();
    }

    public String addMotel(String address) {
        return MotelRepo.getInstance().addMotel(address);
    }
}
