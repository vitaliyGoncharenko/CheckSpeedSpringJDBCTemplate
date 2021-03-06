package goncharenko.gvv.app;

import goncharenko.gvv.service.ModelRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Vitaliy on 26.11.2016.
 */
@SpringBootApplication(scanBasePackages = {"goncharenko.gvv"})
public class SpeedTestApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpeedTestApplication.class);

    @Autowired
    private ModelRepositoryService repositoryService;

    @Override
    public void run(String... args) {
        repositoryService.createTable();
        repositoryService.insertOneRow();
        repositoryService.insertListModel();
        repositoryService.selectListModel();
        repositoryService.deleteAll();
    }


    public static void main(String[] args) {
        SpringApplication.run(SpeedTestApplication.class, args);
    }
}
