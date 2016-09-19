package testing;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import builder.service.BookLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.softwerke.BookAndAuthor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import builder.model.Author;
import builder.model.Book;

public class TestDeleteBook {
	
	private BookAndAuthor portlet;
	private Book book;
	PortalException e = new PortalException();
	
	@Before
	public void setUp() {
		portlet = new BookAndAuthor();
	}
	
	
	@Test
	public void testDeleteBookOk() throws SystemException {
		 PowerMockito.mockStatic(BookLocalServiceUtil.class);
		 PowerMockito.mockStatic(CounterLocalServiceUtil.class);
	
		ActionRequest actionRequest = mock(ActionRequest.class);
		ActionResponse actionResponse = mock(ActionResponse.class);
	    
	     when(BookLocalServiceUtil.deleteBook(book)).thenReturn(null);
	     Book result = BookLocalServiceUtil.deleteBook(book);
		 assertEquals(result, null);
	}
	
	@Test(expected= Exception.class)
	public void testDeleteBookNotOk() throws SystemException {
		
		PowerMockito.mockStatic(BookLocalServiceUtil.class);
		PowerMockito.mockStatic(CounterLocalServiceUtil.class);
		ActionRequest actionRequest = mock(ActionRequest.class);
		ActionResponse actionResponse = mock(ActionResponse.class);
		when(BookLocalServiceUtil.deleteBook(book)).thenThrow(new PortalException());
		Book result = BookLocalServiceUtil.deleteBook(book);
		assertEquals(result, e);
		
	}

}


	
