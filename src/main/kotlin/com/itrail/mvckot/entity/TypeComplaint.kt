package com.itrail.mvckot.entity

import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.media.Schema
import lombok.Getter
import lombok.Setter
import java.io.Serializable
import javax.persistence.*

@Entity
@Getter
@Setter
@Table( name = "Type_complaint")
class TypeComplaint: Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_type_complaint")
    @field:Schema(
        name = "idTypeComplaint",
        description = "Ид под жалобы",
        example = "100",
        type = "int",
    )
    val idTypeComplaint: Long = 0L

    @Column( name = "name")
    @field:Schema(
        name = "name",
        description = "Наименовае под жалобы",
        example = "Незаивисмоси 5",
        type = "string",
    )
    val name: String = ""

    @Hidden
    @OneToOne( cascade = arrayOf(CascadeType.ALL))
    @JoinColumn( name = "complaint_id" )
    var complaint:Complaint = Complaint()
}