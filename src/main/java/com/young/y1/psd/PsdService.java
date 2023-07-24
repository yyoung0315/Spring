package com.young.y1.psd;

import java.util.List;

public interface PsdService {
	void insert(PsdVO vo);
	void delete(PsdVO vo);
	void update1(PsdVO vo);
	void update2(PsdVO vo);
	
	
	String selectImg(PsdVO vo);
	PsdVO edit(PsdVO vo);
	List<PsdVO> PsdList(PsdVO vo);

}
