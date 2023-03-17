package daixin.Bean;

import java.util.List;

public class Page<T> {
    public static final Integer PAGE_SIZE=4;

    //当前页码
    private Integer PageNo;
    //总页码
    private Integer PageTotal;
    //当前显示数量
    private Integer PageSize=PAGE_SIZE;
    //总记录数
    private Integer PageCount;
//当前的页面显示的数量获取
    private List<T> items;

    private String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageTotal() {
        return PageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        PageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public Integer getPageCount() {
        return PageCount;
    }

    public void setPageCount(Integer pageCount) {
        PageCount = pageCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
    public Integer getPageNo() {
        return PageNo;
    }

    public void setPageNo(Integer pageNo) {
        if(pageNo<1){
            pageNo=1;
        }
        if(pageNo>PageTotal){
            pageNo=PageTotal;
        }
        PageNo = pageNo;
    }

    @Override
    public String toString() {
        return "Page{" +
                "PageNo=" + PageNo +
                ", PageTotal=" + PageTotal +
                ", PageSize=" + PageSize +
                ", PageCount=" + PageCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
