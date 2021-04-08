package cn.hcx.service;

import cn.hcx.aspect.MyLog;
import cn.hcx.dao.BookDao;
import cn.hcx.dao.BookDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository("bookService")
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    @MyLog(value = "购买图书")
    public void purchase(String userId, String isbn)
    {
        //获取图书价格
        int price = bookDao.findBookPriceByIsbn(isbn);

//        判断库存是否足够
        if(bookDao.findStockByIsbn(isbn)<=0){
            throw new RuntimeException("该书库存不足！");
        }
        //更新图书库存,购买书目*1=库存-1
        bookDao.updateBookStock(isbn);

//        判断是否够钱
        if (bookDao.findAccountById(userId)<price)
        {
            throw new RuntimeException("账户余额不足！");
        }

        //更新用户余额。account.money-price;
        bookDao.updateUserAccount(userId, price);

    }
}
