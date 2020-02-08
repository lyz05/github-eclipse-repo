package cc.home999.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.home999.book.dao.BorrowMapper;

@Service
public class BorrowService {

	@Autowired
	BorrowMapper borrowMapper;
}
