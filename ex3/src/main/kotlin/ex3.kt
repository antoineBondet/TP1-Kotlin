//Créez une fonction apply qui prend en argument un entier n, un entier optionnel m initialisé à 0 et une expression lambda f qui prend un entier en argument et renvoie un entier. La fonction apply doit renvoyer la valeur de f(f(...f(n))) où f est appliquée m fois.
//apply sert à appliquer une fonction f plusieurs fois à un entier n.
fun apply(n: Int, m: Int = 0, f: (Int) -> Int): Int {
    var result = n
    repeat(m) {
        result = f(result)
    }
    return result
}

fun applySyracuse(n: Int, m: Int = 0, f: (Int) -> Int): Int {
    var result = n
    repeat(m) {
        println("Terme ${it + 1}: $result") // Affichage du terme
        result = f(result)
    }
    return result
}

fun applyRacine2(n: Double, m: Int = 0, f: (Double) -> Double): Double {
    var result = n
    repeat(m) {
        result = f(result)
    }
    return result
}


fun main() {
    println(apply(2, 3) { x -> x * x })
    println(apply(12, 8) { x ->
        println("  ${x % 2}")
        x / 2
    })
    println(applySyracuse(12, 10) { x ->
        if (x % 2 == 0) x / 2 else 3 * x + 1

    })
    // Comment utiliser apply pour calculer une approximation de $\sqrt 2$ en utilisant la suite $u_0 = 1$ et $u_{n+1} = \frac{1}{2}(u_n + \frac{2}{u_n}) $
    println(applyRacine2(1.0,10) { x -> 0.5 *(x + 2 / x) })

}