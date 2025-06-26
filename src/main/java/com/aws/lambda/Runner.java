package com.aws.lambda;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class Runner {
	
	public static void main(String[] args) {
		
		LambdaHandler handler = new LambdaHandler();

		// Create a mock context
		Context context = new Context() {
			@Override
			public String getAwsRequestId() {
				return "test-request-id";
			}

			@Override
			public String getLogGroupName() {
				return "test-log-group";
			}

			@Override
			public String getLogStreamName() {
				return "test-log-stream";
			}

			@Override
			public String getFunctionName() {
				return "test-function";
			}

			@Override
			public String getFunctionVersion() {
				return "1.0";
			}

			@Override
			public String getInvokedFunctionArn() {
				return "test-arn";
			}

			@Override
			public CognitoIdentity getIdentity() {
				return null;
			}

			@Override
			public ClientContext getClientContext() {
				return null;
			}

			@Override
			public int getRemainingTimeInMillis() {
				return 300000;
			}

			@Override
			public int getMemoryLimitInMB() {
				return 512;
			}

			@Override
			public LambdaLogger getLogger() {
				return new LambdaLogger() {
					@Override
					public void log(String message) {
						System.out.println("LOG: " + message);
					}

					@Override
					public void log(byte[] message) {
						System.out.println("LOG (bytes): " + new String(message));
					}
				};
			}
		};

		// Run the Lambda handler locally
		String result = handler.handleRequest("World", context);
		System.out.println("Result: " + result);
	}
}
