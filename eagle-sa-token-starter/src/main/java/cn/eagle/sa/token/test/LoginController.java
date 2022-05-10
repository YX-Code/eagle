package cn.eagle.sa.token.test;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.eagle.sa.token.test.vo.LoginVO;
import cn.eagle.spring.webmvc.annotation.Api;
import cn.eagle.spring.webmvc.annotation.Url;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录测试 
 * @author kong
 *
 */
//@RestController
//@RequestMapping("/acc/")
@Api("acc")
public class LoginController {

	// 测试登录  ---- http://localhost:8081/acc/doLogin?name=zhang&pwd=123456
	@Url("doLogin")
	public SaResult doLogin(@RequestBody LoginVO loginVO) {
		// 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对 
		if(loginVO.getUserName().equals("yaojx") && "123456".equals(loginVO.getPassword())) {
			StpUtil.login(10001);
			return SaResult.ok("登录成功");
		}
		return SaResult.error("登录失败");
	}

	// 查询登录状态  ---- http://localhost:8081/acc/isLogin
	@RequestMapping("isLogin")
	public SaResult isLogin() {
		return SaResult.ok("是否登录：" + StpUtil.isLogin());
	}

	// 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
	@RequestMapping("tokenInfo")
	public SaResult tokenInfo() {
		return SaResult.data(StpUtil.getTokenInfo());
	}
	
	// 测试注销  ---- http://localhost:8081/acc/logout
	@RequestMapping("logout")
	public SaResult logout() {
		StpUtil.logout();
		return SaResult.ok();
	}
	
}
