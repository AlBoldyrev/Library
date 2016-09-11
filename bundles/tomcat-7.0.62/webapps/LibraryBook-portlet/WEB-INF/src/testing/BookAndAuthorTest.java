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

import com.liferay.portal.kernel.util.ParamUtil;





import static org.junit.Assert.*; 
import static org.mockito.Mockito.*;

public class BookAndAuthorTest {
	
	@Before
	public  void before() {
	}
	
	@Test
	public void testDeleteBook() {
    ActionRequest actionRequest = mock(ActionRequest.class); 
    ActionResponse renderResponse = mock(ActionResponse.class); 
	Mockito.mock(ParamUtil.class);
	Mockito.mock(BookLocalServiceUtil.class);
//	Mockito.when(actionRequest.).thenReturn(1);
	}
	
//	public void deleteBook(ActionRequest actionRequest, ActionResponse actionResponse)
//			throws SystemException,	PortalException {
//		long bookId = ParamUtil.getLong(actionRequest, "bookId");
//		BookLocalServiceUtil.deleteBook(bookId);
//		SessionMessages.add(actionRequest, "deleted-book");
//		log.info(DELETE_SUCCESS);
//	}
}
