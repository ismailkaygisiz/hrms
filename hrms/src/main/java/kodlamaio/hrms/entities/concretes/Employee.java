package kodlamaio.hrms.entities.concretes;

import kodlamaio.hrms.core.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Employee extends User{
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
