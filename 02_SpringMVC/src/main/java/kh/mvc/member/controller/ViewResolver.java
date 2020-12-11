package kh.mvc.member.controller;

public class ViewResolver {
	public String prefix;
	public String suffix;
	
	public ViewResolver(String prefix, String suffix) {
		super();
		this.prefix = prefix;
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		return prefix+viewName+suffix;
	}
}
