package service;

import domain.Manager;

public interface AdminService {

    public boolean logIn(Manager manager);

    public boolean changePassword(Manager manager, String newPassword);

    public boolean findIDValid(Manager manager);

    public boolean addNewManager(Manager manager);
}
