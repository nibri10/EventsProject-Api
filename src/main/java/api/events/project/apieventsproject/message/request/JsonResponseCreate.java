package api.events.project.apieventsproject.message.request;

import api.events.project.apieventsproject.entity.MedicalRecord;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponseCreate {

    @JsonProperty("success")
    @Getter
    @Setter
    private boolean success;

    @JsonProperty("data")
    @Getter @Setter
    private String data;
    @JsonProperty("message")
    @Getter @Setter
    private String message;

    public JsonResponseCreate(boolean b,String data,String message) {
        this.message = message;
        this.data = data;
        this.success = b;
    }
}
