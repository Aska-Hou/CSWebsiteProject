package dao;

import domain.Manager;

public interface ManagerDao {

    public Manager selectManagerByIDAndPW(Manager manager);

    public Integer updatePasswordByID(Manager manager);

    public Integer insertNewManager(Manager manager);

    public Manager selectManagerByID(Manager manager);

}
