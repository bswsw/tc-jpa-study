package com.tc.jpastudy.phase4.beer

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BeerService(private val beerRepository: BeerRepository) {

    fun getBeers(pageable: Pageable): Page<Beer> {
        return beerRepository.findAll(pageable)
    }

    fun getBeer(id: Long): Beer {
        return beerRepository.findByIdOrNull(id)
            ?: throw BeerException("맥주가 없습니다. :$id")
    }

    fun makeBeer(name: String, maker: String): Beer {
        val beer = Beer().apply {
            this.name = name
            this.maker = maker
        }
        return beerRepository.save(beer)
    }

    fun updateBeer(id: Long, newName: String, newMaker: String): Beer {
        val beer = getBeer(id)

        beer.name = newName
        beer.maker = newMaker

        return beer
    }

    fun updateBeer(beer: Beer, newName: String): Beer {
        beer.name = newName

        return beer
    }

    fun deleteBeer(id: Long): Boolean {
        beerRepository.deleteById(id)
        return true
    }
}