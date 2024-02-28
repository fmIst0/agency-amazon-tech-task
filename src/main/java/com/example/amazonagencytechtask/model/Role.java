package com.example.amazonagencytechtask.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class Role {
    private RoleName roleName;

    public enum RoleName {
        USER
    }
}
