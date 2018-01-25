package zms.study.annotation;



public enum Colors {

	RED("紅色"), GREEN("绿色"), GREY("灰色"), BLACK("黑色"), WHITE("白色");
	private String color;

	private Colors(String col) {
		color = col;
	}

	public String getColor() {
		return color;
	}
	/**
	 * private String color; 
	 * public static Colors RED = new Colors("红色");
	 * public static Colors GREEN = new Colors("绿色"); 
	 * public static Colors GREY = new Colors("灰色"); 
	 * public static Colors BLACK = new Colors("黑色"); 
	 * public static Colors WHITE = new Colors("白色"); 
	 * private Colors(String color){
	 * 	this.color = color; 
	 * }
	 * 
	 * @Override public String toString(){ return color; }
	 */
}
