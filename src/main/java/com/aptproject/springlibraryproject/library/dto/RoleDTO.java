package com.aptproject.springlibraryproject.library.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class RoleDTO {
    private Long id;
    private String title;
    private String description;
}
