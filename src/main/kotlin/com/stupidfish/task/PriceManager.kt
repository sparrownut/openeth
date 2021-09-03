package com.stupidfish.task

import com.stupidfish.task.struct.PriceInfo
import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.FileNotFoundException


class PriceManager(coinTypeIN: String) {
    /*
    此类建成后勿随意销毁
     */
    var runtimes = 0
    val coinType = coinTypeIN
    fun getOncePrice() {// : PriceInfo
        /*
        查询一次价格信息并返回
        逻辑:
            如果开机第一次运行 有文件就从文件里读取 并且继续比对pmax和pmin,其他值为现有的
            如果没有文件就第一次读取并且写入文件
            每次读取都要覆盖之前的文件
         */
        try {

            if (runtimes == 0) {
                if (File("$coinType.yml").isFile) {
                    //如果刚开软件但有上次的记录
                   // val priceInfoHistory =
                }
            }
        } catch (e: FileNotFoundException) {
            //如果没有文件 实实在在的第一次运行
        }

        runtimes++
        //这里返回PriceInfo
    }

    fun writeLogToFile(priceInfo: PriceInfo) {//读取一次价格信息并且把关键信息写入文件
        try {
            val f = File("$coinType.yml")
            f.writeText(Yaml().dump(priceInfo))//写入关键信息
        } catch (e: FileNotFoundException) {
            File("$coinType.yml").createNewFile()
        }
    }

    fun readLogToFile() {
        /*
        从文件里读取上次的价格关键信息
         */
        val list: Map<String, String> = Yaml().loadAll(File("$coinType.yml").readText()) as Map<String, String>

    }
}