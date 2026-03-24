package com.babyos.common.exception.user;

import com.babyos.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author babyos
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
