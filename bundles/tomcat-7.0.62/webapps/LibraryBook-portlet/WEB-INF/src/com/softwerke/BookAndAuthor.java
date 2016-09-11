package com.softwerke;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import builder.model.Author;
import builder.model.Book;
import builder.service.AuthorLocalServiceUtil;
import builder.service.BookLocalServiceUtil;
import builder.service.impl.BookLocalServiceImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


/**
 * Portlet implementation class BookAndAuthor
 */
public class BookAndAuthor extends MVCPortlet  implements com.liferay.portal.kernel.util.WebKeys{

	private Log log = LogFactoryUtil.getLog(BookAndAuthor.class.getName());
	 
	public static final String VIEW = "view";
	public static final String ADD_BOOK = "add_book";
	public static final String ADD_AUTHOR = "add_author";
	public static final String EDIT_BOOK = "edit_book";  
	public static final String VIEW_BOOK = "view_book";
	
	private static final String VIEW_PAGE_PATH = "/html/view.jsp";
	private static final String ADD_BOOK_PAGE_PATH = "/html/add_book.jsp";
	private static final String ADD_AUTHOR_PAGE_PATH = "/html/add_author.jsp";
	private static final String EDIT_BOOK_PAGE_PATH = "/html/edit_book.jsp";
	private static final String VIEW_BOOK_PAGE_PATH = "/html/view_book.jsp";
	
	public static final String BOOK_ENTRY = "bookEntry";
	public static final String BOOK = "bookEditAttribute";
	public static final String BOOK_ID = "bookId";
	
	public static final String DELETE_SUCCESS = "Deleted Book Successfully";
	public static final String UPDATE_SUCCESS = "Updated Book Successfully";
	
	public static final String MISTAKE_ATTRIBUTES = "There was a mistake in setting attributes to request";
	
	public static final String PORTAL_EXCEPTION_VIEW_BOOK = "There was PortalException when trying to view book";
	public static final String PORTAL_EXCEPTION_EDIT_BOOK = "There was PortalException when trying to edit book";
	public static final String SYSTEM_EXCEPTION_VIEW_BOOK = "There was SystemException when trying to view book";
	public static final String SYSTEM_EXCEPTION_EDIT_BOOK = "There was SystemException when trying to edit book";
	
	public static final String ADD_BOOK_NOT_NULL = "The book was NOT NULL when you tried to add one";
	public static final String ADD_BOOK_NULL = "The book was NULL when you tried to add one";
	public static final String ADD_AUTHOR_NOT_NULL = "The author was NOT NULL when you tried to add one";
	public static final String ADD_AUTHOR_NULL = "The author was NULL when you tried to add one";
	public static final String ADD_BOOK_ERROR = "There was an error while adding book. It was last 'catch' block";
	
	
	
	/**
	 * String pageName - it's main parameter on which rendering different .jsp files. <br>
	 * <br>
	 * First `try-catch` block fills the list of books and authors with necessary data and sets parameters which can be taken in jsp's. <br>
	 * <br>
	 * Next there are multiple if-else constructions which renders particular jsp in dependence of parameter. There are 5 different situations: <br>
	 * ADD_BOOK - just render particular jsp<br>
	 * ADD_AUTHOR - just render particular jsp<br>
	 * EDIT_BOOK - get the particular book and it's ID, then render edit_book.jsp <br>
	 * VIEW_BOOK - get the particular book and it's ID, then render view_book.jsp <br>
	 * VIEW - if there is no special parameter view.jsp should be rendered.
	 * 
	 * 
	 * @param request It's our RenderRequest
	 * @param response It's our RenderResponse
	 * @throws PortletException
	 * @throws IOException
	 * @return Nothing, just rendering pages.
	 */
	
	
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		
		String pageName = request.getParameter("pageName");
		
		try {
			List<Book> bookList = BookLocalServiceUtil.getBooks(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			List<Author> authorList = AuthorLocalServiceUtil.getAuthors(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
//			Author author = AuthorLocalServiceUtil.getAuthor(book.getAuthorId());
//			String authorNamee = author.getAuthorName();
//			long count = BookLocalServiceUtil.countByAuthor(authorId);
//			
			
			request.setAttribute("bookListArray", bookList);
			request.setAttribute("authorListArray", authorList);
		} catch (SystemException e) {
			SessionErrors.add(request, "SystemException");
			log.info(MISTAKE_ATTRIBUTES, e);
		}
	    	
		if (ADD_BOOK.equalsIgnoreCase(pageName)) {
			include(ADD_BOOK_PAGE_PATH, request, response);
		} else if (ADD_AUTHOR.equalsIgnoreCase(pageName)) {
			include(ADD_AUTHOR_PAGE_PATH, request, response);
		} else if (EDIT_BOOK.equalsIgnoreCase(pageName)) {
			try {
				long bookId = ParamUtil.getLong(request, "bookId");
				Book book = BookLocalServiceUtil.getBook(bookId);
				request.setAttribute(BOOK, book);
				request.setAttribute(BOOK_ID, book.getBookId());
			} catch (PortalException e) {
				SessionErrors.add(request, "PortalExceptionError");
				log.info(PORTAL_EXCEPTION_EDIT_BOOK, e);
			} catch (SystemException e) {
				SessionErrors.add(request, "SystemExceptionError");
				log.info(SYSTEM_EXCEPTION_EDIT_BOOK, e);
			} 
			include(EDIT_BOOK_PAGE_PATH, request, response);
		} else if (VIEW_BOOK.equalsIgnoreCase(pageName)) {
			try {
				long bookId = ParamUtil.getLong(request, "bookId");
				Book book = BookLocalServiceUtil.getBook(bookId);
				request.setAttribute(BOOK_ENTRY, book);
			} catch (PortalException e) {
				SessionErrors.add(request, "PortalExceptionError");
				log.info(PORTAL_EXCEPTION_VIEW_BOOK, e);
			} catch (SystemException e) {
				SessionErrors.add(request, "SystemExceptionError");
				log.info(SYSTEM_EXCEPTION_VIEW_BOOK, e);
			} 
			include(VIEW_BOOK_PAGE_PATH, request, response);
		} else {
			
			include(VIEW_PAGE_PATH, request, response);
		}    
	}
	
	/**
	 * This method adds book in your database. It's called when you submit "add book" form.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 * @throws SystemException
	 * @throws PortalException
	 * @return Nothing
	 */
	
	public void addBook(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws IOException, PortletException, SystemException {
		String bookName = ParamUtil.getString(actionRequest,"bookName");
		String bookDescription = ParamUtil.getString(actionRequest, "bookDescription");
		long authorId = ParamUtil.getLong(actionRequest, "author");
		String authorName = ParamUtil.getString(actionRequest, "author");

		Book book = BookLocalServiceUtil.createBook(CounterLocalServiceUtil.increment());
		book.setBookName(bookName);
		book.setBookDescription(bookDescription);
		book.setAuthorId(authorId);
		book.setAuthorName(authorName);
		book=BookLocalServiceUtil.addBook(book);
	
//			Author author = AuthorLocalServiceUtil.getAuthor(book.getAuthorId());
//			String authorName = author.getAuthorName();
//			long authorId = ParamUtil.getLong(actionRequest, "author");
//			long[] bookIds = new long[] {book.getBookId()};
//			
//			BookLocalServiceUtil.addAuthorBooks(authorId, bookIds);
	}
	
	/**
	 * This method adds author in your database. It's called when you submit "add author" form.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 * @throws SystemException
	 * @throws PortalException
	 * @return Nothing
	 */
	
	public void addAuthor(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws IOException, PortletException, SystemException {
			
		String authorName=ParamUtil.getString(actionRequest,"authorName");
		Author author=AuthorLocalServiceUtil.createAuthor(CounterLocalServiceUtil.increment());
		author.setAuthorName(authorName);
		author=AuthorLocalServiceUtil.addAuthor(author);		
	}
	
	
	/**
	 * This method deletes particular book in your database. It's called when you push "Delete" button in the action bar.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 * @throws SystemException
	 * @throws PortalException
	 * @return Nothing
	 */

	public void deleteBook(ActionRequest actionRequest, ActionResponse actionResponse)
			throws SystemException,	PortalException {
		long bookId = ParamUtil.getLong(actionRequest, "bookId");
		BookLocalServiceUtil.deleteBook(bookId);
		SessionMessages.add(actionRequest, "deleted-book");
		log.info(DELETE_SUCCESS);
	}
	
	/**
	 * This method deletes particular author in your database. It's called when you push "Delete" button.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 * @throws SystemException
	 * @throws PortalException
	 * @return Nothing
	 */
	
	public void deleteAuthor(ActionRequest actionRequest, ActionResponse actionResponse)
			throws SystemException,	PortalException {
		long authorId = ParamUtil.getLong(actionRequest, "authorId");
		AuthorLocalServiceUtil.deleteAuthor(authorId);
		SessionMessages.add(actionRequest, "deleted-author");
		log.info(DELETE_SUCCESS);
	
	}
	
	/**
	 * This method edits particular book in your database. It's called when you push "Edit Book" button in edit form.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 * @throws SystemException
	 * @throws PortalException
	 * @return Nothing
	 */
	
	public void updateBook(ActionRequest actionRequest,	ActionResponse actionResponse)
			throws SystemException,	PortalException {
		long bookId = (Long) actionRequest.getAttribute("bookId");
		Book book=BookLocalServiceUtil.createBook(CounterLocalServiceUtil.increment());
	
		book.setBookName(ParamUtil.getString(actionRequest, "bookName", ""));
		book.setBookDescription(ParamUtil.getString(actionRequest, "description", ""));
		book.setBookId(bookId);
		
		BookLocalServiceUtil.updateBook(book);
		SessionMessages.add(actionRequest, "updated-book"); 
		log.info(UPDATE_SUCCESS);
		
	}
}
