package dao;

import domain.Gallery;
import domain.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GalleryDao {

    //    展示最近六条数据
    public List<Gallery> selectRecentGallery();

    //    展示所有gallery
    public List<Gallery> showAllGallery(Page page);

    //    根据Gallery ID查询Gallery
    public Gallery selectGalleryByID(Gallery Gallery);

    //    根据Gallery name查询Gallery
    public List<Gallery> selectGalleryByTitle(@Param("gallery") Gallery gallery, @Param("page") Page page);

    //    展示所有数据页码
    public Integer showNumberOfLine();

    //    根据Title模糊查询展示页码
    public Integer showNumberOfLineByTitle(Gallery gallery);

    //    插入新gallery
    public Integer insertGallery(Gallery gallery);

    //    批量删除所选gallery
    public Integer deleteGalleryByID(List<Gallery> gallery);

    //    根据gallery id更新信息（不保存图片）
    public Integer updatePartGalleryByID(Gallery gallery);

    //    根据gallery id更新信息（保存图片）
    public Integer updateAllGalleryByID(Gallery gallery);


}
