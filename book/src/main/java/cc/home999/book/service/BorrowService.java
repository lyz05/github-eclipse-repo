package cc.home999.book.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.home999.book.bean.Borrow;
import cc.home999.book.bean.BorrowExample;
import cc.home999.book.bean.BorrowExample.Criteria;
import cc.home999.book.dao.BorrowMapper;

@Service
public class BorrowService {

	@Autowired
	BorrowMapper borrowMapper;
	
	public boolean addBorrow(String bookno,String readerno) {
		Borrow record = new Borrow(readerno, bookno);
		int count = borrowMapper.insert(record);
		return count==1;
	}
	
	/**
	 * 读者是否借过未还这本书
	 * @param bookno
	 * @param readerno
	 */
	public boolean haveBorrow(String bookno,String readerno) {
		BorrowExample example = new BorrowExample();
		Criteria criteria = example.createCriteria();
		criteria.andBooknoEqualTo(bookno)
				.andReadernoEqualTo(readerno)
				.andReturndateIsNull();
		return borrowMapper.countByExample(example)>0;
	}

	public boolean retBorrow(String bookno,String readerno) {
		BorrowExample example = new BorrowExample();
		Criteria criteria = example.createCriteria();
		criteria.andBooknoEqualTo(bookno)
				.andReadernoEqualTo(readerno)
				.andReturndateIsNull();
		Borrow record = new Borrow();
		record.setReturndate(new Date());
		return borrowMapper.updateByExampleSelective(record, example)==1;
	}

	public boolean renewBorrow(String bookno, String readerno) {
		BorrowExample example = new BorrowExample();
		Criteria criteria = example.createCriteria();
		criteria.andBooknoEqualTo(bookno)
				.andReadernoEqualTo(readerno)
				.andReturndateIsNull();
		//续一个月
		Date nowdate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowdate);
		cal.add(Calendar.MONTH, 1);
		//构造新的Borrow
		Borrow record = new Borrow();
		record.setShoulddate(cal.getTime());
		return borrowMapper.updateByExampleSelective(record , example)==1;
	}
}
