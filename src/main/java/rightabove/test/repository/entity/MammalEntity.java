package rightabove.test.repository.entity;

public class MammalEntity extends AnimalEntity {
    public MammalEntity(Long id, String name, String className, String type) {
        super(id, name, className, type);
    }

    public MammalEntity(String name, String className, String type) {
        super(name, className, type);
    }

}
