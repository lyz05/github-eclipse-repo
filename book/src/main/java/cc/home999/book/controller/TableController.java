package cc.home999.book.controller;

import cc.home999.book.bean.*;
import cc.home999.book.model.BookReaderModel;
import cc.home999.book.model.TableModel;
import cc.home999.book.service.BookAdminService;
import cc.home999.book.service.BookReaderService;
import cc.home999.book.service.BorrowReaderService;
import cc.home999.book.service.ReaderAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("Table")
public class TableController {


    @Autowired
    BorrowReaderService borrowReaderService;
    @Autowired
    BookReaderService bookReaderService;


    /**
     * 获取读者借阅信息Table
     *
     * @param table
     * @return
     */
    @RequestMapping("borrowreaders")
    public TableModel borrowreaders(String table, HttpSession session) {
        User user = (User) session.getAttribute("user");
        boolean isnull = table.equals("Borrow");
        List<BorrowReader> borrowReaders = borrowReaderService.getborrowReaders(user.getUsername(), isnull);
        int total = borrowReaders.size();
        return new TableModel(total, borrowReaders);
    }

    /**
     * 获取读者看到的图书Table
     *
     * @param book
     * @return
     */
    @RequestMapping("bookreaders")
    public TableModel bookreaders(BookReaderModel book, HttpSession session) {
        //System.out.println(book);
        User user = (User) session.getAttribute("user");
        List<String> booknos = borrowReaderService.getbooknosnotreturn(user.getUsername());
        List<BookReader> rows = bookReaderService.getbookreaders(book, booknos);
        int total = rows.size();
        return new TableModel(total, rows);
    }
}
