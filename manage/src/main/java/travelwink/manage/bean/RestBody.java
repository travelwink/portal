package travelwink.manage.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestBody {
    private int code;
    private String msg;
    private Object data;

    public RestBody(int code) {
        this.code = code;
    }

    public static RestBody success(){
        RestBody restBody = new RestBody(1);
        return restBody;
    }

    public static RestBody success(Object data){
        RestBody restBody = new RestBody(1);
        restBody.msg = "成功";
        restBody.data = data;
        return restBody;
    }

    public static RestBody success(String msg, Object data){
        RestBody restBody = new RestBody(1);
        restBody.msg = msg;
        restBody.data = data;
        return restBody;
    }

    public static RestBody fail(String msg) {
        RestBody restBody = new RestBody(2);
        restBody.msg = msg;
        return  restBody;
    }

}
