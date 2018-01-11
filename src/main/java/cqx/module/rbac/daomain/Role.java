package cqx.module.rbac.daomain;

/**
 * @author cqx
 * @date 2018/1/10 15:46
 */
public class Role {
    private Integer id;
    private String name;
    private String sn;

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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
