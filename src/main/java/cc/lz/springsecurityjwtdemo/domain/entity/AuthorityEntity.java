package cc.lz.springsecurityjwtdemo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AUTHORITY")
@Getter
@Setter
public class AuthorityEntity {

    @Id
    @Column(name = "NAME", length = 50)
    @NotNull(message = "authority_name不能为空")
    private String name;

}
