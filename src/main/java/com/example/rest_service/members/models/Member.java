package com.example.rest_service.members.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.example.rest_service.security.postgresql.models.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "members")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Member {
    @Id
    private Integer id;

    // @Column(name = "user_id", insertable = false, updatable = false)
    // private Integer userId;

    private Integer familyId;

    // private Integer parentId;

    private Integer husbandId;

    private Date createdAt;

    private Date updatedAt;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id", table = "members")
    private Member parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Member> children = new ArrayList<>();
}
