package rightabove.test.controller.dto;

public class MammalDto extends AnimalDto {
    public MammalDto(Long id, String name, String className, String type) {
        super(id, name, className, type);
    }

    public MammalDto(String name, String className, String type) {
        super(name, className, type);
    }

}
