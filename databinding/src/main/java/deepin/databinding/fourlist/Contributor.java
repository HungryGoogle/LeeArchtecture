package deepin.databinding.fourlist;

/**
 * 贡献者
 */
public class Contributor {
    private String avatar_url;  // 贡献者头像
    private String login;       // 贡献者名字
    private long contributions; // 贡献次数

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public long getContributions() {
        return contributions;
    }

    public void setContributions(long contributions) {
        this.contributions = contributions;
    }

    @Override
    public String toString() {
        return "login='" + login + '\'' +
                ", contributions=" + contributions +
                '\n';
    }
}
