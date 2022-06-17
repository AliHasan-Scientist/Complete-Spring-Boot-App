package com.backend.myappbackend.payload;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor

public class CategoryDto implements Serializable {

    private  Integer categoryId;
    @NotBlank
    private  String categoryTitle;
    @NotBlank
    private  String categoryDescription;
}
