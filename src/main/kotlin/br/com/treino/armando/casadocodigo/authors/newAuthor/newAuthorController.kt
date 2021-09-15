package br.com.treino.armando.casadocodigo.authors.newAuthor

import br.com.treino.armando.casadocodigo.authors.newAuthor.inputs.AuthorRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import javax.persistence.EntityManager
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
class newAuthorController(private val entityManager: EntityManager) {

    @PostMapping("/authors")
    @Transactional
    fun createAuthor(
        @RequestBody @Valid authorRequest: AuthorRequest,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<Any> {
        var author = authorRequest.toAuthorModel()
        entityManager.persist(author)
        val uri: URI = uriComponentsBuilder.path("/{code}").buildAndExpand(mutableMapOf(Pair("code", author.externalCode))).toUri()
        return ResponseEntity.created(uri).build()
    }

}