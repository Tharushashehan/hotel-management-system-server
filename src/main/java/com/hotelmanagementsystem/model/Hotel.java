package com.hotelmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    
    @Column(name = "hotelID", nullable = false)
    private String hotelID;
    
    @Column(name = "hotelName", nullable = true)
    private String hotelName;
    
    @Column(name = "hotelAddress", nullable = true)
    private String hotelAddress;
    
    @Column(name = "hotelEmail", nullable = true)
    private String hotelEmail;
    
    @Column(name = "hotelWebSite", nullable = true)
    private String hotelWebSite;
    
    @Column(name = "hotelImage", nullable = true)
    private String hotelImage;
    
    @JsonIgnore
    @Column(name = "createdAt", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @JsonIgnore
    @Column(name = "updatedAt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
    @JsonIgnore
    @Column(name = "statusCode", nullable = false)
    @Value("${some.key:true}")
    private boolean statusCode;
    
}
