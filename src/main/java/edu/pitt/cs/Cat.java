package edu.pitt.cs;

import java.util.Arrays;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;


public interface Cat {
	public static Cat createInstance(InstanceType type, int id, String name) {
		switch (type) {
			case IMPL:
				return new CatImpl(id, name);
			case BUGGY:
				return new CatBuggy(id, name);
			case SOLUTION:
				return new CatSolution(id, name);
			case MOCK:
				Cat c = Mockito.mock(Cat.class);
				Mockito.when(c.getId()).thenReturn(id);
				//Mockito.when(c.getName()).thenReturn(name);
				//Mockito.when(c.toString()).thenReturn("ID " + id + ". " + name);

				String[] mockName = {name};
				
				// doAnswer(new Answer<Void>() {
				// 	public Void answer(InvocationOnMock invocation) {
				// 		Object[] args = invocation.getArguments();
				// 		mockName[0] = (String) args[0];
				// 		return null;
				// 	}
				// }).when(c).renameCat(anyString());

				// doAnswer(new Answer<String>() {
				// 	public String answer(InvocationOnMock invocation) {
				// 		return mockName[0];
				// 	}
				// }).when(c).getName();

				// doAnswer(new Answer<String>() {
				// 	public String answer(InvocationOnMock invocation) {
				// 		return "ID " + id + ". " + mockName[0];
				// 	}
				// }).when(c).toString();

				doAnswer((invocation) -> { mockName[0] = (String) invocation.getArguments()[0]; return null;}).when(c).renameCat(anyString());
				doAnswer((invocation) -> { return mockName[0]; }).when(c).getName();
				doAnswer((invocation) -> { return "ID " + id + ". " + mockName[0]; }).when(c).toString();


				return c;
			default:
				assert (false);
				return null;
		}
	}

	// WARNING: You are not allowed to change any part of the interface.
	// That means you cannot add any method nor modify any of these methods.

	public void rentCat();

	public void returnCat();

	public void renameCat(String name);

	public String getName();

	public int getId();

	public boolean getRented();

	public String toString();
}
