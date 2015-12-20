package practicework

import geb.spock.GebSpec
import practicework.pages.ReserveConfirmGebPage
import practicework.pages.ReserveInputGebPage
import util.CalendarUtility

class PracticeWork2Spec extends GebSpec {
    def "OneCanReserveWith9Members"() {
        when:
        ReserveInputGebPage reserveInputGebPage = browser.to ReserveInputGebPage

        // 現在のシステム日付を起点に明日以降の直近の土曜日を取得します
        Calendar immediateSaturday = CalendarUtility.getImmediateDayOfWeek(Calendar.getInstance(), Calendar.SATURDAY)
        int reserveYear = immediateSaturday.get(Calendar.YEAR)
        int reserveMonth = immediateSaturday.get(Calendar.MONTH) + 1
        int reserveDay = immediateSaturday.get(Calendar.DAY_OF_MONTH)

        // 上記で取得した直近の土曜日を使用します
        reserveInputGebPage.setReserveDate(reserveYear, reserveMonth, reserveDay)
        reserveInputGebPage.reserveTerm = "1"

        // TODO 残りの処理を記述してください

        then:
        ReserveConfirmGebPage reserveConfirmGebPage = browser.at ReserveConfirmGebPage

        reserveConfirmGebPage.price.text()  == "105750"
        reserveConfirmGebPage.dateFrom.text() == reserveYear + "年" + reserveMonth + "月" + reserveDay + "日"
        reserveConfirmGebPage.dateTo.text() == reserveYear + "年" + reserveMonth + "月" + (reserveDay + 1) + "日"
        reserveConfirmGebPage.daysCount.text() == "1"

        // TODO 残りの処理を記述してください
   }
}
