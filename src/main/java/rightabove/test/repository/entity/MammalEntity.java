package rightabove.test.repository.entity;

public class MammalEntity extends AnimalEntity {
    private final String type = "Mammal";
    public MammalEntity(Long id, String name, String className) {
        super(id, name, className);
    }

    public MammalEntity(String name, String className) {
        super(name, className);
    }

    public String getType() {
        return type;
    }
}
