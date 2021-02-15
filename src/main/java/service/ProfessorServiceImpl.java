package service;

import dao.ProfessorDao;
import domain.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


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

    //  Professor 关键词搜索
    @Override
    public List<Professor> searchProfessorList(Professor professor) {
        List<Professor> professors = new ArrayList<>();

        if (!professor.getName().equals("null")) {
            professors = professorDao.selectProfessorByName(professor);
        } else if (professor.getProf_id() != 0) {
            professors.add(professorDao.selectProfessorByID(professor));
        }

        return professors;
    }


    //   新加入 Professor
    @Override
    public Professor addNewProfessor(MultipartFile img, Professor professor) {
        //  保存照片
        String basePath = "D:\\WEB-IMG\\CSWebsite\\";
        String uuid = UUID.randomUUID().toString();
        professor.setPhoto("ProfImg/" + uuid + ".png");
        try {
            img.transferTo(new File(basePath + professor.getPhoto()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  向数据库插入新professor的所有信息
        Integer result = professorDao.insertProfessor(professor);
        System.out.println("Professor id: " + professor.getProf_id());
        if (result == 1) {
            return professor;
        } else return null;
    }


    //  更新professor信息
    @Override
    public boolean updateProfessor(MultipartFile img, Professor professor) {
        Integer result = 0;

        //  如果图片不为空，保存照片且删除之前的照片
        if (img.getSize() != 0) {
            String basePath = "D:\\WEB-IMG\\CSWebsite\\";
            File originFile = new File(basePath + professor.getPhoto());
            originFile.delete();
            String uuid = UUID.randomUUID().toString();
            professor.setPhoto("ProfImg/" + uuid + ".png");
            try {
                img.transferTo(new File(basePath + professor.getPhoto()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = professorDao.updateAllProfessorByID(professor);
        }
        //  如果图片为空，不改变图片
        else {
            result = professorDao.updatePartProfessorByID(professor);
        }

        if (result == 1) {
            return true;
        }
        else
            return false;
    }
}
