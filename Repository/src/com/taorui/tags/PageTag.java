package com.taorui.tags;

import java.io.IOException;
import java.text.MessageFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;

public class PageTag extends SimpleTagSupport {
	private String url;
	private int curpage = 1;
	private int pagesize = 2;
	private int total;
	private int pages;
	private static final String INFO = "<span>{0}/{1} 共{2}条记录 </span>";
	private static final String URL = "<a href=\"{0}?curpage={1}&pagesize={2}\">{3}</a>";

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public void doTag() throws JspException, IOException {
		String first = MessageFormat.format(URL, url, 1, pagesize, "第一页");
		String pre = null;
		if (curpage <= 1) {
			pre = "<a href='javascript:void(0);'>上一页</a>";
		} else {
			pre = MessageFormat.format(URL, url, curpage - 1, pagesize, "上一页");
		}
		String next = null;
		if (curpage >= pages) {
			next = "<a href='javascript:void(0);'>下一页</a>";
		} else {
			next = MessageFormat.format(URL, url, curpage + 1, pagesize, "下一页");
		}
		String last = MessageFormat.format(URL, url, pages, pagesize, "最后一页");
		String info = MessageFormat.format(INFO, curpage, pages, total);
		String all = "<div>" + first + pre + next + last + info + "</div>";
		this.getJspContext().getOut().print(all);
	}

}
