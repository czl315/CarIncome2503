package ttjj.dao;

import ttjj.dto.FundTrade;

import java.util.List;

/**
 * 交易服务
 */
public interface TradeDao {
    List<FundTrade> findFundTrade(String fundCode, String cookie);

    List<FundTrade> findMyTrade(String cookie, String fundCode, String startDate, String endDate, String busType, String pageIndex);
}
