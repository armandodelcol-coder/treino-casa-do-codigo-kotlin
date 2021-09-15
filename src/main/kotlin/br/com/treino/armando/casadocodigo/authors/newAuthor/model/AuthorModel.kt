package br.com.treino.armando.casadocodigo.authors.newAuthor.model

import java.util.*
import javax.persistence.*

@Entity
class AuthorModel(
    @Column(name = "email", nullable = false) private val email: String,
    @Column(name = "name", nullable = false, length = 100) private val name: String,
    @Column(name = "description", nullable = false, length = 400) private val description: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "external_code", nullable = false)
    val externalCode: String = UUID.randomUUID().toString()

}
