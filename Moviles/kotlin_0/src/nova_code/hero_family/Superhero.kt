package nova_code.hero_family

abstract class Superhero (val name:String, var energy:Int, var level:Int){
    open fun usePower(){
        this.energy -= 10
    }

    fun regenerateEnergy(lot: Int){
        if(energy+lot >= 100){
            energy = 100
        }else energy+= lot

        println("${this.name}: energy recharged")

    }

    open fun train(){
        if (energy< 10){
            regenerateEnergy(5)
        }else{
            println("${this.name}: trains")
            level+= 1
            energy-= 10
            regenerateEnergy(5)
        }
    }


    fun showStatus(){
        println(this)
    }

    override fun toString(): String {
        return "Superhero{  Name: $name; Energy: $energy; Level: $level}"
    }

}