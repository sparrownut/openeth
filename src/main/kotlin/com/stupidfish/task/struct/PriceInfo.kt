package com.stupidfish.task.struct

class PriceInfo(pminIN:Float,pmaxIN:Float,pbuyhistoryIN:Float,psellhistoryIN: Float,pM720statusIN: M720status,phisstatusIN: Phisstatus) {
    var pmin = pminIN
    var pmax = pmaxIN
    var pbuyhistory = pbuyhistoryIN
    var psellhistory = psellhistoryIN
    var p720mstatus = pM720statusIN//720M内是主体涨还是跌
    var phisstatus = phisstatusIN//上次是买还是卖
}