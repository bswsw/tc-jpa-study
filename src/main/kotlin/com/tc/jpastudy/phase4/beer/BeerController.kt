package com.tc.jpastudy.phase4.beer

import com.tc.jpastudy.domain.QCar
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on

@RestController
@RequestMapping("/beers")
class BeerController(private val service: BeerService) {

    @GetMapping
    fun getBeers(pageable: Pageable): ResponseEntity<*> {
        return ResponseEntity.ok(service.getBeers(pageable))
    }

    @PostMapping
    fun makeBeers(@RequestBody body: BeerBody): ResponseEntity<*> {
        val newBeer = service.makeBeer(body.name, body.maker)

        val link =
            MvcUriComponentsBuilder.fromMethodCall(on(BeerController::class.java).getBeer(newBeer.id!!)).build().toUri()
        return ResponseEntity.created(link).body(newBeer)
    }

    @GetMapping("/{id}")
    fun getBeer(@PathVariable id: Long): ResponseEntity<*> {
        return ResponseEntity.ok(service.getBeer(id))
    }

    @PutMapping("/{id}")
    fun updateBeer(@PathVariable id: Long, @RequestBody body: BeerBody): ResponseEntity<*> {
        return ResponseEntity.ok(service.updateBeer(id, body.name, body.maker))
    }

    @DeleteMapping("/{id}")
    fun deleteBeer(@PathVariable id: Long): ResponseEntity<*> {
        return ResponseEntity.ok(service.deleteBeer(id))
    }

    data class BeerBody(val name: String, val maker: String)
}
