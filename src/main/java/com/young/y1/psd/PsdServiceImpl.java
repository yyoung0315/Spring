package com.young.y1.psd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PsdServiceImpl implements PsdService{

	@Autowired
	private PsdDao dao;
	
	@Override
	public void insert(PsdVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public void delete(PsdVO vo) {
		dao.delete(vo);
		
	}

	@Override
	public String selectImg(PsdVO vo) {
		
		return dao.selectImg(vo);
	}

	@Override
	public List<PsdVO> PsdList(PsdVO vo) {
		
		return dao.PsdList(vo);
	}

	@Override
	public PsdVO edit(PsdVO vo) {

		return dao.edit(vo);
	}

	@Override
	public void update1(PsdVO vo) {
		dao.update1(vo);
		
	}

	@Override
	public void update2(PsdVO vo) {
		dao.update2(vo);
		
	}


}
