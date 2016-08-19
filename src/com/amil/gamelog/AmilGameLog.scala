package com.amil.gamelog

import java.io._
import scala.collection.mutable.Buffer
import scala.collection.mutable.Map
import scala.collection.immutable.ListMap

case class Gamer(nome: String, var assassinatos: Int, var mortes: Int)
case class Partida(id: Int, gamers: ListMap[String, Gamer])

object AmilGameLog {
  @throws(classOf[FileNotFoundException])
  @throws(classOf[NullPointerException])
  def getResourcePath(fileName: String) = {
    val url = getClass().getResource(fileName)
    url.getPath()
  }
  def main(args: Array[String]): Unit = {
    var filePath = args(0)
    try {
      if (filePath != null && !filePath.equals("")) {
        filePath = getResourcePath(args(0))
        var gamers = Map[String, Gamer]()
        var turns = Buffer[Partida]()
        var turn = 0
        val infile = io.Source.fromFile(new File(filePath)).getLines().toList
        if (infile.length == 0)
          throw new Exception("Arquivo de log vazio!!!")
        for (lines <- infile) {
          val vals: Array[String] = lines.split(" ")
          if (vals.length == 8 && vals(7).equals("started")) turn = vals(5).toInt
          if (vals.length == 7) {
            turns.append(Partida(turn, ListMap(
              gamers.toSeq.sortWith(_._2.assassinatos > _._2.assassinatos): _*)))
            turn = 0
            gamers.clear()
          }
          if (turn > 0) {
            if (!vals(3).equals("<WORLD>") && !vals(3).equals("New")) {
              if (gamers.contains(vals(3))) gamers(vals(3)).assassinatos += 1
              else {
                val gamer = Gamer(vals(3), 1, 0)
                gamers(vals(3)) = gamer
              }
              if (gamers.contains(vals(5))) gamers(vals(5)).mortes += 1
              else if (!vals(5).equals("<WORLD>")) {
                val gamer = Gamer(vals(5), 0, 1)
                gamers(vals(5)) = gamer
              }
            }
          }
        }
        printf("%20s %10s %20s %20s %20s", "Partida", "Rank", "Nomes", "Assassinatos", "Mortes")
        println; println
        for (results <- turns) {
          val partida = results.id
          var rank = 1
          for (e <- results.gamers.keys) {
            printf("%20s %10s %20s %20s %20s\n",
              partida.toString(),
              rank.toString(),
              e.toString(),
              results.gamers(e).assassinatos.toString(),
              results.gamers(e).mortes.toString())
            rank += 1
          }
          println
        }
      } else {
        throw new Exception("Caminho do arquivo de log vazio! Reexecute novamente\n"
          + "e informe o caminho completo do arquivo de log.")
      }
    } catch {
      case e: FileNotFoundException => println("Arquivo de log não encontrado!!!")
      case e: NullPointerException => println("Arquivo de log não encontrado!!!")
      case e: Exception => println(e.getLocalizedMessage)
    }
  }
}