package com.hotelmanagementsystem.model;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Data
@Getter
@Setter
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class User  implements Serializable {
	
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_Sequence")
    @SequenceGenerator(name = "user_Sequence", sequenceName = "USER_SEQ")
    private Long id;
    
    @Column(name = "emp_id", nullable = false)
    private String emp_id;
    
    @Column(name = "first_name", nullable = true)
    private String first_name;
    
    @Column(name = "last_name", nullable = true)
    private String last_name;
    
    @Column(name = "NIC_no", nullable = true)
    private String NIC_no;
    
    @Column(name = "email_addrs", nullable = true)
    private String email_addrs;
    
    @Column(name = "user_type", nullable = true)
    private String user_type;
    
    @Column(name = "user_image", nullable = true)
    private String user_image;
    
    @Column(name = "user_addrs", nullable = true)
    private String user_addrs;
    
    @Column(name = "user_password", nullable = true)
    private String user_password;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
    @Column(name = "status_code", nullable = false)
    @Value("${some.key:true}")
    private boolean status_code;
    
}
