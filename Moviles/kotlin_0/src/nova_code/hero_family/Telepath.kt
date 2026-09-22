package nova_code.hero_family

class Telepath(name: String, energy: Int, level: Int): Superhero(name, energy, level) {
    override fun usePower() {
        if(energy >= 15){
            energy -= 15
            level += 3
            println("${this.name}: has used psychokinesis")
        }else println("${this.name} cant use psychokinesis")
    }

    override fun toString(): String {
        return "Telepath{  Name: $name; Energy: $energy; Level: $level}"
    }

}