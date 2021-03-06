package com.mercury.controller.word;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.common.ControllerResponse;
import com.mercury.jpa.model.word.Word;
import com.mercury.service.word.WordService;
import com.mercury.vo.word.WordVO;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/service/words")
public class WordController {

	@Autowired
	private WordService weekWordService;
	
	@GetMapping("")
	public <T extends Object> T getLists() throws Exception {
		ControllerResponse<List<Word>> res = new ControllerResponse<>();
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Get Week Word List :) "); 
			res.setResult(weekWordService.getLists());
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage()); 
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("/group")
	public <T extends Object> T getWeekWords(@Param(value = "group") String group) throws Exception {
		ControllerResponse<Word> res = new ControllerResponse<>();
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Get Week Word :) "); 
			res.setResult(weekWordService.getWeekWords(group));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage()); 
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@GetMapping("/{wordIdx}")
	public <T extends Object> T seWord(String wordIdx) throws Exception {
		ControllerResponse<Word> res = new ControllerResponse<>();
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Search Week Word :) "); 
			res.setResult(weekWordService.seWord(wordIdx));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage()); 
			res.setResult(null);
		}
		
		return (T) res;
	}
	
	@PostMapping("")
	public <T extends Object> T inWord(@RequestBody WordVO vo) throws Exception {
		ControllerResponse<Word> res = new ControllerResponse<>();
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Insert Week Word :) "); 
			res.setResult(weekWordService.inWord(vo));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage()); 
			res.setResult(null);
		}
		
		return (T) res;
	}
	@PutMapping("/{idx}")
	public <T extends Object> T upWord(@RequestBody WordVO vo) throws Exception {
		ControllerResponse<Word> res = new ControllerResponse<>();
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Update Week Word :) "); 
			res.setResult(weekWordService.upWord(vo));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage()); 
			res.setResult(null);
		}
		
		return (T) res;
	}
	@DeleteMapping("/{idx}")
	public <T extends Object> T deWord(@RequestBody WordVO vo) throws Exception {
		ControllerResponse<Boolean> res = new ControllerResponse<>();
		try {
			res.setResultCode(HttpStatus.OK);
			res.setMessage("Success Delete Week Word :) "); 
			res.setResult(weekWordService.deWord(vo));
		} catch (Exception e) {
			res.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setMessage(e.getMessage()); 
			res.setResult(null);
		}
		
		return (T) res;
	}
}
