package rightabove.test.repository.entity;

public class AmphibianEntity extends AnimalEntity {

    public AmphibianEntity(Long id, String name, String className, String type) {
        super(id, name, className, type);
    }

    public AmphibianEntity(String name, String className, String type) {
        super(name, className, type);
    }


}
