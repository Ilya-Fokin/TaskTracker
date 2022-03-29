package Domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private final UUID id = UUID.randomUUID();


}
