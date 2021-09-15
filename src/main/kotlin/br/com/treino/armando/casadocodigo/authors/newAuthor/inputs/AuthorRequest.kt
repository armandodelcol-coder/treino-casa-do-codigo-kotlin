package br.com.treino.armando.casadocodigo.authors.newAuthor.inputs

import br.com.treino.armando.casadocodigo.authors.newAuthor.model.AuthorModel
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class AuthorRequest(
    @field:NotBlank @field:Email val email: String,
    @field:NotBlank @field:Length(max = 100) val name: String,
    @field:NotBlank @field:Length(max = 400) val description: String
) {
    fun toAuthorModel(): AuthorModel {
        return AuthorModel(email, name, description)
    }
}
