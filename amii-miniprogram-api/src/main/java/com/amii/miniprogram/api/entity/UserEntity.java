package com.amii.miniprogram.api.entity;

public class UserEntity
{
    private String nickname;
    private String phone;

    public UserEntity ()
    {
        super();
    }

    /**
     * TODO: 构造函数
     *
     * @param nickname
     * @param phone
     */
    public UserEntity (String nickname, String phone)
    {
        super();
        this.nickname = nickname;
        this.phone = phone;
    }

    public String getNickname ()
    {
        return nickname;
    }

    public void setNickname (String nickname)
    {
        this.nickname = nickname;
    }

    public String getPhone ()
    {
        return phone;
    }

    public void setPhone (String phone)
    {
        this.phone = phone;
    }
}
