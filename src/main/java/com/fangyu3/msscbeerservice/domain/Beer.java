package com.fangyu3.msscbeerservice.domain;


import com.fangyu3.msscbeerservice.web.model.BeerStyleEnum;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {


    @Id
    // A generator named 'UUID' is used to get the generated value
    @GeneratedValue(generator="UUID")
    // Define the generator 'UUID'
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    // Varchar column of length 36
    @Column(length=36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;

    // Optimistic locking - no two transactions can override the data at the same time with a conflict
    // thread safe
    @Version
    private Long version;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    private String beerName;
    private String beerStyle;

    // upc is unique
    @Column(unique = true)
    private String upc;
    private Double price;

    private Integer minOnHand;
    private Integer quantityToBrew;
}
