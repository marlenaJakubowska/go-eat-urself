package com.marspc.goeaturself.domain;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "users")
@TypeDefs({
        @TypeDef(
                name = "string-array",
                typeClass = StringArrayType.class
        )})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String username;
    private String password;
    private String email;
    private Date joinDate;
    private String role;
    @Type(type = "string-array")
    @Column(name ="authorities", columnDefinition = "text[]")
    private String[] authorities;
    private Boolean isNonLocked;
    private Boolean isActive;


    public User(Long id, String firstName, String username, String password, String email, Date joinDate, String role, String[] authorities, Boolean isNonLocked, Boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.joinDate = joinDate;
        this.role = role;
        this.authorities = authorities;
        this.isNonLocked = isNonLocked;
        this.isActive = isActive;
    }

    public User(){}
}
