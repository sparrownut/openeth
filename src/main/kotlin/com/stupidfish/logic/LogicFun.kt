package com.stupidfish.logic

import com.stupidfish.task.struct.M720status.DOWN
import com.stupidfish.task.struct.M720status.UP
import com.stupidfish.task.struct.Phisstatus.BUY
import com.stupidfish.task.struct.Phisstatus.SELL
import com.stupidfish.task.struct.PriceInfo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs

class LogicFun(coinTypeIN: String) {
    val coinType = coinTypeIN
    fun logicMachine(
        va: Float,
        vb: Float,
        buyFunction: () -> Unit,
        sellFunction: () -> Unit,
        priceInfoSourceFunction: () -> PriceInfo
    ) {//买入函数和卖出函数
        /*
        两个参数是连接效应器的通道 可以连实际买卖 也可以连接模拟
         */
        GlobalScope.launch {
            /*
            这里是逻辑器的主体部分 用协程运行
             */
            delay(1000 * 60 * 720)//720m一次循环

            //这里要调用PriceManager的getOncePrice 获取价格 然后进行逻辑处理
            val info: PriceInfo = priceInfoSourceFunction()//获取数据
            val pmin = info.pmin//最低价格
            val pmax = info.pmax//最高价格
            val price = info.price//价格
            val pbuyhistory = info.pbuyhistory//历史买的价格
            val psellhistory = info.psellhistory//历史卖的价格
            val p720Mstatus = info.p720Mstatus//720M内是主体涨还是跌
            val phisStatus = info.phisStatus//上次是买还是卖
            //这几个变量都要从info中获取
            when (phisStatus) {
                BUY -> {
                    if ((abs(price - pmax) / price) > (va / 100) && p720Mstatus == DOWN && price / pbuyhistory > vb) {
                        sellFunction()
                    }
                }
                SELL -> {
                    if (abs(price - pmin) / price > (va / 100) && p720Mstatus == UP && price < (pmax + pmin) / 2 && price < psellhistory) {//price < psellhistory 是后添加的 意思是价格低于 上次卖出的价格才买
                        buyFunction()
                    }
                }
            }

        }
    }
}