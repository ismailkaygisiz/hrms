package kodlamaio.hrms.entities.concretes;

import kodlamaio.hrms.core.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "verifications")
public class Verification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "verification_code")
    private String verificationCode;

    @Column(name = "is_verified")
    private boolean isVerified;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "verification_date")
    private Date verificationDate;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
