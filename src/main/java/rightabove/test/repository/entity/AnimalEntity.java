package rightabove.test.repository.entity;

public abstract class AnimalEntity {
    private Long id;
    private String name;
    private String className;

    private String type;

    public AnimalEntity(Long id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public AnimalEntity(String name, String className) {
        this.name = name;
        this.className = className;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
