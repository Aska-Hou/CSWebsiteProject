package service;

import dao.TutorDao;
import domain.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;


@Service
public class TutorServiceImpl implements TutorService {

    @Autowired
    TutorDao tutorDao;

    //    Tutor Detail 显示
    @Override
    public Tutor showTutorDetail(Tutor tutor) {
        return tutorDao.selectTutorByID(tutor);
    }

    //    Tutor List 显示
    @Override
    public List<Tutor> showTutorList() {
        return tutorDao.showAllTutor();
    }

    //  Tutor 关键词搜索
    @Override
    public List<Tutor> searchTutorList(Tutor tutor) {
        List<Tutor> tutors = new ArrayList<>();

        if (!tutor.getName().equals("null")) {
            tutors = tutorDao.selectTutorByName(tutor);
        } else if (tutor.getTutor_id() != 0) {
            tutors.add(tutorDao.selectTutorByID(tutor));
        }

        return tutors;
    }


    //   新加入 Tutor
    @Override
    public Tutor addNewTutor(MultipartFile img, Tutor tutor) {
        //  保存照片
        String basePath = "CSWebsite/";
        String uuid = UUID.randomUUID().toString();
        tutor.setPhoto("TutorImg/" + uuid + ".png");
        try {
            img.transferTo(new File(basePath + tutor.getPhoto()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  向数据库插入新tutor的所有信息
        Integer result = tutorDao.insertTutor(tutor);
        System.out.println("Tutor id: " + tutor.getTutor_id());
        if (result == 1) {
            return tutor;
        } else return null;
    }


    //  更新tutor信息
    @Override
    public boolean updateTutor(MultipartFile img, Tutor tutor) {
        Integer result = 0;

        //  如果图片不为空，保存照片且删除之前的照片
        if (img.getSize() != 0) {
            tutor.setPhoto(tutorDao.selectTutorByID(tutor).getPhoto());
            String basePath = "CSWebsite/";
            deleteTutorPhoto(tutor);
            String uuid = UUID.randomUUID().toString();
            tutor.setPhoto("TutorImg/" + uuid + ".png");
            try {
                img.transferTo(new File(basePath + tutor.getPhoto()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = tutorDao.updateAllTutorByID(tutor);
        }
        //  如果图片为空，不改变图片
        else {
            result = tutorDao.updatePartTutorByID(tutor);
        }

        if (result == 1) {
            return true;
        } else
            return false;
    }


    //    删除所选tutor
    @Override
    public boolean deleteSelectedTutor(Map<String, String[]> paraMap) {
        Set<String> keySet = paraMap.keySet();
        List<Tutor> tutors = new ArrayList<>();
        for (String key : keySet) {
            String choice = paraMap.get(key)[0];
            if ("on".equals(choice)) {
                Tutor tutor = new Tutor();
                tutor.setTutor_id(Integer.parseInt(key));
                tutor = tutorDao.selectTutorByID(tutor);
                tutors.add(tutor);
            }
        }
        Integer result = tutorDao.deleteTutorsByID(tutors);
        //        删除服务器图片文件
        for (Tutor tutor : tutors) {
            deleteTutorPhoto(tutor);
        }
        if (result == tutors.size()) {
            System.out.println("Successfully! ");
            return true;
        } else {
            return false;
        }
    }


    //    删除单个tutor
    @Override
    public boolean deleteOneTutor(Tutor tutor) {
        List<Tutor> tutors = new ArrayList<>();
        tutors.add(tutor);
        deleteTutorPhoto(tutorDao.selectTutorByID(tutor));
        Integer result = tutorDao.deleteTutorsByID(tutors);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    //    Method: 删除tutor照片文件
    public void deleteTutorPhoto(Tutor tutor) {
        String basePath = "CSWebsite/";
        new File(basePath + tutor.getPhoto()).delete();
    }
}
