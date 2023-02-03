package rightabove.test.controller.dto;

public class AmphibianDto extends AnimalDto {

    public AmphibianDto(Long id, String name, String className, String type) {
        super(id, name, className, type);
    }

    public AmphibianDto(String name, String className, String type) {
        super(name, className, type);
    }

}
