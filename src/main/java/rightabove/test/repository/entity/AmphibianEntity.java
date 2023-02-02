package rightabove.test.repository.entity;

public class AmphibianEntity extends AnimalEntity {

    private final String type = "Amphibian";
    public AmphibianEntity(Long id, String name, String className) {
        super(id, name, className);
    }

    public AmphibianEntity(String name, String className) {
        super(name, className);
    }

    public String getType() {
        return type;
    }
}
