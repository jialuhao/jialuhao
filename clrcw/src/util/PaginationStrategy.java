package util;

/**
 *<p>Title: </p>
 *
 *<p>Description:分页策略 </p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public class PaginationStrategy {
	//当前页索引
	private int currentPage;
	//默认每页显示行数
	public static final int PAGESIZE = 10;

	private int pageSize = PAGESIZE;
	//起始索引
	private int startIndex = 0;
	
	//总行数
	private int totalCount;
	
	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}
	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public PaginationStrategy(int startIndex,int pageSize,int totalCount){
		this.setStartIndex(startIndex);
		this.setPageSize(pageSize);
		this.setTotalCount(totalCount);
		
	}
	/**
	 * 
	 * 描述：得到上一页的索引
	 * @return
	 */
	public int getAllPreviousPageItemsCount(){
		
		
		return 0;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	
	public int getCurrentPage() {
		currentPage = getStartIndex() / pageSize + 1;
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
