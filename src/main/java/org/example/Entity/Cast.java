package org.example.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

public class Cast {
    private String actorFullName;
    private String role;

    public Cast(String actorFullName, String role) {
        this.actorFullName = actorFullName;
        this.role = role;
    }
}
