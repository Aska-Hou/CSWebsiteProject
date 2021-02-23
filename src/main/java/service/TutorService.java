package service;

import domain.Tutor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface TutorService {

    //    展示所有tutor
    public List<Tutor> showTutorList();

    //    根据ID展示tutor detail
    public Tutor showTutorDetail(Tutor tutor);

    //    管理员账户根据关键词搜索tutor
    public List<Tutor> searchTutorList(Tutor tutor);

    //    加入新的tutor
    public Tutor addNewTutor(MultipartFile img, Tutor tutor);

    //    更新tutor信息
    public boolean updateTutor(MultipartFile img, Tutor tutor);

    //    删除所选tutor
    public boolean deleteSelectedTutor(Map<String, String[]> paraMap);

    //    删除单个tutor
    public boolean deleteOneTutor(Tutor tutor);
}
