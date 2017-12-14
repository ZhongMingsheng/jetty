package zms.study.bean;

import java.io.Serializable;

public class ResultDt<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String code="0";
	private Integer total;
	private T rows;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public T getRows() {
		return rows;
	}
	public void setRows(T rows) {
		this.rows = rows;
	}
	
}
