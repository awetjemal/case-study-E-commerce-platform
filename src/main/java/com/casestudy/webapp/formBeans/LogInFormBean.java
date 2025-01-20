package com.casestudy.webapp.formBeans;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LogInFormBean {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
