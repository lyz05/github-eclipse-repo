package cc.home999.book.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.home999.book.bean.BorrowReader;
import cc.home999.book.bean.BorrowReaderExample;
import cc.home999.book.bean.BorrowReaderExample.Criteria;
import cc.home999.book.dao.BorrowReaderMapper;

@Service
public class BorrowReaderService {

	@Autowired
	BorrowReaderMapper borrowReaderMapper;

	public List<BorrowReader> getborrowReaders(String readerno,boolean isnull) {
		BorrowReaderExample example = new BorrowReaderExample();
		Criteria criteria = example.createCriteria();
		criteria.andReadernoEqualTo(readerno);
		if (isnull) criteria.andReturndateIsNull();
		else criteria.andReturndateIsNotNull();
		return borrowReaderMapper.selectByExample(example);
	}
	
	public List<String> getbooknosnotreturn(String readerno){
		BorrowReaderExample example = new BorrowReaderExample();
		Criteria criteria = example.createCriteria();
		criteria.andReadernoEqualTo(readerno);
		criteria.andReturndateIsNull();
		List<BorrowReader> borrowreaders = borrowReaderMapper.selectByExample(example);
		List<String> booknos = borrowreaders.stream().map(BorrowReader::getBookno).collect(Collectors.toList());
		return booknos;
	}
}
