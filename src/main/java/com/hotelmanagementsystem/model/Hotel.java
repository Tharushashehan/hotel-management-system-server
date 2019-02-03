package com.hotelmanagementsystem.model;

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
@Table(name = "hotel")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Hotel  implements Serializable {
	
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "hotel_Sequence")
    @SequenceGenerator(name = "hotel_Sequence", sequenceName = "HOTEL_SEQ")
    private Long id;
    
    @Column(name = "hotel_id", nullable = false)
    private String hotel_id;
    
    @Column(name = "hotel_name", nullable = true)
    private String hotel_name;
    
    @Column(name = "hotel_addrs", nullable = true)
    private String hotel_addrs;
    
    @Column(name = "hotel_email_addrs", nullable = true)
    private String hotel_email_addrs;
    
    @Column(name = "hotel_web_addrs", nullable = true)
    private String hotel_web_addrs;
    
    @Column(name = "hotel_image", nullable = true)
    private String hotel_image;
    
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
