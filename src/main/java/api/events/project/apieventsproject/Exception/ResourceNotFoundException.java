package api.events.project.apieventsproject.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private  String name;
    private  String email;
    private Object fieldValue;

    public ResourceNotFoundException( String name, String email, Object fieldValue){
        super(String.format("%s not found s%: '%s'",name,email,fieldValue));
        this.name=name;
        this.email = email;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
