package goncharenko.gvv.repository;

import goncharenko.gvv.entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaliy on 28.11.2016.
 */
@Transactional
@Repository
public class ModelRepositoryImpl implements ModelRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS model");
        jdbcTemplate.execute("CREATE TABLE model(" +
                "id serial, name character varying, info character varying)");
    }

    @Override
    public void insertOneRow(Model model) {
        String sql = "INSERT INTO model " +
                "(name, info) VALUES (?, ?)";

        jdbcTemplate.update(sql, new Object[]{model.getName(), model.getInfo()});
    }

    @Override
    public void insertBatch(List<Model> modelList) {
        final int batchSize = modelList.size();

        String sql = "INSERT INTO model " +
                "(name, info) VALUES (?, ?)";

        jdbcTemplate.batchUpdate(sql,
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i)
                            throws SQLException {
                        Model model = modelList.get(i);
                        ps.setString(1, model.getName());
                        ps.setString(2, model.getInfo());
                    }

                    @Override
                    public int getBatchSize() {
                        return modelList.size();
                    }
                });
    }

    @Override
    public List<Model> getAllModel() {
        String sql = "SELECT * FROM model";
        List<Model> modelList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(Model.class));

        return modelList;
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM model";

        int rows = jdbcTemplate.update(sql);
    }


}
