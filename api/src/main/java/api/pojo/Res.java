package api.pojo;

public class Res<T> {

    private StateCode state; // 状态码
    private T result;  // 当需要向小程序端返回数据，才设置该值

    public static final Res<Void> failure = new Res<>(StateCode.OPERATION_FAILURE);

    public static final Res<Void> offline = new Res<>(StateCode.SERVICE_OFFLINE);

    public Res(StateCode state) {
        this.state = state;
    }

    public Res(StateCode state, T result) {
        this.state = state;
        this.result = result;
    }

    public Res() {
    }

    public void setState(StateCode state) {
        this.state = state;
    }

    public StateCode getState() {
        return state;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
