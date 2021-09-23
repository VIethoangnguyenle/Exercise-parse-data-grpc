package com.example.ReadData.parser;

import com.example.proto.ReadData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class StockInfoParser extends BaseParser<ReadData.StockInfo> {
    private final Gson gson = new GsonBuilder().create();
    private static StockInfoParser instance;

    public StockInfoParser() {
    }

    @Override
    void sendMessage(ReadData.StockInfo message) {
      log.info("{}", gson.toJson(message));
    }

    @Override
    public void parseFrom(Map<Integer, String> data) {
        ReadData.StockInfo message = ReadData.StockInfo.newBuilder()
                .setSenderCompId(getString(data, 49))
                .setSymbol(getString(data, 55))
                .setSymbolId(getDecimal(data, 15))
                .setBoardCode(getString(data, 425))
                .setTradingSessionId(getString(data, 336))
                .setTradSesStatus(getString(data, 340))
                .setSecurityTradingStatus(getInt(data, 326))
                .setListingStatus(getInt(data, 327))
                .setSecurityType(getString(data, 167))
                .setIssueDate(getDate(data, 225))
                .setIssuer(getString(data, 106))
                .setSecurityDesc(getString(data, 107))
                .setBestBidPrice(getInt(data, 132))
                .setBestBidQtty(getInt(data, 1321))
                .setBestOfferPrice(getInt(data, 133))
                .setBestOfferQtty(getInt(data, 1331))
                .setTotalBidQtty(getDecimal(data, 134))
                .setTotalOfferQtty(getDecimal(data, 135))
                .setBasicPrice(getInt(data, 260))
                .setFloorPrice(getInt(data, 333))
                .setCeilingPrice(getInt(data, 332))
                .setFloorPricePt(getInt(data, 3331))
                .setCeilingPricePt(getInt(data, 3321))
                .setParValue(getInt(data, 334))
                .setMatchPrice(getInt(data, 31))
                .setMatchQtty(getInt(data, 32))
                .setOpenPrice(getInt(data, 137))
                .setPriorOpenPrice(getInt(data, 138))
                .setClosePrice(getInt(data, 139))
                .setPriorClosePrice(getInt(data, 140))
                .setTotalVolumeTraded(getDecimal(data, 387))
                .setTotalValueTraded(getDecimal(data, 3871))
                .setMidPx(getInt(data, 631))
                .setTradingDate(getDate(data, 388))
                .setTime(getString(data, 399))
                .setTradingUnit(getInt(data, 400))
                .setTotalListingQtty(getDecimal(data, 109))
                .setDateNo(getInt(data, 17))
                .setReferenceStatus(getString(data, 232))
                .setCurrentPrice(getInt(data, 255))
                .setCurrentQtty(getInt(data, 2551))
                .setHighestPrice(getInt(data, 266))
                .setLowestPrice(getInt(data, 2661))
                .setPriorPrice(getInt(data, 277))
                .setMatchValue(getDecimal(data, 310))
                .setOfferCount(getInt(data, 320))
                .setBidCount(getInt(data, 321))
                .setNmTotalTradedQtty(getDecimal(data, 391))
                .setNmTotalTradedValue(getDecimal(data, 392))
                .setPtMatchQtty(getDecimal(data, 393))
                .setPtMatchPrice(getInt(data, 3931))
                .setPtTotalTradedQtty(getDecimal(data, 394))
                .setPtTotalTradedValue(getDecimal(data, 3941))
                .setTotalBuyTradingQtty(getDecimal(data, 395))
                .setBuyCount(getInt(data, 3951))
                .setTotalBuyTradingValue(getDecimal(data, 3952))
                .setTotalSellTradingQtty(getDecimal(data, 396))
                .setSellCount(getInt(data, 3961))
                .setTotalSellTradingValue(getDecimal(data, 3962))
                .setBuyForeignQtty(getDecimal(data, 397))
                .setBuyForeignValue(getDecimal(data, 3971))
                .setSellForeignQtty(getDecimal(data, 398))
                .setSellForeignValue(getDecimal(data, 3981))
                .setRemainForeignQtty(getInt(data, 3301))
                .setTotalBidQttyOd(getDecimal(data, 1341))
                .setTotalOfferQttyOd(getDecimal(data, 1351))
                .build();
        sendMessage(message);
    }

    @Override
    public String getParserType() {
        return "SI";
    }

    public static void create() {
        if (instance == null) {
            instance = new StockInfoParser();
        }
    }
}
