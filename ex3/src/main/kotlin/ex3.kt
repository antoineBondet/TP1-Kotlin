//Créez une fonction apply qui prend en argument un entier n, un entier optionnel m initialisé à 0 et une expression lambda f qui prend un entier en argument et renvoie un entier. La fonction apply doit renvoyer la valeur de f(f(...f(n))) où f est appliquée m fois.
//apply sert à appliquer une fonction f plusieurs fois à un entier n.
fun apply(n: Int, m: Int = 0, f: (Int) -> Int): Int {
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
}