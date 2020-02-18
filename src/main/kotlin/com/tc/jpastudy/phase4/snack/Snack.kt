package com.tc.jpastudy.phase4.snack

import com.tc.jpastudy.phase4.BaseEntity
import javax.persistence.Entity

@Entity
class Snack(
    var name: String,
    var maker: String
    // ,
    // var nutrient: SnackNutrient // {"carbohydrate": 10, "protein": 20, "fat": 30}
) : BaseEntity()
