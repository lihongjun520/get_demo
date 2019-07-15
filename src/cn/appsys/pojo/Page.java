package cn.appsys.pojo;

public class Page {
	private int pageSize;
	private int currPageNo;
	private int totalPageCount;
	private int totalCount;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			// 根据总记录数以及每页显示的数据行数
			this.totalPageCount = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize
					: this.totalCount / this.pageSize + 1;
		}
	}
}
