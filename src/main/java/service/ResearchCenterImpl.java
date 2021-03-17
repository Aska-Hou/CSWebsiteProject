package service;

import dao.ResearchCenterDao;
import domain.ResearchCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;


@Service
public class ResearchCenterImpl implements ResearchCenterService {

    @Autowired
    ResearchCenterDao centerDao;

    //    ResearchCenter Detail 显示
    @Override
    public ResearchCenter showResearchCenterDetail(ResearchCenter center) {
        return centerDao.selectResearchCenterByID(center);
    }

    //    ResearchCenter List 显示
    @Override
    public List<ResearchCenter> showResearchCenterList() {
        return centerDao.showAllResearchCenter();
    }

    //  ResearchCenter 关键词搜索
    @Override
    public List<ResearchCenter> searchResearchCenterList(ResearchCenter center) {
        List<ResearchCenter> centers = new ArrayList<>();

        if (!center.getTitle().equals("null")) {
            centers = centerDao.selectResearchCenterByName(center);
        } else if (center.getCenter_id() != 0) {
            centers.add(centerDao.selectResearchCenterByID(center));
        }

        return centers;
    }


    //   新加入 ResearchCenter
    @Override
    public ResearchCenter addNewResearchCenter(MultipartFile img, ResearchCenter center) {
        //  保存照片
        String basePath = "/www/server/tomcat/webapps/CSWebsite/";
        String uuid = UUID.randomUUID().toString();
        center.setPhoto("ProfImg/" + uuid + ".png");
        try {
            img.transferTo(new File(basePath + center.getPhoto()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  向数据库插入新center的所有信息
        Integer result = centerDao.insertResearchCenter(center);
        System.out.println("ResearchCenter id: " + center.getCenter_id());
        if (result == 1) {
            return center;
        } else return null;
    }


    //  更新center信息
    @Override
    public boolean updateResearchCenter(MultipartFile img, ResearchCenter center) {
        Integer result = 0;

        //  如果图片不为空，保存照片且删除之前的照片
        if (img.getSize() != 0) {
            center = centerDao.selectResearchCenterByID(center);
            String basePath = "/www/server/tomcat/webapps/CSWebsite/";
            deleteResearchCenterPhoto(center);
            String uuid = UUID.randomUUID().toString();
            center.setPhoto("ProfImg/" + uuid + ".png");
            try {
                img.transferTo(new File(basePath + center.getPhoto()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = centerDao.updateAllResearchCenterByID(center);
        }
        //  如果图片为空，不改变图片
        else {
            result = centerDao.updatePartResearchCenterByID(center);
        }

        if (result == 1) {
            return true;
        } else
            return false;
    }


    //    删除所选center
    @Override
    public boolean deleteSelectedResearchCenter(Map<String, String[]> paraMap) {
        Set<String> keySet = paraMap.keySet();
        List<ResearchCenter> centers = new ArrayList<>();
        for (String key : keySet) {
            String choice = paraMap.get(key)[0];
            if ("on".equals(choice)) {
                ResearchCenter center = new ResearchCenter();
                center.setCenter_id(Integer.parseInt(key));
                center = centerDao.selectResearchCenterByID(center);
                centers.add(center);
            }
        }
        Integer result = centerDao.deleteResearchCentersByID(centers);
        //        删除服务器图片文件
        for (ResearchCenter center : centers) {
            deleteResearchCenterPhoto(center);
        }
        if (result == centers.size()) {
            System.out.println("Successfully! ");
            return true;
        } else {
            return false;
        }
    }


    //    删除单个center
    @Override
    public boolean deleteOneResearchCenter(ResearchCenter center) {
        List<ResearchCenter> centers = new ArrayList<>();
        centers.add(center);
        deleteResearchCenterPhoto(centerDao.selectResearchCenterByID(center));
        Integer result = centerDao.deleteResearchCentersByID(centers);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    //    Method: 删除faculty照片文件
    public void deleteResearchCenterPhoto(ResearchCenter center) {
        String basePath = "/www/server/tomcat/webapps/CSWebsite/";
        new File(basePath + center.getPhoto()).delete();
    }
}
