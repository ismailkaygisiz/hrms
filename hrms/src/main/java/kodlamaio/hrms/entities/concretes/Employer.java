package kodlamaio.hrms.entities.concretes;

import kodlamaio.hrms.core.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User {
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "website")
    private String webSite;

    @Column(name = "phone_number")
    private String phoneNumber;
}
