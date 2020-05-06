package com.competition.controller.token.refresh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.competition.common.ControllerResponse;
import com.competition.jpa.model.token.RefreshToken;
import com.competition.service.token.JwtService;
import com.competition.service.token.refresh.RefreshTokenService;
import com.competition.service.user.UserService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/service/refreshs")
public class RefreshTokenController {
	
	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private RefreshTokenService refreshTokenService;
	
//	@GetMapping("")
//	public <T extends Object> T createToken(String refreshToken, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ControllerResponse<Object> res = new ControllerResponse<Object>();
//		try {
//			
//			RefreshToken tokenInfo = refreshTokenService.seRefreshToken(refreshToken);
//			
//			CustomUserDetails user = (CustomUserDetails) userService.loadUserByUsername(tokenInfo.getUserName());
//			
//			String token = jwtService.createAccessToken(request, response, user, new Date(System.currentTimeMillis() + 1 * (1000 * 60 * 30)));
//			
//			res.setMessage("Success Create Token");
//			res.setResult(HttpStatus.OK);
//			res.setResult(token);
//		} catch (Exception e) {
//			res.setMessage(e.getMessage());
//			res.setResult(HttpStatus.INTERNAL_SERVER_ERROR);
//			res.setResult(e);
//		}
//		return (T) res;
//	}
	
	@GetMapping("")
	public <T extends Object> T seRefreshTokens() throws Exception{
		ControllerResponse<List<RefreshToken>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Refresh Tokens :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(refreshTokenService.seRefreshTokens());
		} catch (Exception e) {
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		return (T) res;
	}
	
	@GetMapping("/{token}")
	public <T extends Object> T seRefreshToken(String token) throws Exception{
		ControllerResponse<List<RefreshToken>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Search Refresh Token :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(refreshTokenService.seRefreshToken(token));
		} catch (Exception e) {
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		return (T) res;
	}
	@PostMapping("")
	public <T extends Object> T inRefreshToken(RefreshToken token) throws Exception{
		ControllerResponse<List<RefreshToken>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Insert Refresh Token :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(refreshTokenService.inRefreshToken(token));
		} catch (Exception e) {
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		return (T) res;
	}
	@PutMapping("/{token}")
	public <T extends Object> T upRefreshToken(RefreshToken token) throws Exception{
		ControllerResponse<List<RefreshToken>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Update Refresh Token :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(refreshTokenService.upRefreshToken(token));
		} catch (Exception e) {
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		return (T) res;
	}
	@DeleteMapping("/{token}")
	public <T extends Object> T deRefreshToken(RefreshToken token) throws Exception{
		ControllerResponse<List<RefreshToken>> res = new ControllerResponse<>();
		try {
			res.setMessage("Success Delete Refresh Token :) ");
			res.setResultCode(HttpStatus.OK);
			res.setResult(refreshTokenService.deRefreshToken(token));
		} catch (Exception e) {
			res.setMessage(e.getMessage());
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setResult(null);
		}
		return (T) res;
	}

}