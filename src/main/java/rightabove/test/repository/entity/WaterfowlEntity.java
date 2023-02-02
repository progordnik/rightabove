package rightabove.test.repository.entity;

public class WaterfowlEntity extends AnimalEntity {
    private final String type = "Waterfowl";
    public WaterfowlEntity(Long id, String name, String className) {
        super(id, name, className);
    }

    public WaterfowlEntity(String name, String className) {
        super(name, className);
    }

    public String getType() {
        return type;
    }
}
