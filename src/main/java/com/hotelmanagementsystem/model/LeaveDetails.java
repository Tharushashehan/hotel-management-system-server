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
@Table(name = "leave_details")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class LeaveDetails  implements Serializable {
	
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "leave_Sequence")
    @SequenceGenerator(name = "leave_Sequence", sequenceName = "LEAVE_SEQ")
    private Long id;
    
    @Column(name = "leave_id", nullable = false)
    private String leave_id;
    
    @Column(name = "emp_id", nullable = false)
    private String emp_id;
    
    @Column(name = "leave_name", nullable = true)
    private String leave_name;
    
    @Column(name = "starting_date", nullable = true)
    private Date starting_date;
    
    @Column(name = "end_date", nullable = true)
    private Date end_date;
    
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
