package com.example.demo.model;

/**
 * @Description AopXmlTestBean
 */
public class AopXmlTestBean {
    private Integer id;
    private String name;

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

    public AopXmlTestBean() {
    }

    public AopXmlTestBean(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "AopXmlTestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void doSomething() {
        System.out.println(AopXmlTestBean.class.getName() + ":->doSomething");
    }
}
