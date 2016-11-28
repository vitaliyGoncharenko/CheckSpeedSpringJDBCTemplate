package goncharenko.gvv.entity;

/**
 * Created by Vitaliy on 26.11.2016.
 */
public class Model {

    private Integer id;

    private String name;

    private String info;

    public Model() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
