package com.test.todo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TodoDto {
    @NotNull
    @NotBlank
    private String title;
    private String description;
}
