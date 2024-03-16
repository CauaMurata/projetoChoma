package com.projeto.model;
import com.projeto.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String password;

    public UserModel(UserDTO data) {
        this.username = data.username();
        this.email = data.email();
        this.password = data.password();
    }
}



