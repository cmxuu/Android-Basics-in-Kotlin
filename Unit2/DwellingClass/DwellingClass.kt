/**
* Program that implements classes for different kinds of dwellings.
*  1. classes and inheritance
*  2. abstract, override, super, open, with
*/

import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    
    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)
    
    with(squareCabin) {
        println("Square Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
  }
    
  with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
        getRoom()
        getRoom()
        println("Carpet Length: ${calculateMaxCarpetLength()}")
    }
    
    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
        println("Carpet Length: ${calculateMaxCarpetLength()}")
  } 
}

/* Parent: all type of building */
abstract class Dwelling(private var residents: Int) {    // 還不確定建築物

   abstract val buildingMaterial: String                 // 還不確定建材
   abstract val capacity: Int                            // 還不確定容量

   fun hasRoom(): Boolean {
       return residents < capacity
   }
   
   abstract fun floorArea(): Double                      // 還不確定面積算法
    
   fun getRoom() {
       if (capacity > residents) {
           residents++
           println("You got a room!")
       }
       else {
           println("Sorry, at capacity and no rooms left.")
       }
   }
}

/* 1st Child: SquareCabin */
class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    
    override val buildingMaterial = "Wood"       // override覆蓋abbract屬性、函數        
    override val capacity = 6
    override fun floorArea(): Double {
      return length * length
    }
}
/* 1st Child: RoundHut (has child) */
open class RoundHut(residents: Int, 
                    val radius: Double): Dwelling(residents) {    // open才能有Child
    override val buildingMaterial = "Straw"
    override val capacity = 4
    override fun floorArea(): Double {
        return PI * radius * radius
    }
    fun calculateMaxCarpetLength(): Double {
        return sqrt(2.0) * radius
    }
}

/* 2nd Child: RoundTower */
class RoundTower(residents: Int, 
                 radius: Double,
                 val floors: Int = 2) : RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
  override fun floorArea(): Double {
        return super.floorArea() * floors        // super調用parent的函數
    }
}