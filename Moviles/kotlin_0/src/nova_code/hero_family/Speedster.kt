package nova_code.hero_family

class Speedster (name:String, energy:Int, level:Int): Superhero(name, energy, level) {
    override fun usePower(){
        if (energy >= 5){
            energy -= 5
            level += 2
            println("${this.name} : has used speedforce.")

        }else println("${this.name}: cant use sprintforce")
    }

    override fun train() {
        if (energy< 10){
            regenerateEnergy(12)
        }else{
            println("${this.name}: trains")
            level+= 1
            energy-= 10
            regenerateEnergy(12)
        }
    }

    override fun toString(): String {
        return "Speedster{  Name: $name; Energy: $energy; Level: $level}"
    }

}