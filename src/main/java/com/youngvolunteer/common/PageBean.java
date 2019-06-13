package com.youngvolunteer.common;

import java.util.List;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-04-30 23:06
 * @Describe：
 **/
public class PageBean<T> {
    /**
     *当前页数
     */
    private int currPage;
    /**
     * 每页显示的记录数
     */
    private int pageSize = 15;
    /**
     * 总计录数
     */
    private int total;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 每页显示的数据
     */
    private List<T> rows;

        public int getCurrPage() {
            return currPage;
        }
        public PageBean<T> setCurrPage(int currPage) {
            this.currPage = currPage;
            return this;
        }
        public int getPageSize() {
            return pageSize;
        }
        public PageBean<T>  setPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }
        public int getTotal() {
            return total;
        }
        public PageBean<T>  setTotal(int total) {
            this.total = total;
            return this;
        }
        public int getTotalPage() {
            return totalPage;
        }
        public PageBean<T>  setTotalPage(int totalPage) {
            this.totalPage = totalPage;
            return this;
        }
        public List<T> getRows() {
            return rows;
        }
        public PageBean<T>  setRows(List<T> rows) {
            this.rows = rows;
            return this;
        }

    @Override
    public String toString() {
        return "PageBean{" +
                "currPage=" + currPage +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", totalPage=" + totalPage +
                ", rows=" + rows +
                '}';
    }
}
