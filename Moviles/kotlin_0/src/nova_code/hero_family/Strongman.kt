package nova_code.hero_family

class Strongman(name: String, energy: Int, level: Int): Superhero(name, energy, level){
    override fun usePower() {
        if (energy >= 20){
            energy -= 20
            level += 1
            println("${this.name}: has used seismic step")
        }else println("${this.name} cant use seismic step")
    }

    override fun train() {
        if (energy< 15){
            regenerateEnergy(20)
        }else{
            println("${this.name}: trains")
            level+= 1
            energy-= 15
            regenerateEnergy(20)
        }
    }

    override fun toString(): String {
        return "Strongman{  Name: $name; Energy: $energy; Level: $level}"
    }


}