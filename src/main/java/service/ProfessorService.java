package service;

import domain.Professor;

import java.util.List;

public interface ProfessorService {

    //    展示所有professor
    public List<Professor> showProfessorList();

    //    根据ID展示professor detail
    public Professor showProfessorDetail(Professor professor);

    //    管理员账户根据关键词搜索professor
    public List<Professor> searchProfessorList(Professor professor);

    //    加入新的professor
    public Professor addNewProfessor(Professor professor);
}
