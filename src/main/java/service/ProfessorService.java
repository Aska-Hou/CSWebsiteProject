package service;

import domain.Professor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ProfessorService {

    //    展示所有professor
    public List<Professor> showProfessorList();

    //    根据ID展示professor detail
    public Professor showProfessorDetail(Professor professor);

    //    管理员账户根据关键词搜索professor
    public List<Professor> searchProfessorList(Professor professor);

    //    加入新的professor
    public Professor addNewProfessor(MultipartFile img, Professor professor);

    //    更新professor信息
    public boolean updateProfessor(MultipartFile img, Professor professor);

    //    删除所选professor
    public boolean deleteSelectedProfessor(Map<String, String[]> paraMap);

    //    删除单个professor
    public boolean deleteOneProfessor(Professor professor);
}
