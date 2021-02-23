package service;


import domain.Index;
import domain.News;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IndexService {

    public List<News> showRecentNews();

    public boolean addNewIndex(MultipartFile img, Index index) throws IOException;

    public List<Index> showIndexList();

    public boolean deleteIndex(Index index);
}
