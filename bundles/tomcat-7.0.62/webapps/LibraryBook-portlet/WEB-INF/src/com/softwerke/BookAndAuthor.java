package com.softwerke;

import java.io.IOException;
import java.util.ArrayList;
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
	
	public static final String DELETE_SUCCESS = "Deleting was successful!";
	public static final String DELETE_ERROR = "There was a mistake while trying to delete something";
	
	public static final String UPDATE_SUCCESS = "Updated Book Successfully";
	public static final String UPDATE_BOOK_ID_IS_NULL ="BookId was NULL";
	
	public static final String MISTAKE_ATTRIBUTES = "There was a mistake in setting attributes to request";
	
	public static final String PORTAL_EXCEPTION_VIEW_BOOK = "There was PortalException when trying to view book";
	public static final String PORTAL_EXCEPTION_EDIT_BOOK = "There was PortalException when trying to edit book";
	public static final String SYSTEM_EXCEPTION_VIEW_BOOK = "There was SystemException when trying to view book";
	public static final String SYSTEM_EXCEPTION_EDIT_BOOK = "There was SystemException when trying to edit book";
	
	public static final String ADD_BOOK_NAME_NULL = "The bookName was NULL when you tried to add one";
	public static final String ADD_BOOK_DESCRIPTION_NULL = "The bookDescription was NULL when you tried to add one";
	public static final String ADD_BOOK_AUTHOR_ID_NULL = "The bookAuthorId was NULL when you tried to add one";
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
	
		if (ADD_BOOK.equalsIgnoreCase(pageName)) {
			List<AuthorModel> authorModelList;
			try {
				authorModelList = getAllAuthors();
				request.setAttribute("authorModels", authorModelList);
			} catch (SystemException e) {
				log.error("Couldn't get author's list. " + e.getMessage());
				SessionErrors.add(request, "Internal error. Please try later.");
			}
		
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
			try {
				List<Book> bookList = BookLocalServiceUtil.getBooks(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				List<BookModel> bookModelList = new ArrayList<BookModel>();
				
				for (int i=0; i<bookList.size(); i++) {
					Book currentBook = bookList.get(i);
					BookModel bookModel = new BookModel();
					
					bookModel.setBookDescription(currentBook.getBookDescription());
					bookModel.setBookName(currentBook.getBookName());
					bookModel.setBookId(currentBook.getBookId());
					
					long authorId = currentBook.getAuthorId();
					Author author;
					try {
						author = AuthorLocalServiceUtil.getAuthor(authorId);
						bookModel.setAuthorName(author.getAuthorName());
					} catch (PortalException e) {
						// TODO handle exception
					}
				
					
					bookModelList.add(bookModel);
				}
				List<AuthorModel> authorModelList = getAllAuthors();
				request.setAttribute("bookModels", bookModelList);
				request.setAttribute("authorModels", authorModelList);
				
			} catch (SystemException e) {
				SessionErrors.add(request, "SystemException");
				log.info(MISTAKE_ATTRIBUTES, e);
			}
			include(VIEW_PAGE_PATH, request, response);
		}    
	}
			
	private List<AuthorModel> getAllAuthors() throws SystemException{
		List<AuthorModel> authors = new ArrayList<AuthorModel>();
		List<Author> authorList = AuthorLocalServiceUtil.getAuthors(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Author author : authorList) {
			authors.add(new AuthorModel(author));
		}
		return authors;
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
			throws IOException, PortletException, SystemException, PortalException {
		String bookName = ParamUtil.getString(actionRequest,"bookName");
		String bookDescription = ParamUtil.getString(actionRequest, "bookDescription");
		long authorId = ParamUtil.getLong(actionRequest, "author");
		Book book = BookLocalServiceUtil.createBook(CounterLocalServiceUtil.increment());
		
		Author tableAuthor = AuthorLocalServiceUtil.getAuthor(authorId);  
	  	String authorName = tableAuthor.getAuthorName();
	  	
		if (bookName != null) {
			book.setBookName(bookName);
		} else {
			SessionErrors.add(actionRequest, "bookNameisNull");
			log.info(ADD_BOOK_NAME_NULL);
		}
		
		if (bookDescription != null){
			book.setBookDescription(bookDescription);
		} else {
			SessionErrors.add(actionRequest, "bookDescriptionisNull");
			log.info(ADD_BOOK_DESCRIPTION_NULL);
		} 
		if (authorId != 0) {
			book.setAuthorId(authorId);
		} else {
			SessionErrors.add(actionRequest, "bookAuthorIdisNull");
			log.info(ADD_BOOK_AUTHOR_ID_NULL);
		}
		book=BookLocalServiceUtil.addBook(book);
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
		if (authorName == null) {
			SessionErrors.add(actionRequest, "authorNameisNull");
			log.info(ADD_AUTHOR_NULL);
		}
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

	public void deleteBook(ActionRequest actionRequest,	ActionResponse actionResponse)
			throws SystemException, PortalException {
		long bookId = ParamUtil.getLong(actionRequest, "bookId", 0);
		if (bookId == 0) {
			log.error("BookId is not defined");
			SessionErrors.add(actionRequest, "bookIsNull");
			return;
		}
		try {
			BookLocalServiceUtil.deleteBook(bookId);
			SessionMessages.add(actionRequest, "deleted-book");
		} catch (PortalException | SystemException e) {
			log.error("Failed to delete book with id: " + bookId + ". "	+ e.getMessage());
			SessionErrors.add(actionRequest, "bookIsNull");
		}

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
		if (authorId != 0) {
			AuthorLocalServiceUtil.deleteAuthor(authorId);
			SessionMessages.add(actionRequest, "deleted-author");
			log.info(DELETE_SUCCESS);
		} else {
			SessionErrors.add(actionRequest, "authorIsNull");
			log.info(DELETE_ERROR);
		}
		
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
		long bookId = ParamUtil.getLong(actionRequest, "bookId", 0);
		
		Book book = BookLocalServiceUtil.createBook(CounterLocalServiceUtil.increment());
		
		book.setBookName(ParamUtil.getString(actionRequest, "bookName", ""));
		book.setBookDescription(ParamUtil.getString(actionRequest, "description", ""));
		book.setAuthorId(ParamUtil.getLong(actionRequest, "author", 0));
		
		book.setBookId(bookId);
		
		BookLocalServiceUtil.updateBook(book);
		SessionMessages.add(actionRequest, "updated-book"); 
		log.info(UPDATE_SUCCESS);
		
	}
	
}
