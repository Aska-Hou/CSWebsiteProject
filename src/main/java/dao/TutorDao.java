package dao;

import domain.Tutor;

import java.util.List;

public interface TutorDao {
    
    //    查询所有的Tutor, 返回List
    public List<Tutor> showAllTutor();

    //    根据Tutor ID查询Tutor
    public Tutor selectTutorByID(Tutor tutor);

    //    根据tutor name查询tutor
    public List<Tutor> selectTutorByName(Tutor tutor);

    //    插入新tutor
    public Integer insertTutor(Tutor tutor);

    //    根据tutor id更新信息（不保存图片）
    public Integer updatePartTutorByID(Tutor tutor);

    //    根据tutor id更新信息（保存图片）
    public Integer updateAllTutorByID(Tutor tutor);

    //    批量删除所选tutor
    public Integer deleteTutorsByID(List<Tutor> tutors);



}
