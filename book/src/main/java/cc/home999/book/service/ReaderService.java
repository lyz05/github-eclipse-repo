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
	
	public boolean updatereader(Reader reader) {
		int count = readerMapper.updateByPrimaryKey(reader);
		return count==1 || count==0;
	}
	
	public Reader getreader(String readerno){
		return readerMapper.selectByPrimaryKey(readerno);
	}
	
	public boolean addreader(Reader reader) {
		int count = readerMapper.insert(reader);
		return count==1;
	}

	public boolean delreader(String readerno) {
		int count = readerMapper.deleteByPrimaryKey(readerno);
		return count==1;
	}
}
