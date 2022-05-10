package cn.eagle.sa.token.view;

import cn.eagle.spring.webmvc.annotation.View;
import cn.eagle.spring.webmvc.annotation.Path;

@View
public class LoginView {
    /**
     * @return 登录页面
     */
    @Path("toLogin")
    public String login() {
        
        return "test";
    }
}
