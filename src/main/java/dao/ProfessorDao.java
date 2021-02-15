package dao;

import domain.Professor;

import java.util.List;

public interface ProfessorDao {

    //    查询所有的Professor, 返回List
    public List<Professor> showAllProfessor();

    //    根据Professor ID查询Professor
    public Professor selectProfessorByID(Professor professor);

    //    根据professor name查询professor
    public List<Professor> selectProfessorByName(Professor professor);

    //    插入新professor
    public Integer insertProfessor(Professor professor);

    //    根据professor id更新信息（不保存图片）
    public Integer updatePartProfessorByID(Professor professor);

    //    根据professor id更新信息（保存图片）
    public Integer updateAllProfessorByID(Professor professor);

}
