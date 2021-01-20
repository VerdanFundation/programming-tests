import java.io.File
import kotlin.random.Random

class LangFuncions
{
    val FILES: Int = 2
    val PATH: String = "C:/Users/embeb/IdeaProjects/Programming Tests/src/main/resources/"
    val LANGS_PATH: String = "C:/Users/embeb/IdeaProjects/Programming Tests/src/main/resources/languages_in_program.txt"
    val LANGUAGES: Int = 12

    fun checkLanguage(): String
    {
        var generator = Random(System.nanoTime())
        var randomNum = generator.nextInt(1, (LANGUAGES + 1))
        var extension = ""

        when (randomNum)
        {
            1 -> extension = ".js"
            2 -> extension = ".py"
            3 -> extension = ".java"
            4 -> extension = ".kt"
            5 -> extension = ".scala"
            6 -> extension = ".cpp"
            7 -> extension = ".php"
            8 -> extension = ".swift"
            9 -> extension = ".ru"
            10 -> extension = ".c"
            11 -> extension = ".r"
            12 -> extension = ".cs"
        }

        return extension
    }

    fun getFile(PATH: String): List<String>
    {
        var file: File = File(PATH)
        return file.readLines()
    }

    fun randFile(BASE_PATH: String): String
    {
        var generator = Random(System.nanoTime())
        var randomNum = generator.nextInt(1, (FILES + 1))
        var filePath: String = BASE_PATH + "code$randomNum"
        return filePath
    }
}