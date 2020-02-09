package cc.home999.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.home999.book.bean.Reader;
import cc.home999.book.bean.ReaderAdmin;
import cc.home999.book.bean.ReaderAdminExample;
import cc.home999.book.bean.ReaderAdminExample.Criteria;
import cc.home999.book.dao.ReaderAdminMapper;

@Service
public class ReaderAdminService {
	
	@Autowired
	ReaderAdminMapper readerAdminMapper;
	
	public List<ReaderAdmin> getreaders(Reader reader) {
		// TODO 自动生成的方法存根
		ReaderAdminExample example = new ReaderAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andReadernoLike("%"+reader.getReaderno()+"%");
		criteria.andReadernameLike("%"+reader.getReadername()+"%");
		criteria.andSexLike("%"+reader.getSex()+"%");
		criteria.andIdentitycardLike("%"+reader.getIdentitycard()+"%");
		criteria.andWorkunitLike("%"+reader.getWorkunit()+"%");
		return readerAdminMapper.selectByExample(example);
	}
	
}
