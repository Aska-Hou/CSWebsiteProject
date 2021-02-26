package service;

import dao.ManagerDao;
import domain.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    public ManagerDao managerDao;

    @Override
    public boolean logIn(Manager manager) {
        Manager result = managerDao.selectManagerByID(manager);
        if (result != null) {
            manager.setName(result.getName());
            manager.setPassword(null);
            return true;
        } else return false;
    }

    @Override
    public boolean changePassword(Manager manager, String newPassword) {
//        先检查manager的原密码是否正确
        boolean selectResult = logIn(manager);
        if (selectResult) {
            manager.setPassword(newPassword);
            Integer updateResult = managerDao.updatePasswordByID(manager);
            if (updateResult == 1)
                return true;
        }
        return false;
    }

    @Override
    public boolean findIDValid(Manager manager) {
        Manager resultManager = managerDao.selectManagerByID(manager);
        if (resultManager == null)
            return true;
        else
            return false;
    }

    @Override
    public boolean addNewManager(Manager manager) {
        Integer result = managerDao.insertNewManager(manager);
        if (result == 1)
            return true;
        else return false;
    }
}
