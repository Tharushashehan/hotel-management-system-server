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
@Table(name = "room")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class RoomDetails  implements Serializable {

	 	@Id
	    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "room_details_Sequence")
	    @SequenceGenerator(name = "room_details_Sequence", sequenceName = "ROOM_DETAILS_SEQ")
	    private Long id;
	     
	 	 @Column(name = "roomNo", nullable = true)
		 private String roomNo;
	     
	     @Column(name = "roomType", nullable = true)
	     private String roomType;

	     @Column(name = "roomImage", nullable = true)
	     private String roomImage;
	     
	     @Column(name = "roomAvailability", nullable = true)
	     private Boolean roomAvailability;
	     
	     @Column(name = "roomPrice", nullable = true)
	     private String roomPrice;
	     
	     @Column(name = "roomDiscription", nullable = true)
	     private String roomDiscription;
	     
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
