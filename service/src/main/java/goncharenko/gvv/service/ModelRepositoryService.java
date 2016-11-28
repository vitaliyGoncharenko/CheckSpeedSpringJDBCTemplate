package goncharenko.gvv.service;


import goncharenko.gvv.entity.Model;

import java.util.List;

/**
 * Created by Vitaliy on 26.11.2016.
 */
public interface ModelRepositoryService {

    void createTable();

    void insertOneRow();

    void insertListModel();

    List<Model> selectListModel();

    void deleteAll() ;
}
