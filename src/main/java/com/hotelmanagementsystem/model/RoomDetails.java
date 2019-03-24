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
@Table(name = "room")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class RoomDetails  implements Serializable {

	 	@Id
	    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "room_details_Sequence")
	    @SequenceGenerator(name = "room_details_Sequence", sequenceName = "ROOM_DETAILS_SEQ")
	    private Long id;
	 	
	 	 @Column(name = "room_id", nullable = false)
	     private String room_id;
	     
	 	 @Column(name = "room_no", nullable = true)
		 private String room_no;
	 	  
	     @Column(name = "room_name", nullable = true)
	     private String room_name;
	     
	     @Column(name = "room_type", nullable = true)
	     private String room_type;
	     
	     @Column(name = "room_capacity", nullable = true)
	     private String room_capacity;
	  
	     @Column(name = "room_image", nullable = true)
	     private String room_image;
	     
	     @Column(name = "availability", nullable = true)
	     private Boolean availability;
	     
	     @Column(name = "remark", nullable = true)
	     private String remark;
	     
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
