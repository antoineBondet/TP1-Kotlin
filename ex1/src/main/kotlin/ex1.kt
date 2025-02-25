import kotlin.math.sqrt
import kotlin.system.measureTimeMillis

fun main() {
    //Pour calculer la moyenne des valeurs de cette liste on peut utiliser la méthode SumOf qui prend une expression lambda en argument. Ce qui donne :
    //Calculer de la même manière la variance de cette liste, et déduisez-en l'écart-type.

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
//énérer un histogramme des valeurs de la liste rndList en utilisant le type mutableMapOf<Int, Int>(). Quelle est la modalité de la liste ? Quelle est la fréquence de cette modalité ?
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


    // Avec la même méthode que pour la variance calculer les moments centrés d'ordre 3 et 4 de la liste rndList. Puis déduisez-en le coefficient d'asymétrie et le coefficient d'aplatissement de la distributio
    var moment3 = 0.0
    for (i in rndList.indices) {
        moment3 += (rndList[i] - avg) * (rndList[i] - avg) * (rndList[i] - avg)
    }
    moment3 /= rndList.size.toDouble()
    val Moment3 = "Moment centré d'ordre 3:"
    println ("$Moment3 $moment3")

    var moment4 = 0.0
    for (i in rndList.indices) {
        moment4 += (rndList[i] - avg) * (rndList[i] - avg) * (rndList[i] - avg) * (rndList[i] - avg)
    }
    moment4 /= rndList.size.toDouble()
    val Moment4 = "Moment centré d'ordre 4:"
    println ("$Moment4 $moment4")

    val asymetrie = moment3 / (ecartType * ecartType * ecartType)
    val Asymetrie = "Coefficient d'asymétrie:"
    println ("$Asymetrie $asymetrie")

    val aplatissement = moment4 / (ecartType * ecartType * ecartType * ecartType) - 3
    val Aplatissement = "Coefficient d'aplatissement:"
    println ("$Aplatissement $aplatissement")

// Centrage et réduction de la liste rndList : pour chaque élément de la liste, soustrayez la moyenne et divisez par l'écart-type en utilisant la méthode map et une expression lambda. Stockez le résultat dans une nouvelle liste zList. Calculez la moyenne et l'écart-type de cette nouvelle liste. Que constatez-vous ?
    val zList = rndList.map { (it - avg) / ecartType }
    val ZList = "Liste centrée et réduite:"
    println("$ZList $zList")

    val avgZ = zList.sumOf { it } / zList.size.toDouble()
    val MoyenneZ = "Moyenne de la liste centrée et réduite:"
    println ("$MoyenneZ $avgZ")

    var varianceZ = 0.0
    for (i in zList.indices) {
        varianceZ += (zList[i] - avgZ) * (zList[i] - avgZ)
    }
    varianceZ /= zList.size.toDouble()
    val VarianceZ = "Variance de la liste centrée et réduite:"
    println ("$VarianceZ $varianceZ")

    val ecartTypeZ = sqrt(varianceZ)
    val EcartTypeZ = "Ecart Type de la liste centrée et réduite:"
    println ("$EcartTypeZ $ecartTypeZ")

//Comparer les performances de la méthode sumOf avec une boucle for pour calculer la moyenne et la variance de la liste. Pour cela, utilisez la méthode measureTimeMillis de la bibliothèque kotlin.system pour mesurer le temps d'exécution de chaque méthode. Que constatez-vous



        // Mesure du temps pour sumOf (moyenne)
        var avgSumOf = 0.0
        val timeSumOfMean = measureTimeMillis {
            avgSumOf = rndList.sumOf { it } / rndList.size.toDouble()
        }

        // Mesure du temps pour sumOf (variance)
        var varianceSumOf = 0.0
        val timeSumOfVariance = measureTimeMillis {
            varianceSumOf = rndList.sumOf { (it - avgSumOf) * (it - avgSumOf) } / rndList.size
        }

        // Mesure du temps pour boucle for (moyenne)
        var avgFor: Double
    avgFor = 0.0
    val timeForMean = measureTimeMillis {
            var sum = 0.0
            for (i in rndList) {
                sum += i
            }
            avgFor = sum / rndList.size
        }

        // Mesure du temps pour boucle for (variance)
        var varianceFor: Double
    val timeForVariance = measureTimeMillis {
            var sumVariance = 0.0
            for (i in rndList) {
                sumVariance += (i - avgFor) * (i - avgFor)
            }
            varianceFor = sumVariance / rndList.size
        }

        // Affichage des résultats
        println("Moyenne avec sumOf : $avgSumOf")
        println("Variance avec sumOf : $varianceSumOf")
        println("Temps d'exécution de sumOf (moyenne) : $timeSumOfMean ms")
        println("Temps d'exécution de sumOf (variance) : $timeSumOfVariance ms")

        println("\nMoyenne avec for : $avgFor")
        println("Variance avec for : $varianceFor")
        println("Temps d'exécution de for (moyenne) : $timeForMean ms")
        println("Temps d'exécution de for (variance) : $timeForVariance ms")
    }





