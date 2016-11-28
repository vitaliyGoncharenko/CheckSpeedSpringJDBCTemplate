package goncharenko.gvv.service;

import goncharenko.gvv.entity.Model;
import goncharenko.gvv.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Vitaliy on 26.11.2016.
 */
@Service
public class ModelRepositoryServiceImpl implements ModelRepositoryService {

    @Autowired
    private ModelRepository repository;

    @Override
    public void createTable() {
        repository.createTable();
    }

    @Override
    public void insertOneRow() {
        Model model = null;
        model = new Model();
        model.setName("Name_" + 01);
        model.setInfo("Info_" + 01);
        repository.insertOneRow(model);
    }

    @Override
    public void insertListModel() {
        List<Model> modelList = new ArrayList<>();
        Model model = null;
        for (int i = 0; i < 100; i++) {
            model = new Model();
            model.setName("Name_" + i);
            model.setInfo("Info_" + i);
            modelList.add(model);
        }
        repository.insertBatch(modelList);
    }

    @Override
    public List<Model> selectListModel() {
        List<Model> list = repository.getAllModel();
        return list;
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
