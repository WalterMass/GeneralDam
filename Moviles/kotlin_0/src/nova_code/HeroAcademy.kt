package nova_code

import nova_code.hero_family.Speedster
import nova_code.hero_family.Strongman
import nova_code.hero_family.Telepath

class HeroAcademy {
    fun exe(){
        //velocista
        val sonic = Speedster("flash", 50, 1)
        // forzudo
        val tanktoptigger = Strongman("tanktoptigger",50, 1)
        // telepata
        val psicomantis = Telepath("psicomantis", 50, 1)

        for (i in 1..3){
            sonic.usePower()
            tanktoptigger.usePower()
            psicomantis.usePower()
            println(i)
        }

        for (i in 1..3){
            sonic.train()
            tanktoptigger.train()
            psicomantis.train()
            println(i)
        }

        sonic.showStatus()
        tanktoptigger.showStatus()
        psicomantis.showStatus()
    }

}