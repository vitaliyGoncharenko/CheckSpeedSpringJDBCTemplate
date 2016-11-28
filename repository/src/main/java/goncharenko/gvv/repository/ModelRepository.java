package goncharenko.gvv.repository;

import goncharenko.gvv.entity.Model;

import java.util.List;

/**
 * Created by Vitaliy on 26.11.2016.
 */
public interface ModelRepository {

    void createTable();

    void insertOneRow(Model model);

    void insertBatch(List<Model> model);

    List<Model> getAllModel();

    void deleteAll();
}
