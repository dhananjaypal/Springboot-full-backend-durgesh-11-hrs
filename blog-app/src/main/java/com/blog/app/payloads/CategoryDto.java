package com.blog.app.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {


    private int categoryId;

    @NotEmpty
    @Size(min=4, message = "Min size of category is 4 character")
    private String categoryTitle;

    @NotEmpty
    @Size(min=10, message = "Min size of category is 10 character")
    private String categoryDescription;
}
