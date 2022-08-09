package academy.devdojo.springboot2.requests;

import lombok.Data;

@Data
public class AnimePatchRequestBody {
    private Long id;
    private String name;
}
