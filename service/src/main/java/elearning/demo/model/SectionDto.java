package elearning.demo.model;

import java.io.Serializable;
import java.util.Date;

public class SectionDto implements Serializable {

    private String section_id;
    private String section_name;

    public SectionDto() {
    }

    public SectionDto(String section_id, String section_name) {
        this.section_id = section_id;
        this.section_name = section_name;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

}
