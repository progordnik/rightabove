package rightabove.test.repository.entity;

public class WaterfowlEntity extends AnimalEntity {

    public WaterfowlEntity(Long id, String name, String className, String type) {
        super(id, name, className, type);
    }

    public WaterfowlEntity(String name, String className, String type) {
        super(name, className, type);
    }

}
