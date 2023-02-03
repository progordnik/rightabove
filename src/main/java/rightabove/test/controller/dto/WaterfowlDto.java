package rightabove.test.controller.dto;

public class WaterfowlDto extends AnimalDto {

    public WaterfowlDto(Long id, String name, String className, String type) {
        super(id, name, className, type);
    }

    public WaterfowlDto(String name, String className, String type) {
        super(name, className, type);
    }

}
