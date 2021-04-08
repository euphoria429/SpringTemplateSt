package cn.hcx.dao;


import cn.hcx.bean.Account;
import cn.hcx.bean.Book;
import cn.hcx.bean.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

    @Resource
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}

    @Override
    public int findBookPriceByIsbn(String isbn) {
        String sql="select * from book where book_id=?";
        RowMapper<Book> rowMapper=new BeanPropertyRowMapper<>(Book.class);
        Book book=this.jdbcTemplate.queryForObject(sql,rowMapper,isbn);
        System.out.println("查询到本书价格为："+book.getPrice());
        return book.getPrice();
    }

    @Override
    public int updateBookStock(String isbn) {
        String sql="update bookstock set stock=stock-1 where book_id = ?";
        int num=this.jdbcTemplate.update(sql,isbn);
        if (num>0){
            System.out.println("成功更新书库存！");
        }else {
            System.out.println("修改操作执行失败！");
        }
        return num;
    }

    @Override
    public int updateUserAccount(String id, int price) {

        String sql="update account set money=money-? where id=?";
        Object[] params=new Object[]{price,id};
//        执行添加操作，返回的是受SQL语句影响的记录条数
        int num=this.jdbcTemplate.update(sql,params);
        if (num>0){
            System.out.println("成功从账户扣钱！");
        }else {
            System.out.println("修改操作执行失败！");
        }
        return num;
    }

    @Override
    public int findAccountById(String id) {
        String sql="select * from account where id = ?";
        RowMapper<Account>  rowMapper=new BeanPropertyRowMapper<>(Account.class);
        Account account=this.jdbcTemplate.queryForObject(sql,rowMapper,id);
        return account.getMoney();
    }

    @Override
    public int findStockByIsbn(String isbn) {
        String sql="select * from bookstock where book_id = ?";
        RowMapper<Book>  rowMapper=new BeanPropertyRowMapper<>(Book.class);
        Book book=this.jdbcTemplate.queryForObject(sql,rowMapper,isbn);
        return book.getStock();
    }
}
