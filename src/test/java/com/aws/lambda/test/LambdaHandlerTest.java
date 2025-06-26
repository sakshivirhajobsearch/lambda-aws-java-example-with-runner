package com.aws.lambda.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.aws.lambda.LambdaHandler;

class LambdaHandlerTest {

	@Test
	void testHandleRequest() {
		LambdaHandler handler = new LambdaHandler();

		Context context = Mockito.mock(Context.class);
		LambdaLogger logger = new LambdaLogger() {
			@Override
			public void log(String message) {
				System.out.println("LOG: " + message);
			}

			@Override
			public void log(byte[] message) {
				System.out.println("LOG (bytes): " + new String(message));
			}
		};
		Mockito.when(context.getLogger()).thenReturn(logger);

		String result = handler.handleRequest("World", context);

		// ✅ Make sure this matches your Lambda output
		assertEquals("Hello, World! This is a Java Lambda Function.", result);
	}
}
