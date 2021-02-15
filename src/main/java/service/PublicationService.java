package service;

import domain.Page;
import domain.Paper;

import java.util.List;

public interface PublicationService {

    public List<Paper> showPaperList(Page page);

    public Page showPageList();
}
