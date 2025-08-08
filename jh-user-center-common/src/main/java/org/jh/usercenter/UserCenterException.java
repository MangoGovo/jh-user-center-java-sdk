package org.jh.usercenter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author MangoGovo
 */
@Getter
@AllArgsConstructor
public enum UserCenterException {
    ServerError         (500, "系统异常，请稍后重试!"),
    ParamError          (501, "参数错误"),
    HttpTimeout         (505, "系统异常，请稍后重试!"),
    RequestError        (506, "系统异常，请稍后重试!"),
    NotFound            (404, "404 NOT FOUND"),
    Unknown             (500, "系统异常，请稍后重试!"),
    WrongPassword       (409, "统一系统密码错误"),
    NotActivatedError   (411, "统一系统账号未激活"),
    WrongAccount        (412, "统一系统账号错误"),
    ClosedError         (507, "统一身份认证夜间不对外开放"),
    UserNotFound        (400, "学号和身份证不存在或者不匹配"),
    PasswordLengthError (401, "密码长度不符合要求"),
    AuthError           (407, "密码错误"),
    UserAlreadyExit     (403, "用户已经存在"),
    UserNotExit         (404, "用户不存在");

    private final Integer code;
    private final String msg;

    public static UserCenterException fromCode(int code) {
        return Arrays.stream(UserCenterException.values())
                .filter(e -> e.code.equals(code))
                .findFirst()
                .orElse(null);
    }

}