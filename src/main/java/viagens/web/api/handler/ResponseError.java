package viagens.web.api.handler;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ResponseError {
    private LocalDate timestamp = LocalDate.now();
    private String status = "error";
    private int statusCode = 400;
    private String error;

}
