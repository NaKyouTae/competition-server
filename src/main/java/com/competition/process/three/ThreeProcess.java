package com.competition.process.three;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.competition.jpa.model.love.Love;
import com.competition.jpa.model.three.Three;
import com.competition.jpa.model.user.User;
import com.competition.jpa.repository.love.LoveRepository;
import com.competition.jpa.repository.three.ThreeRepository;
import com.competition.jpa.repository.user.UserRepository;
import com.competition.jpa.repository.word.WordRepository;
import com.competition.jpa.repository.word.WordRepository.WordInter;
import com.competition.util.DateUtil;

@Component
@SuppressWarnings("unchecked")
public class ThreeProcess {

	@Autowired
	private ThreeRepository threeRepository;

	@Autowired
	private WordRepository weekWordRepository;
	
	@Autowired
	private LoveRepository loveRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public <T extends Object> T getPopular() throws Exception {
		try {
			WordInter dto = weekWordRepository.findByWord("THREE");
			
			return (T) threeRepository.findByWordIdx(dto.getIdx(), Sort.by(Sort.Direction.DESC, "point"));
		} catch (Exception e) {
			return(T) e;
		}
	}
	
	public <T extends Object> T getList() throws Exception {
		WordInter dto = weekWordRepository.findByWord("THREE");
		
		List<Three> three = threeRepository.findByWordIdx(dto.getIdx(), Sort.by(Sort.Direction.DESC, "insertDate"));
		
		return (T) three;
	}

	public <T extends Object> T inThree(Three three) throws Exception {
		return (T) threeRepository.save(three);
	}
	public <T extends Object> T upThree(Three three) throws Exception {
		
		Three dbThree = threeRepository.findByIdx(three.getIdx());
		
		if(!dbThree.getPoint().equals(three.getPoint())) {
			
			Love love = new Love();
			love.setIdx(UUID.randomUUID().toString().replace("-", ""));
			love.setInsertDate(DateUtil.now());
			love.setContentIdx(three.getIdx());
			
			User user = userRepository.findByUsername(three.getLoveName());
			
			love.setUserIdx(user.getIdx());
			
			loveRepository.save(love);
			three.setLoveName("");
		}
		
		return (T) threeRepository.save(three);
	}
	public void deThree(Three three) throws Exception {
		threeRepository.delete(three);
	}
}
