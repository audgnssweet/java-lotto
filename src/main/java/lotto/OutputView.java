package lotto;

import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

public class OutputView {
    private static final String MATCH_WORDING = "%s개 일치(%s원)- %s개";
    private static final String TOTAL_MATCH_WORDING_LOSS = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String TOTAL_MATCH_WORDING_PROFIT = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 이득라는 의미임)";

    private static final String LOTTO_WIN_RESULT_WORDING = "당첨 통계\n---------";
    private static final String LOTTO_BUY_WORDING = "%s개를 구매했습니다.";

    public static void printBuyingCount(int num) {
        System.out.println(format(LOTTO_BUY_WORDING, num));
    }

    public static void outputLottoList(List<Lotto> lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            List<Integer> lottoNum = lottoList.get(i).lottoNum();
            Collections.sort(lottoNum);
            System.out.println(lottoNum);
        }
    }

    public static void printWinResult(LottoTicket lottoTicket) {
        System.out.println(LOTTO_WIN_RESULT_WORDING);
        String output = makeWinWords(lottoTicket);
        System.out.println(output);
    }

    private static String makeWinWords(LottoTicket lottoTicket) {
        String output = format(MATCH_WORDING, LottoWin.FOURTH_PLACE.matchNum(), LottoWin.FOURTH_PLACE.winPrice(), LottoStatistics.countLottoWinNumMatch(lottoTicket.lottoList(), LottoWin.FOURTH_PLACE)) + "\n";
        output += format(MATCH_WORDING, LottoWin.THIRD_PLACE.matchNum(), LottoWin.THIRD_PLACE.winPrice(), LottoStatistics.countLottoWinNumMatch(lottoTicket.lottoList(), LottoWin.THIRD_PLACE)) + "\n";
        output += format(MATCH_WORDING, LottoWin.SECOND_PLACE.matchNum(), LottoWin.SECOND_PLACE.winPrice(), LottoStatistics.countLottoWinNumMatch(lottoTicket.lottoList(), LottoWin.SECOND_PLACE)) + "\n";
        output += format(MATCH_WORDING, LottoWin.FIRST_PLACE.matchNum(), LottoWin.FIRST_PLACE.winPrice(), LottoStatistics.countLottoWinNumMatch(lottoTicket.lottoList(), LottoWin.FIRST_PLACE)) + "\n";
        double totalProfitRatio = LottoStatistics.calculateLottoTicketProfit(lottoTicket);
        if (totalProfitRatio >= 1) {
            output += format(TOTAL_MATCH_WORDING_PROFIT, totalProfitRatio);
            return output;
        }
        output += format(TOTAL_MATCH_WORDING_LOSS, totalProfitRatio);
        return output;
    }

}