package api.pojo;

public class StateCode {

    public static final StateCode INSERT_FAILURE =  new StateCode(500,"添加失败");
    public static final StateCode OPERATION_SUCCEED = new StateCode(200,"操作成功");
    public static final StateCode INVALIDPARAMETER = new StateCode(400,"参数不合法");
    public static final StateCode NOTLOGGEDIN = new StateCode(401,"请先登录再执行此项操作");
    public static final StateCode  TOKENEXPIRE = new StateCode(401,"登录已过期，请重新登录");
    public static final StateCode OPERATION_FAILURE = new StateCode(500,"操作失败");
    public static final StateCode REPEAT_NAME = new StateCode(400,"名称重复");

    private final int code;
    private final String describe;

    private StateCode(int code, String describe){
        this.code = code;
        this.describe = describe;
    }

    public int getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }
}
