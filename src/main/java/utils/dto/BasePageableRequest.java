package utils.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BasePageableRequest {

    @JsonIgnore // Avoid serialization issues
    private Pageable pageable = PageRequest.of(0, 10); // Default page=0, size=10

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = (pageable != null) ? pageable : PageRequest.of(0, 10);
    }
}
