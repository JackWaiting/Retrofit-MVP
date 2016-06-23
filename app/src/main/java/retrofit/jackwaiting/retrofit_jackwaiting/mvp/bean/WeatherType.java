package retrofit.jackwaiting.retrofit_jackwaiting.mvp.bean;

import java.util.List;


public class WeatherType  {

    private String resultcode;
    private String reason;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    private List<ResultEntity> result;

    public static class  ResultEntity {
        private String wid;
        private String weather;

        public String getWid() {
            return wid;
        }

        public void setWid(String wid) {
            this.wid = wid;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        @Override
        public String toString() {
            return "ResultEntity{" +
                    "wid='" + wid + '\'' +
                    ", weather='" + weather + '\'' +
                    '}';
        }
    }

    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
