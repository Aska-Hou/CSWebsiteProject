package service;

import dao.ProfessorDao;
import domain.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    ProfessorDao professorDao;

    //    Professor Detail 显示
    @Override
    public Professor showProfessorDetail(Professor professor) {
        return professorDao.selectProfessorByID(professor);
    }

    //    Professor List 显示
    @Override
    public List<Professor> showProfessorList() {
        return professorDao.showAllProfessor();
    }


    @Override
    public List<Professor> searchProfessorList(Professor professor) {
        List<Professor> professors = new ArrayList<>();

        if (!professor.getName().equals("null")){
            professors = professorDao.selectProfessorByName(professor);
        }

        else if (professor.getProf_id() != 0) {
            professors.add(professorDao.selectProfessorByID(professor));
        }

        return professors;
    }
}
