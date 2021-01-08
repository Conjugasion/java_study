package Json;

import java.io.Serializable;

/**
 * @author:zhengwulin
 * @date:2020/4/20
 * @description:
 */
public class LivingConfigDto implements Serializable {
    private static final long serialVersionUID = -1982893779572941440L;

    // 日期id
    private String dateId;

    // tabId
    private String tabId;

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }

    public String getDateId() {
        return dateId;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    @Override
    public String toString() {
        return "{" +
                "dateId='" + dateId + '\'' +
                ", tabId='" + tabId + '\'' +
                '}';
    }
}
