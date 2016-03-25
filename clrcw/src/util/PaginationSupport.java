package util;

import java.util.List;

/**
 *<p>Title: 分页工具类</p>
 *
 *<p>Description: 利用QBC接口查询机制</p>
 *
 *<p>Company: 航天四创</p>
 *
 * @author 李滨
 *
 * @version 1.0
 */
public class PaginationSupport {

	//默认每页显示行数
	public static final int PAGESIZE = 10;

	private int pageSize = PAGESIZE;
	//分页结果集
	private List<?> items;
	//总行数
	private int totalCount;
	
	//总页数
	private int pageCount;
	//当前页号
	private int currentPage;
	
	//分页索引的数组 
	private int[] indexes = new int[0];
	//当前结果集开始索引
	private int startIndex = 0;
	//下一页索引
	private int nextIndex;
	//上一页索引
	private int previousIndex;
	//最后一页索引
	private int lastIndex;
	/**
	 * 
	 * @param items 结果集
	 * @param totalCount 总记录数
	 */
	public PaginationSupport(List<?> items, int totalCount) {
		setPageSize(PAGESIZE);
		setTotalCount(totalCount);
		setItems(items);
		setStartIndex(0);
	}

	/**
	 * 
	 * @param items 结果集
	 * @param totalCount 总记录数
	 * @param startIndex 当前结果集开始索引
	 */
	public PaginationSupport(List<?> items, int totalCount, int startIndex) {
		setPageSize(PAGESIZE);
		setTotalCount(totalCount);
		setItems(items);
		setStartIndex(startIndex);
	}

	/**
	 * 
	 * @param items 结果集
	 * @param totalCount 总记录数
	 * @param pageSize 每页显示行数
	 * @param startIndex 当前结果集开始索引
	 */
	public PaginationSupport(List<?> items, int totalCount, int pageSize,
			int startIndex) {
		setPageSize(pageSize);
		setTotalCount(totalCount);
		setItems(items);
		setStartIndex(startIndex);
	}

	/**
	 * 
	 * @param totalCount 总记录数
	 * @param pageSize 每页显示行数
	 * @param startIndex 当前结果集开始索引
	 */
	public PaginationSupport(int startIndex , int pageSize,
			int totalCount) {
		setPageSize(pageSize);
		setTotalCount(totalCount);
		setStartIndex(startIndex);
	}
	
	
	public List<?> getItems() {
		return items;
	}

	public void setItems(List<?> items) {
		this.items = items;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	/**
	 * ����õ��ܽ����
	 * 描述：得到总页数
	 * @return 
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 
	 * 描述：总记录数
	 * @param totalCount 总记录数
	 */
	public void setTotalCount(int totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			int count = totalCount / pageSize;
			if (totalCount % pageSize > 0)
				count++;
			indexes = new int[count];
			for (int i = 0; i < count; i++) {
				indexes[i] = pageSize * i;
			}
		} else {
			this.totalCount = 0;
		}
	}

	
	public int[] getIndexes() {
		return indexes;
	}

	
	public void setIndexes(int[] indexes) {
		this.indexes = indexes;
	}

	
	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		if (totalCount <= 0)
			this.startIndex = 0;
		else if (startIndex >= totalCount)
			this.startIndex = indexes[indexes.length - 1];
		else if (startIndex < 0)
			this.startIndex = 0;
		else {
			this.startIndex = indexes[startIndex / pageSize];
		}
	}

	/**
	 * ����������
	 * 描述：得到下一页索引号
	 * @return �����
	 */
	public int getNextIndex() {
		nextIndex = getStartIndex() + pageSize;
		if (nextIndex >= totalCount)
			return getStartIndex();
		else
			return nextIndex;
	}

	
	
	/**
	 * ����������
	 * 描述：得到上一页索引号
	 * @return �����
	 */
	public int getPreviousIndex() {
		previousIndex = getStartIndex() - pageSize;
		if (previousIndex < 0)
			return 0;
		else
			return previousIndex;
	}
	public void setNextIndex(int nextIndex) {
		  this.nextIndex = nextIndex;
		 }
	
	
	public void setPreviousIndex(int previousIndex) {
		this.previousIndex = previousIndex;
	}
		 
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public int getPageCount() {
		pageCount = totalCount / pageSize;
		if (totalCount % pageSize > 0)
			pageCount++;
		return pageCount;
	}
		 

	public int getCurrentPage() {
		currentPage = getStartIndex() / pageSize + 1;
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex =lastIndex ;
	}
	
	public int getLastIndex() {
		lastIndex = indexes[indexes.length-1];
		return lastIndex;
	}
}
