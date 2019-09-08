package week2.structural.decorator.fav;

public class WithAnnotationDTO {

    @JsonField("read_name")
    private String readableName;

    public String getReadableName() {
        return readableName;
    }

    public void setReadableName(String readableName) {
        this.readableName = readableName;
    }
}
