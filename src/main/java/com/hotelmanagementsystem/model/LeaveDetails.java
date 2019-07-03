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
@Table(name = "leave_details")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class LeaveDetails  implements Serializable {
	
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "leave_Sequence")
    @SequenceGenerator(name = "leave_Sequence", sequenceName = "LEAVE_SEQ")
    private Long id;
    
    @Column(name = "empID", nullable = false)
    private String empID;
    
    @Column(name = "leaveType", nullable = true)
    private String leaveType;
    
    @Column(name = "leaveDurationType", nullable = true)
    private String leaveDurationType;
    
    @Column(name = "startingDate", nullable = true)
    private Date startingDate;
    
    @Column(name = "endDate", nullable = true)
    private Date endDate;
    
    @Column(name = "remark", nullable = true)
    private String remark;
    
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
