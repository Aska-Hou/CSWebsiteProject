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
}
