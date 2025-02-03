import kotlin.math.sqrt

fun main() {
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
}