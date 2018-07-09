package com.example.main

import java.io.File
import java.net.URL
import java.nio.charset.Charset

/**
 * Created by ls on 18/5/2.
 */
class FileIODemo {

    companion object {

        fun main() {
            val fileName = "/Users/wenbaoxing/Documents/ls/bookmarks_2017_10_17.html"
            val fileContent = getFileContent(fileName)
            println(fileContent)
            println("================================")
            printFileContentByLines(fileName)
//            wirteFileContent(fileName, "你好啊，我的书签！")
//            traverseFileTree("/Users/wenbaoxing/Documents/ls")
//            traverseFileTree(".",{it.isFile}).forEach { println("fileSequence:${it.absolutePath}") }
//            traverseFileTree("/Users/wenbaoxing/Documents/ls", { it.extension == "kt" }).forEach { println("fileSequence:${it.absolutePath}") }
            val urlContent = getUrlContent("http://www.baidu.com")
            println(urlContent)
        }

        private fun getFileContent(fileName: String): String {
            val file = File(fileName)
            file.takeIf(File::exists).let { return it?.readText(Charset.forName("UTF-8")).orEmpty() }
        }

        private fun printFileContentByLines(fileName: String) {
            val file = File(fileName)
            file.takeIf(File::exists)?.readLines(Charset.forName("UTF-8"))?.forEach(::println)

        }

        private fun wirteFileContent(fileName: String, appendContent: String) {
            val file = File(fileName)
            if (file.exists().not()) {
                file.createNewFile()
            }
            file.appendText(appendContent, Charset.defaultCharset())
        }

        private fun traverseFileTree(fileName: String) {
            val file = File(fileName)
            val walk = file.walk()
            walk.iterator().forEach { println(it.absolutePath) }
        }

        private fun traverseFileTree(fileName: String, p: (File) -> Boolean): Sequence<File> {
            val file = File(fileName)
            val walk = file.walk()
            return walk.filter(p)
        }

        private fun getUrlContent(url: String): String {
            return URL(url).readText(Charset.defaultCharset())
        }
    }
}