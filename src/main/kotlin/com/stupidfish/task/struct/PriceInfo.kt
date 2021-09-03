package com.stupidfish.task.struct

class PriceInfo(
    pminIN: Float,
    pmaxIN: Float,
    priceIN: Float,
    pbuyhistoryIN: Float,
    psellhistoryIN: Float,
    pM720statusIN: M720status,
    phisstatusIN: Phisstatus
) {
    var pmin = pminIN
    var pmax = pmaxIN
    var price = priceIN
    var pbuyhistory = pbuyhistoryIN
    var psellhistory = psellhistoryIN
    var p720Mstatus = pM720statusIN//720M内是主体涨还是跌
    var phisStatus = phisstatusIN//上次是买还是卖
}