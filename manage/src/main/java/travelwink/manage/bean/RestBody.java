package travelwink.manage.bean;

public class RestBody {
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public RestBody() {
    }

    public RestBody(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestBody success(String msg, Object data){
        return new RestBody(0, msg, data);
    }

    public RestBody fail(String msg, Object data) {
        return  new RestBody(2, msg, data);
    }

}
