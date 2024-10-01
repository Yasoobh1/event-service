package com.eventService.eventService.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserRequest {
    private Long id;
    private String username;
    private String email;
}
