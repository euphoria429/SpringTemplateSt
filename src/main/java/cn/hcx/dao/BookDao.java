package cn.hcx.dao;

public interface BookDao {
    public int findBookPriceByIsbn(String isbn);
    public int updateBookStock(String isbn);
    public int updateUserAccount(String id, int price);
    public int findAccountById(String id);
    public int findStockByIsbn(String isbn);
}
