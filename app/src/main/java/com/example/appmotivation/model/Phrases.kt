package com.example.appmotivation.model

import com.example.appmotivation.infra.MotivationConstants
import kotlin.random.Random


data class NewPhrases(val description: String, val category: Int)

class Phrases {
    private val all = MotivationConstants.FILTER.ALL
    private val happy = MotivationConstants.FILTER.SUNNY
    private val sunny = MotivationConstants.FILTER.HAPPY

    private val listNewPhrasess: List<NewPhrases> = listOf(
        NewPhrases("Não sabendo que era impossível, foi lá e fez.", happy),
        NewPhrases("Você não é derrotado quando perde, você é derrotado quando desiste!", happy),
        NewPhrases("Quando está mais escuro, vemos mais estrelas!", happy),
        NewPhrases("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy),
        NewPhrases("Não pare quando estiver cansado, pare quando tiver terminado.", happy),
        NewPhrases("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy),
        NewPhrases("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        NewPhrases("Você perde todas as chances que você não aproveita.", sunny),
        NewPhrases("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        NewPhrases(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        NewPhrases("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        NewPhrases("Se você acredita, faz toda a diferença.", sunny),
        NewPhrases("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny)
    )

    // Obtém frase aleatória de acordo com o filtro
    fun getNewPhrases(value: Int): String {
        val filtered = listNewPhrasess.filter { (it.category == value || value == all) }

        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random.nextInt(filtered.size)

        // Retorna string
        return filtered[rand].description
    }

}