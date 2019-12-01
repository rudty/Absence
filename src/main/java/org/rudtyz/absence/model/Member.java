package org.rudtyz.absence.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Member {

    @Id
    @NotNull
    @Size(min = 2, max = 24)
    private String userId;

    @Valid
    @NotNull
    @Size(min = 2, max = 24)
    private String nickname;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userId='" + userId + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
