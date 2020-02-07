package cc.home999.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.home999.book.bean.Reader;
import cc.home999.book.dao.ReaderMapper;

@Service
public class ReaderService {
	
	@Autowired
	ReaderMapper readerMapper;
	
	public String getReadername(String readerno) {
		Reader reader = readerMapper.selectByPrimaryKey(readerno);
		return reader.getReadername();
	}
}
