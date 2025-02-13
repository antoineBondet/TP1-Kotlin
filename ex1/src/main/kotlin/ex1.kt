import kotlin.math.sqrt

fun main() {
    // Générer une liste de 1000 nombres aléatoires compris entre 20 et 40. Calculer la moyenne, la variance et l’écart type de cette liste.
    val ListeNbr = "liste de  1000 nombres compris entre 20 et 40:"
    val rndList = List(1000){(20..40).random()}
    println("$ListeNbr $rndList")

    val avg = rndList.sumOf { it } / rndList.size.toDouble()
    val Moyenne = "Moyenne:"
    println ("$Moyenne $avg")

    var variance = 0.0
    for (i in rndList.indices) {
        variance += (rndList[i] - avg) * (rndList[i] - avg)
    }
    variance /= rndList.size.toDouble()
    val Variance = "Variance:"
    println ("$Variance $variance")

    val ecartType = sqrt(variance)
    val EcartType = "Ecart Type:"
    println ("$EcartType $ecartType")

val histogramme = mutableMapOf<Int, Int>()
for (i in rndList) {
    histogramme[i] = histogramme.getOrDefault(i, 0) + 1
}
val modalite = histogramme.maxByOrNull { it.value }?.key
val frequence = histogramme[modalite]
val Modalite = "Modalite:"
println ("$Modalite $modalite")
val Frequence = "Frequence:"
println ("$Frequence $frequence")


}