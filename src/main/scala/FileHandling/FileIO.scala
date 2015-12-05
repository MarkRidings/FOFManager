package FileHandling

import java.io.{File, FilenameFilter}

/**
  * Created by MarkR on 12/3/2015.
  */
class FileIO {

  val baseDir = "C:\\Users\\MarkR\\AppData\\Roaming\\Solecismic Software\\Front Office Football Seven\\leaguedata"
  val file = new File(baseDir)
  val fileList = file.list(new FilenameFilter {
    override def accept(dir: File, name: String): Boolean = {
      new File(dir, name).isDirectory
    }
  })

  def ListDir(): Unit = {

    fileList.zipWithIndex.foreach(line => {
      println("%d - %s".format(line._2, line._1))
    })
  }

  def GetDirectoryIndex(arg: String): (Int, String) = {

    if (arg.matches("\\d+")) {
      val i = arg.toInt
      if (i >= 0 && i < fileList.length) {
        (i, fileList.apply(i))
      }
      else {
        (-1, "")
      }
    }
    else {
      fileList.zipWithIndex.foreach(line => {
        if (line._1 == arg) {
          return (line._2, line._1)
        }
      })
      (-1, "")
    }
  }
}
