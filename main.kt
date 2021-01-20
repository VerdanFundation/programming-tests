import  java.io.File
import javax.swing.plaf.metal.MetalIconFactory
import kotlin.random.Random
import java.lang.Thread

var lang: LangFuncions = LangFuncions()

fun printLangs(lang: String)
{
    var PATH: String = "C:/Users/embeb/IdeaProjects/Programming Tests/src/main/resources/languages_in_program.txt"
    var file: File = File(PATH)
    file.appendText(lang + "\n")
}

fun fullLanguageName(extension: String): String
{
    when (extension)
    {
        ".js" -> return "JavaScript"
        ".py" -> return "Python"
        ".java" -> return "Java"
        ".kt" -> return "Kotlin"
        ".scala" -> return "Scala"
        ".cpp" -> return "C++"
        ".php" -> return "PHP"
        ".swift" -> return "Swift"
        ".ru" -> return "Ruby"
        ".c" -> return "C"
        ".r" -> return "R"
        ".cs" -> return "C#"
        else -> return "WHAT?!?!?!?!?!?!?!?!?!?!?!?!"
    }
}

fun responseView(correct: String)
{
    var generator = Random(System.nanoTime())
    var numberOfCorrect: Int = generator.nextInt(1, 5)
    var file = lang.getFile("C:/Users/embeb/IdeaProjects/Programming Tests/src/main/resources/languages.txt")
    var another: ArrayList<String> = arrayListOf()
    for (x in 0 until 3)
    {
        var index = generator.nextInt(0, file.size)
        while (another.contains(file[index]) || file[index] == correct)
        {
            index = generator.nextInt(0, file.size)
        }

        another.add(file[index])
    }

    when (numberOfCorrect)
    {
        1 -> {
            println("A: $correct")
            println("B: ${another[0]}")
            println("C: ${another[1]}")
            println("D: ${another[2]}")
        }
        2 -> {
            println("A: ${another[0]}")
            println("B: $correct")
            println("C: ${another[1]}")
            println("D: ${another[2]}")
        }
        3 -> {
            println("A: ${another[0]}")
            println("B: ${another[1]}")
            println("C: $correct")
            println("D: ${another[2]}")
        }
        4 -> {
            println("A: ${another[0]}")
            println("B: ${another[1]}")
            println("C: ${another[2]}")
            println("D: $correct")
        }
        else -> println("Wystąpił błąd wewnętrzny.")
    }
}

fun randLine(code: List<String>): String
{
    var len: Int = code.size
    var generator: Random = Random(System.nanoTime())
    var index: Int = generator.nextInt(0, len)
    var lineOfCode: String = code[index]
    while (lineOfCode.contains('{') || lineOfCode.contains('}'))
    {
        index = generator.nextInt(0, len)
        lineOfCode = code[index]
    }
    return lineOfCode
}

fun main(args: Array<String>)
{
    println("Programming Test - Co to zo język programowania?\n")
    var points: Int = 0

    println("Test polega na tym, że program pokazuje kawałek kodu,")
    println("a Twoim zadaniem będzie dopasować kod do języka. Języków jest 12.")
    println("Projekt powstał na zakończenie 25-odcinkowego kursu podstaw Kotlina")
    println("na YouTube. Za odgadniętą odpowiedź dostajesz 1 punkt. POWODZENIA!\n\n")

    print("Ile chcesz pytań? -> ")
    var quest = readLine()!!.toInt()

    for (i in 0 until quest)
    {
        var languageExtension: String = lang.checkLanguage()
        var language = fullLanguageName(languageExtension)
        var folderPath: String = lang.PATH + languageExtension + "/"
        var PATH: String = lang.randFile(folderPath) + languageExtension
        var sourceCode: List<String> = lang.getFile(PATH)

        println("\nOto ${i + 1} kod: \n\n")
        println(randLine(sourceCode))

        printLangs(language)
        println("\n\nCo to za język?\n")
        responseView(language)

        print("\nPodaj nazwę języka -> ")
        var userLang: String = readLine()!!

        var upperUserLang = userLang.toUpperCase()
        var upperLanguage = language.toUpperCase()

        if (upperLanguage == upperUserLang)
        {
            points++
            println("Brawo!")
        }
        else
        {
            println("Niestety :( To był język $language")
        }

        Thread.sleep(2000)
    }

    println("OK! Twoje punkty: $points / $quest (${(points / quest) * 100}%). Brawo!")
    Thread.sleep(2000)
}