import kotlin.math.sqrt

//Créez une fonction mySqrt qui prend un nombre réel x en argument et renvoie la racine carrée de x si x est positif ou nul, et null sinon.
fun mySqrt(x: Double): Double? {
    return if (x >= 0) sqrt(x) else null
}

// Utilisez cette fonction pour écrire une fonction realRoots qui calcule les racines réelles d'un polynôme de degré 2 défini par 3 coefficients a, b et c. La fonction doit renvoyer une liste de 0, 1 ou 2 racines réelles.

fun realRoots(a: Double, b: Double, c: Double): List<Double> {
    val delta = b * b - 4 * a * c
    val sqrtDelta = mySqrt(delta)
    return when {
        sqrtDelta == null -> emptyList() // Pas de racines réelles
        delta == 0.0 -> listOf(-b / (2 * a)) // Une seule racine réelle
        else -> listOf((-b - sqrtDelta) / (2 * a), (-b + sqrtDelta) / (2 * a)) // Deux racines réelles
    }
}

// Test
fun main() {
    println(realRoots(1.0, -2.0, 1.0)) // [1.0]
    println(realRoots(1.0, -2.0, 2.0)) // []
    println(realRoots(1.0, 0.0, -2.0)) // [2.0, -2.0]
    println(realRoots(1.0, -3.0, 2.0)) // [2.0, 1.0]
}